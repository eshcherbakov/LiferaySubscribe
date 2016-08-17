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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Subscribe}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Subscribe
 * @generated
 */
public class SubscribeWrapper implements Subscribe, ModelWrapper<Subscribe> {
	public SubscribeWrapper(Subscribe subscribe) {
		_subscribe = subscribe;
	}

	public Class<?> getModelClass() {
		return Subscribe.class;
	}

	public String getModelClassName() {
		return Subscribe.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subscribeId", getSubscribeId());
		attributes.put("email", getEmail());
		attributes.put("subscribeDate", getSubscribeDate());
		attributes.put("isActivated", getIsActivated());

		return attributes;
	}

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

	/**
	* Returns the primary key of this subscribe.
	*
	* @return the primary key of this subscribe
	*/
	public long getPrimaryKey() {
		return _subscribe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subscribe.
	*
	* @param primaryKey the primary key of this subscribe
	*/
	public void setPrimaryKey(long primaryKey) {
		_subscribe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the subscribe ID of this subscribe.
	*
	* @return the subscribe ID of this subscribe
	*/
	public long getSubscribeId() {
		return _subscribe.getSubscribeId();
	}

	/**
	* Sets the subscribe ID of this subscribe.
	*
	* @param subscribeId the subscribe ID of this subscribe
	*/
	public void setSubscribeId(long subscribeId) {
		_subscribe.setSubscribeId(subscribeId);
	}

	/**
	* Returns the email of this subscribe.
	*
	* @return the email of this subscribe
	*/
	public java.lang.String getEmail() {
		return _subscribe.getEmail();
	}

	/**
	* Sets the email of this subscribe.
	*
	* @param email the email of this subscribe
	*/
	public void setEmail(java.lang.String email) {
		_subscribe.setEmail(email);
	}

	/**
	* Returns the subscribe date of this subscribe.
	*
	* @return the subscribe date of this subscribe
	*/
	public java.util.Date getSubscribeDate() {
		return _subscribe.getSubscribeDate();
	}

	/**
	* Sets the subscribe date of this subscribe.
	*
	* @param subscribeDate the subscribe date of this subscribe
	*/
	public void setSubscribeDate(java.util.Date subscribeDate) {
		_subscribe.setSubscribeDate(subscribeDate);
	}

	/**
	* Returns the is activated of this subscribe.
	*
	* @return the is activated of this subscribe
	*/
	public boolean getIsActivated() {
		return _subscribe.getIsActivated();
	}

	/**
	* Returns <code>true</code> if this subscribe is is activated.
	*
	* @return <code>true</code> if this subscribe is is activated; <code>false</code> otherwise
	*/
	public boolean isIsActivated() {
		return _subscribe.isIsActivated();
	}

	/**
	* Sets whether this subscribe is is activated.
	*
	* @param isActivated the is activated of this subscribe
	*/
	public void setIsActivated(boolean isActivated) {
		_subscribe.setIsActivated(isActivated);
	}

	public boolean isNew() {
		return _subscribe.isNew();
	}

	public void setNew(boolean n) {
		_subscribe.setNew(n);
	}

	public boolean isCachedModel() {
		return _subscribe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_subscribe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _subscribe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _subscribe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subscribe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subscribe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subscribe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubscribeWrapper((Subscribe)_subscribe.clone());
	}

	public int compareTo(ru.inrecolan.subscribe.model.model.Subscribe subscribe) {
		return _subscribe.compareTo(subscribe);
	}

	@Override
	public int hashCode() {
		return _subscribe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ru.inrecolan.subscribe.model.model.Subscribe> toCacheModel() {
		return _subscribe.toCacheModel();
	}

	public ru.inrecolan.subscribe.model.model.Subscribe toEscapedModel() {
		return new SubscribeWrapper(_subscribe.toEscapedModel());
	}

	public ru.inrecolan.subscribe.model.model.Subscribe toUnescapedModel() {
		return new SubscribeWrapper(_subscribe.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subscribe.toString();
	}

	public java.lang.String toXmlString() {
		return _subscribe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subscribe.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscribeWrapper)) {
			return false;
		}

		SubscribeWrapper subscribeWrapper = (SubscribeWrapper)obj;

		if (Validator.equals(_subscribe, subscribeWrapper._subscribe)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Subscribe getWrappedSubscribe() {
		return _subscribe;
	}

	public Subscribe getWrappedModel() {
		return _subscribe;
	}

	public void resetOriginalValues() {
		_subscribe.resetOriginalValues();
	}

	private Subscribe _subscribe;
}