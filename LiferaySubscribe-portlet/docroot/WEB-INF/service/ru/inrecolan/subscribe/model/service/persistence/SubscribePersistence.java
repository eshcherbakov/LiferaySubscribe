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

import com.liferay.portal.service.persistence.BasePersistence;

import ru.inrecolan.subscribe.model.model.Subscribe;

/**
 * The persistence interface for the subscribe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscribePersistenceImpl
 * @see SubscribeUtil
 * @generated
 */
public interface SubscribePersistence extends BasePersistence<Subscribe> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubscribeUtil} to access the subscribe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the subscribe in the entity cache if it is enabled.
	*
	* @param subscribe the subscribe
	*/
	public void cacheResult(
		ru.inrecolan.subscribe.model.model.Subscribe subscribe);

	/**
	* Caches the subscribes in the entity cache if it is enabled.
	*
	* @param subscribes the subscribes
	*/
	public void cacheResult(
		java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> subscribes);

	/**
	* Creates a new subscribe with the primary key. Does not add the subscribe to the database.
	*
	* @param subscribeId the primary key for the new subscribe
	* @return the new subscribe
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe create(long subscribeId);

	/**
	* Removes the subscribe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscribeId the primary key of the subscribe
	* @return the subscribe that was removed
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe remove(long subscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	public ru.inrecolan.subscribe.model.model.Subscribe updateImpl(
		ru.inrecolan.subscribe.model.model.Subscribe subscribe, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subscribe with the primary key or throws a {@link ru.inrecolan.subscribe.model.NoSuchSubscribeException} if it could not be found.
	*
	* @param subscribeId the primary key of the subscribe
	* @return the subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe findByPrimaryKey(
		long subscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns the subscribe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subscribeId the primary key of the subscribe
	* @return the subscribe, or <code>null</code> if a subscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe fetchByPrimaryKey(
		long subscribeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subscribes where email = &#63;.
	*
	* @param email the email
	* @return the matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByemail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByemail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByemail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe findByemail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns the first subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe fetchByemail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe findByemail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns the last subscribe in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe fetchByemail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public ru.inrecolan.subscribe.model.model.Subscribe[] findByemail_PrevAndNext(
		long subscribeId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns all the subscribes where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @return the matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByisActivated(
		boolean isActivated)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByisActivated(
		boolean isActivated, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findByisActivated(
		boolean isActivated, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe findByisActivated_First(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns the first subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe fetchByisActivated_First(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe
	* @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe findByisActivated_Last(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns the last subscribe in the ordered set where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscribe, or <code>null</code> if a matching subscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.subscribe.model.model.Subscribe fetchByisActivated_Last(
		boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public ru.inrecolan.subscribe.model.model.Subscribe[] findByisActivated_PrevAndNext(
		long subscribeId, boolean isActivated,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.subscribe.model.NoSuchSubscribeException;

	/**
	* Returns all the subscribes.
	*
	* @return the subscribes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.subscribe.model.model.Subscribe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subscribes where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subscribes where isActivated = &#63; from the database.
	*
	* @param isActivated the is activated
	* @throws SystemException if a system exception occurred
	*/
	public void removeByisActivated(boolean isActivated)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subscribes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subscribes where email = &#63;.
	*
	* @param email the email
	* @return the number of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countByemail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subscribes where isActivated = &#63;.
	*
	* @param isActivated the is activated
	* @return the number of matching subscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countByisActivated(boolean isActivated)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subscribes.
	*
	* @return the number of subscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}