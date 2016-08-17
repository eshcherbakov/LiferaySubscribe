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

package ru.inrecolan.subscribe.model.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ru.inrecolan.subscribe.model.service.http.SubscribeServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       ru.inrecolan.subscribe.model.service.http.SubscribeServiceSoap
 * @generated
 */
public class SubscribeSoap implements Serializable {
	public static SubscribeSoap toSoapModel(Subscribe model) {
		SubscribeSoap soapModel = new SubscribeSoap();

		soapModel.setSubscribeId(model.getSubscribeId());
		soapModel.setEmail(model.getEmail());
		soapModel.setSubscribeDate(model.getSubscribeDate());
		soapModel.setIsActivated(model.getIsActivated());

		return soapModel;
	}

	public static SubscribeSoap[] toSoapModels(Subscribe[] models) {
		SubscribeSoap[] soapModels = new SubscribeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscribeSoap[][] toSoapModels(Subscribe[][] models) {
		SubscribeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscribeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscribeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscribeSoap[] toSoapModels(List<Subscribe> models) {
		List<SubscribeSoap> soapModels = new ArrayList<SubscribeSoap>(models.size());

		for (Subscribe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscribeSoap[soapModels.size()]);
	}

	public SubscribeSoap() {
	}

	public long getPrimaryKey() {
		return _subscribeId;
	}

	public void setPrimaryKey(long pk) {
		setSubscribeId(pk);
	}

	public long getSubscribeId() {
		return _subscribeId;
	}

	public void setSubscribeId(long subscribeId) {
		_subscribeId = subscribeId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getSubscribeDate() {
		return _subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		_subscribeDate = subscribeDate;
	}

	public boolean getIsActivated() {
		return _isActivated;
	}

	public boolean isIsActivated() {
		return _isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		_isActivated = isActivated;
	}

	private long _subscribeId;
	private String _email;
	private Date _subscribeDate;
	private boolean _isActivated;
}