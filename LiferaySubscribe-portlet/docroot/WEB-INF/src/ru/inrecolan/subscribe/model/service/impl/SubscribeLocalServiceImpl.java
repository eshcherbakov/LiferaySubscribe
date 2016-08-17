/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.inrecolan.subscribe.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import ru.inrecolan.subscribe.SubscribeUtils;
import ru.inrecolan.subscribe.model.NoSuchSubscribeException;
import ru.inrecolan.subscribe.model.model.Subscribe;
import ru.inrecolan.subscribe.model.service.SubscribeLocalServiceUtil;
import ru.inrecolan.subscribe.model.service.SubscribeServiceUtil;
import ru.inrecolan.subscribe.model.service.base.SubscribeLocalServiceBaseImpl;
import ru.inrecolan.subscribe.model.service.persistence.SubscribePersistenceImpl;
import ru.inrecolan.subscribe.model.service.persistence.SubscribeUtil;

/**
 * The implementation of the subscribe local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.inrecolan.subscribe.model.service.SubscribeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ru.inrecolan.subscribe.model.service.base.SubscribeLocalServiceBaseImpl
 * @see ru.inrecolan.subscribe.model.service.SubscribeLocalServiceUtil
 */
public class SubscribeLocalServiceImpl extends SubscribeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ru.inrecolan.subscribe.model.service.SubscribeLocalServiceUtil} to access the subscribe local service.
	 */
	/*
	  <column name="subscribeId" type="long" primary="true"></column>
		<column name="email" type="String"></column>
		<column name="subscribeDate" type="Date"></column>
		<column name="isActivated" type="boolean"></column>
	*/
	
	public Subscribe addSubscribe (String email, boolean isActivated) {
		// adds or returns a Subscribe if it already exists
		Subscribe subscribe = null;
		subscribe = getSubscribe(email);
			
		if (subscribe == null) {
			try {
				long subscribeId = counterLocalService.increment();
				subscribe =  SubscribeLocalServiceUtil.createSubscribe(subscribeId);
				subscribe.setEmail(email);
				subscribe.setIsActivated(isActivated);
				subscribe.setSubscribeDate(new Date());
				SubscribeLocalServiceUtil.addSubscribe(subscribe);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		}
		return subscribe;
	}
	
	public Subscribe getSubscribe(String email) {
		Subscribe subscribe = null;
		if (email!=null && SubscribeUtils.validateEmail(email))
		{
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Subscribe.class)
					.add(PropertyFactoryUtil.forName("email").eq(email));
		
			List<Subscribe> subscribes;
			try {
				subscribes = (List<Subscribe>)SubscribeLocalServiceUtil.dynamicQuery(dynamicQuery);
				if (subscribes.size()>0) {
					subscribe = subscribes.get(0);
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		return subscribe;
	}
	
	public List<Subscribe> getActiveSubscribes() {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Subscribe.class)
				.add(PropertyFactoryUtil.forName("isActivated").eq(true));
		try {
			return SubscribeLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Subscribe>();
	}
	
	public void unsubscribe (String subscribeId) throws NumberFormatException, SystemException, NoSuchSubscribeException
	{
		FinderCacheUtil.clearCache(Subscribe.class.getName());
		
		Subscribe someSubscribe = SubscribeUtil.getPersistence().findByPrimaryKey(Long.parseLong(subscribeId));
		List<Subscribe> subscribes = SubscribeUtil.getPersistence().findByemail(someSubscribe.getEmail());
		for (Subscribe subscribe : subscribes)
		{
			SubscribeUtil.getPersistence().remove(subscribe);
		}
	}
	
	public void confirmSubscribe (String subscribeId) throws NoSuchSubscribeException, NumberFormatException, SystemException
	{
		FinderCacheUtil.clearCache(Subscribe.class.getName());
		
		Subscribe someSubscribe = SubscribeUtil.getPersistence().findByPrimaryKey(Long.parseLong(subscribeId));
		List<Subscribe> subscribes = SubscribeUtil.getPersistence().findByemail(someSubscribe.getEmail());
		for (Subscribe subscribe : subscribes)
		{
			subscribe.setIsActivated(true);
			SubscribeUtil.getPersistence().update(subscribe, true);
		}
	}
}