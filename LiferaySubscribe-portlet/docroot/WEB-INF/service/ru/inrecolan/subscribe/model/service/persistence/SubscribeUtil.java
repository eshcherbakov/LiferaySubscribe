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

package ru.inrecolan.subscribe.model.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.inrecolan.subscribe.model.model.Subscribe;

import java.util.List;

/**
 * The persistence utility for the subscribe service. This utility wraps {@link SubscribePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscribePersistence
 * @see SubscribePersistenceImpl
 * @generated
 */
public class SubscribeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Subscribe subscribe) {
		getPersistence().clearCache(subscribe);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Subscribe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subscribe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subscribe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Subscribe update(Subscribe subscribe, boolean merge)
		throws SystemException {
		return getPersistence().update(subscribe, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Subscribe update(Subscribe subscribe, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(subscribe, merge, serviceContext);
	}

	/**
	* Caches the subscribe in the entity cache if it is enabled.
	*
	* @param subscribe the subscribe
	*/
	public static void cacheResult(
		ru.inrecolan.subscribe.model.model.Subscribe subscribe) {
		getPersistence().cacheResult(subscribe);
	}

	/**
	* Caches the subscribes in the entity cache if it is enabled.
	*
	* @param subscribes the subscribes
	*/
	public static void cacheResult(
		java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> subscribes) {
		getPersistence().cacheResult(subscribes);
	}

	/**
	* Creates a new subscribe with the primary key. Does not add the subscribe to the database.
	*
	* @param subscribeId the primary key for the new subscribe
	* @return the new subscribe
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe create(
		long subscribeId) {
		return getPersistence().create(subscribeId);
	}

	/**
	* Removes the subscribe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscribeId the primary key of the subscribe
	* @return the subscribe that was removed
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe remove(
		long subscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence().remove(subscribeId);
	}

	public static ru.inrecolan.subscribe.model.model.Subscribe updateImpl(
		ru.inrecolan.subscribe.model.model.Subscribe subscribe, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subscribe, merge);
	}

	/**
	* Returns the subscribe with the primary key or throws a {@link ru.inrecolan.subscribe.model.NoSuchSubscribeException} if it could not be found.
	*
	* @param subscribeId the primary key of the subscribe
	* @return the subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe findByPrimaryKey(
		long subscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence().findByPrimaryKey(subscribeId);
	}

	/**
	* Returns the subscribe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subscribeId the primary key of the subscribe
	* @return the subscribe, or <code>null</code> if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe fetchByPrimaryKey(
		long subscribeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(subscribeId);
	}

	/**
	* Returns all the subscribes where email = &#63;.
	*
	* @param email the email
	* @return the matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByemail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemail(email);
	}

	/**
	* Returns a range of all the subscribes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of subscribes
	* @param end the upper bound of the range of subscribes (not inclusive)
	* @return the range of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByemail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemail(email, start, end);
	}

	/**
	* Returns an ordered range of all the subscribes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of subscribes
	* @param end the upper bound of the range of subscribes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByemail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemail(email, start, end, orderByComparator);
	}

	/**
	* Returns the first subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe findByemail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence().findByemail_First(email, orderByComparator);
	}

	/**
	* Returns the first subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe fetchByemail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByemail_First(email, orderByComparator);
	}

	/**
	* Returns the last subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe findByemail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence().findByemail_Last(email, orderByComparator);
	}

	/**
	* Returns the last subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe fetchByemail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByemail_Last(email, orderByComparator);
	}

	/**
	* Returns the subscribes before and after the current subscribe in the ordered set where email = &#63;.
	*
	* @param subscribeId the primary key of the current subscribe
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe[] findByemail_PrevAndNext(
		long subscribeId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence()
				   .findByemail_PrevAndNext(subscribeId, email,
			orderByComparator);
	}

	/**
	* Returns all the subscribes where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @return the matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByisActivated(
		boolean isActivated)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByisActivated(isActivated);
	}

	/**
	* Returns a range of all the subscribes where isActivated = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isActivated the is activated
	* @param start the lower bound of the range of subscribes
	* @param end the upper bound of the range of subscribes (not inclusive)
	* @return the range of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByisActivated(
		boolean isActivated, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByisActivated(isActivated, start, end);
	}

	/**
	* Returns an ordered range of all the subscribes where isActivated = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isActivated the is activated
	* @param start the lower bound of the range of subscribes
	* @param end the upper bound of the range of subscribes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByisActivated(
		boolean isActivated, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByisActivated(isActivated, start, end, orderByComparator);
	}

	/**
	* Returns the first subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe findByisActivated_First(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence()
				   .findByisActivated_First(isActivated, orderByComparator);
	}

	/**
	* Returns the first subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe fetchByisActivated_First(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByisActivated_First(isActivated, orderByComparator);
	}

	/**
	* Returns the last subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe findByisActivated_Last(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence()
				   .findByisActivated_Last(isActivated, orderByComparator);
	}

	/**
	* Returns the last subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe fetchByisActivated_Last(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByisActivated_Last(isActivated, orderByComparator);
	}

	/**
	* Returns the subscribes before and after the current subscribe in the ordered set where isActivated = &#63;.
	*
	* @param subscribeId the primary key of the current subscribe
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.subscribe.model.model.Subscribe[] findByisActivated_PrevAndNext(
		long subscribeId, boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException {
		return getPersistence()
				   .findByisActivated_PrevAndNext(subscribeId, isActivated,
			orderByComparator);
	}

	/**
	* Returns all the subscribes.
	*
	* @return the subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subscribes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of subscribes
	* @param end the upper bound of the range of subscribes (not inclusive)
	* @return the range of subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subscribes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of subscribes
	* @param end the upper bound of the range of subscribes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subscribes where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemail(email);
	}

	/**
	* Removes all the subscribes where isActivated = &#63; from the database.
	*
	* @param isActivated the is activated
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByisActivated(boolean isActivated)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByisActivated(isActivated);
	}

	/**
	* Removes all the subscribes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subscribes where email = &#63;.
	*
	* @param email the email
	* @return the number of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemail(email);
	}

	/**
	* Returns the number of subscribes where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @return the number of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByisActivated(boolean isActivated)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByisActivated(isActivated);
	}

	/**
	* Returns the number of subscribes.
	*
	* @return the number of subscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubscribePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubscribePersistence)PortletBeanLocatorUtil.locate(ru.inrecolan.subscribe.model.service.ClpSerializer.getServletContextName(),
					SubscribePersistence.class.getName());

			ReferenceRegistry.registerReference(SubscribeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SubscribePersistence persistence) {
	}

	private static SubscribePersistence _persistence;
}