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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.inrecolan.subscribe.model.service.ClpSerializer;
import ru.inrecolan.subscribe.model.service.SubscribeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class SubscribeClp extends BaseModelImpl<Subscribe> implements Subscribe {
	public SubscribeClp() {
	}

	public Class<?> getModelClass() {
		return Subscribe.class;
	}

	public String getModelClassName() {
		return Subscribe.class.getName();
	}

	public long getPrimaryKey() {
		return _subscribeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSubscribeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_subscribeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subscribeId", getSubscribeId());
		attributes.put("email", getEmail());
		attributes.put("subscribeDate", getSubscribeDate());
		attributes.put("isActivated", getIsActivated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subscribeId = (Long)attributes.get("subscribeId");

		if (subscribeId != null) {
			setSubscribeId(subscribeId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date subscribeDate = (Date)attributes.get("subscribeDate");

		if (subscribeDate != null) {
			setSubscribeDate(subscribeDate);
		}

		Boolean isActivated = (Boolean)attributes.get("isActivated");

		if (isActivated != null) {
			setIsActivated(isActivated);
		}
	}

	public long getSubscribeId() {
		return _subscribeId;
	}

	public void setSubscribeId(long subscribeId) {
		_subscribeId = subscribeId;

		if (_subscribeRemoteModel != null) {
			try {
				Class<?> clazz = _subscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscribeId", long.class);

				method.invoke(_subscribeRemoteModel, subscribeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;

		if (_subscribeRemoteModel != null) {
			try {
				Class<?> clazz = _subscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_subscribeRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getSubscribeDate() {
		return _subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		_subscribeDate = subscribeDate;

		if (_subscribeRemoteModel != null) {
			try {
				Class<?> clazz = _subscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscribeDate", Date.class);

				method.invoke(_subscribeRemoteModel, subscribeDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getIsActivated() {
		return _isActivated;
	}

	public boolean isIsActivated() {
		return _isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		_isActivated = isActivated;

		if (_subscribeRemoteModel != null) {
			try {
				Class<?> clazz = _subscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActivated", boolean.class);

				method.invoke(_subscribeRemoteModel, isActivated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubscribeRemoteModel() {
		return _subscribeRemoteModel;
	}

	public void setSubscribeRemoteModel(BaseModel<?> subscribeRemoteModel) {
		_subscribeRemoteModel = subscribeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _subscribeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_subscribeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SubscribeLocalServiceUtil.addSubscribe(this);
		}
		else {
			SubscribeLocalServiceUtil.updateSubscribe(this);
		}
	}

	@Override
	public Subscribe toEscapedModel() {
		return (Subscribe)ProxyUtil.newProxyInstance(Subscribe.class.getClassLoader(),
			new Class[] { Subscribe.class }, new AutoEscapeBeanHandler(this));
	}

	public Subscribe toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		SubscribeClp clone = new SubscribeClp();

		clone.setSubscribeId(getSubscribeId());
		clone.setEmail(getEmail());
		clone.setSubscribeDate(getSubscribeDate());
		clone.setIsActivated(getIsActivated());

		return clone;
	}

	public int compareTo(Subscribe subscribe) {
		long primaryKey = subscribe.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscribeClp)) {
			return false;
		}

		SubscribeClp subscribe = (SubscribeClp)obj;

		long primaryKey = subscribe.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{subscribeId=");
		sb.append(getSubscribeId());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", subscribeDate=");
		sb.append(getSubscribeDate());
		sb.append(", isActivated=");
		sb.append(getIsActivated());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("ru.inrecolan.subscribe.model.model.Subscribe");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subscribeId</column-name><column-value><![CDATA[");
		sb.append(getSubscribeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscribeDate</column-name><column-value><![CDATA[");
		sb.append(getSubscribeDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActivated</column-name><column-value><![CDATA[");
		sb.append(getIsActivated());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _subscribeId;
	private String _email;
	private Date _subscribeDate;
	private boolean _isActivated;
	private BaseModel<?> _subscribeRemoteModel;
}