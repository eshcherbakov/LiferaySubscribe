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

package ru.inrecolan.subscribe.model.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.inrecolan.subscribe.model.model.Subscribe;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Subscribe in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Subscribe
 * @generated
 */
public class SubscribeCacheModel implements CacheModel<Subscribe>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{subscribeId=");
		sb.append(subscribeId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", subscribeDate=");
		sb.append(subscribeDate);
		sb.append(", isActivated=");
		sb.append(isActivated);
		sb.append("}");

		return sb.toString();
	}

	public Subscribe toEntityModel() {
		SubscribeImpl subscribeImpl = new SubscribeImpl();

		subscribeImpl.setSubscribeId(subscribeId);

		if (email == null) {
			subscribeImpl.setEmail(StringPool.BLANK);
		}
		else {
			subscribeImpl.setEmail(email);
		}

		if (subscribeDate == Long.MIN_VALUE) {
			subscribeImpl.setSubscribeDate(null);
		}
		else {
			subscribeImpl.setSubscribeDate(new Date(subscribeDate));
		}

		subscribeImpl.setIsActivated(isActivated);

		subscribeImpl.resetOriginalValues();

		return subscribeImpl;
	}

	public long subscribeId;
	public String email;
	public long subscribeDate;
	public boolean isActivated;
}