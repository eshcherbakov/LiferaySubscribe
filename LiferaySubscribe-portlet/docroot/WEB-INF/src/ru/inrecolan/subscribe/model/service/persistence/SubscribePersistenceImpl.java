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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.inrecolan.subscribe.model.NoSuchSubscribeException;
import ru.inrecolan.subscribe.model.model.Subscribe;
import ru.inrecolan.subscribe.model.model.impl.SubscribeImpl;
import ru.inrecolan.subscribe.model.model.impl.SubscribeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the subscribe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscribePersistence
 * @see SubscribeUtil
 * @generated
 */
public class SubscribePersistenceImpl extends BasePersistenceImpl<Subscribe>
	implements SubscribePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubscribeUtil} to access the subscribe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubscribeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, SubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemail",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, SubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemail",
			new String[] { String.class.getName() },
			SubscribeModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemail",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISACTIVATED =
		new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, SubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisActivated",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISACTIVATED =
		new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, SubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisActivated",
			new String[] { Boolean.class.getName() },
			SubscribeModelImpl.ISACTIVATED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISACTIVATED = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisActivated",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, SubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, SubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the subscribe in the entity cache if it is enabled.
	 *
	 * @param subscribe the subscribe
	 */
	public void cacheResult(Subscribe subscribe) {
		EntityCacheUtil.putResult(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeImpl.class, subscribe.getPrimaryKey(), subscribe);

		subscribe.resetOriginalValues();
	}

	/**
	 * Caches the subscribes in the entity cache if it is enabled.
	 *
	 * @param subscribes the subscribes
	 */
	public void cacheResult(List<Subscribe> subscribes) {
		for (Subscribe subscribe : subscribes) {
			if (EntityCacheUtil.getResult(
						SubscribeModelImpl.ENTITY_CACHE_ENABLED,
						SubscribeImpl.class, subscribe.getPrimaryKey()) == null) {
				cacheResult(subscribe);
			}
			else {
				subscribe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subscribes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubscribeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubscribeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subscribe.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subscribe subscribe) {
		EntityCacheUtil.removeResult(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeImpl.class, subscribe.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Subscribe> subscribes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subscribe subscribe : subscribes) {
			EntityCacheUtil.removeResult(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
				SubscribeImpl.class, subscribe.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subscribe with the primary key. Does not add the subscribe to the database.
	 *
	 * @param subscribeId the primary key for the new subscribe
	 * @return the new subscribe
	 */
	public Subscribe create(long subscribeId) {
		Subscribe subscribe = new SubscribeImpl();

		subscribe.setNew(true);
		subscribe.setPrimaryKey(subscribeId);

		return subscribe;
	}

	/**
	 * Removes the subscribe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscribeId the primary key of the subscribe
	 * @return the subscribe that was removed
	 * @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe remove(long subscribeId)
		throws NoSuchSubscribeException, SystemException {
		return remove(Long.valueOf(subscribeId));
	}

	/**
	 * Removes the subscribe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subscribe
	 * @return the subscribe that was removed
	 * @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscribe remove(Serializable primaryKey)
		throws NoSuchSubscribeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Subscribe subscribe = (Subscribe)session.get(SubscribeImpl.class,
					primaryKey);

			if (subscribe == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubscribeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subscribe);
		}
		catch (NoSuchSubscribeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Subscribe removeImpl(Subscribe subscribe)
		throws SystemException {
		subscribe = toUnwrappedModel(subscribe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, subscribe);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(subscribe);

		return subscribe;
	}

	@Override
	public Subscribe updateImpl(
		ru.inrecolan.subscribe.model.model.Subscribe subscribe, boolean merge)
		throws SystemException {
		subscribe = toUnwrappedModel(subscribe);

		boolean isNew = subscribe.isNew();

		SubscribeModelImpl subscribeModelImpl = (SubscribeModelImpl)subscribe;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, subscribe, merge);

			subscribe.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubscribeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subscribeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subscribeModelImpl.getOriginalEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { subscribeModelImpl.getEmail() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((subscribeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISACTIVATED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(subscribeModelImpl.getOriginalIsActivated())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISACTIVATED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISACTIVATED,
					args);

				args = new Object[] {
						Boolean.valueOf(subscribeModelImpl.getIsActivated())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISACTIVATED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISACTIVATED,
					args);
			}
		}

		EntityCacheUtil.putResult(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SubscribeImpl.class, subscribe.getPrimaryKey(), subscribe);

		return subscribe;
	}

	protected Subscribe toUnwrappedModel(Subscribe subscribe) {
		if (subscribe instanceof SubscribeImpl) {
			return subscribe;
		}

		SubscribeImpl subscribeImpl = new SubscribeImpl();

		subscribeImpl.setNew(subscribe.isNew());
		subscribeImpl.setPrimaryKey(subscribe.getPrimaryKey());

		subscribeImpl.setSubscribeId(subscribe.getSubscribeId());
		subscribeImpl.setEmail(subscribe.getEmail());
		subscribeImpl.setSubscribeDate(subscribe.getSubscribeDate());
		subscribeImpl.setIsActivated(subscribe.isIsActivated());

		return subscribeImpl;
	}

	/**
	 * Returns the subscribe with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscribe
	 * @return the subscribe
	 * @throws com.liferay.portal.NoSuchModelException if a subscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscribe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the subscribe with the primary key or throws a {@link ru.inrecolan.subscribe.model.NoSuchSubscribeException} if it could not be found.
	 *
	 * @param subscribeId the primary key of the subscribe
	 * @return the subscribe
	 * @throws ru.inrecolan.subscribe.model.NoSuchSubscribeException if a subscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe findByPrimaryKey(long subscribeId)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = fetchByPrimaryKey(subscribeId);

		if (subscribe == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + subscribeId);
			}

			throw new NoSuchSubscribeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				subscribeId);
		}

		return subscribe;
	}

	/**
	 * Returns the subscribe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscribe
	 * @return the subscribe, or <code>null</code> if a subscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscribe fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the subscribe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subscribeId the primary key of the subscribe
	 * @return the subscribe, or <code>null</code> if a subscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe fetchByPrimaryKey(long subscribeId)
		throws SystemException {
		Subscribe subscribe = (Subscribe)EntityCacheUtil.getResult(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
				SubscribeImpl.class, subscribeId);

		if (subscribe == _nullSubscribe) {
			return null;
		}

		if (subscribe == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				subscribe = (Subscribe)session.get(SubscribeImpl.class,
						Long.valueOf(subscribeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (subscribe != null) {
					cacheResult(subscribe);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SubscribeModelImpl.ENTITY_CACHE_ENABLED,
						SubscribeImpl.class, subscribeId, _nullSubscribe);
				}

				closeSession(session);
			}
		}

		return subscribe;
	}

	/**
	 * Returns all the subscribes where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching subscribes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Subscribe> findByemail(String email) throws SystemException {
		return findByemail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Subscribe> findByemail(String email, int start, int end)
		throws SystemException {
		return findByemail(email, start, end, null);
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
	public List<Subscribe> findByemail(String email, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email, start, end, orderByComparator };
		}

		List<Subscribe> list = (List<Subscribe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Subscribe subscribe : list) {
				if (!Validator.equals(email, subscribe.getEmail())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SUBSCRIBE_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				list = (List<Subscribe>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Subscribe findByemail_First(String email,
		OrderByComparator orderByComparator)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = fetchByemail_First(email, orderByComparator);

		if (subscribe != null) {
			return subscribe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscribeException(msg.toString());
	}

	/**
	 * Returns the first subscribe in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscribe, or <code>null</code> if a matching subscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe fetchByemail_First(String email,
		OrderByComparator orderByComparator) throws SystemException {
		List<Subscribe> list = findByemail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Subscribe findByemail_Last(String email,
		OrderByComparator orderByComparator)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = fetchByemail_Last(email, orderByComparator);

		if (subscribe != null) {
			return subscribe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscribeException(msg.toString());
	}

	/**
	 * Returns the last subscribe in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscribe, or <code>null</code> if a matching subscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe fetchByemail_Last(String email,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemail(email);

		List<Subscribe> list = findByemail(email, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Subscribe[] findByemail_PrevAndNext(long subscribeId, String email,
		OrderByComparator orderByComparator)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = findByPrimaryKey(subscribeId);

		Session session = null;

		try {
			session = openSession();

			Subscribe[] array = new SubscribeImpl[3];

			array[0] = getByemail_PrevAndNext(session, subscribe, email,
					orderByComparator, true);

			array[1] = subscribe;

			array[2] = getByemail_PrevAndNext(session, subscribe, email,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subscribe getByemail_PrevAndNext(Session session,
		Subscribe subscribe, String email, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBSCRIBE_WHERE);

		if (email == null) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (email != null) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subscribe);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subscribe> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the subscribes where isActivated = &#63;.
	 *
	 * @param isActivated the is activated
	 * @return the matching subscribes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Subscribe> findByisActivated(boolean isActivated)
		throws SystemException {
		return findByisActivated(isActivated, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Subscribe> findByisActivated(boolean isActivated, int start,
		int end) throws SystemException {
		return findByisActivated(isActivated, start, end, null);
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
	public List<Subscribe> findByisActivated(boolean isActivated, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISACTIVATED;
			finderArgs = new Object[] { isActivated };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISACTIVATED;
			finderArgs = new Object[] { isActivated, start, end, orderByComparator };
		}

		List<Subscribe> list = (List<Subscribe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Subscribe subscribe : list) {
				if ((isActivated != subscribe.getIsActivated())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SUBSCRIBE_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVATED_ISACTIVATED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActivated);

				list = (List<Subscribe>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Subscribe findByisActivated_First(boolean isActivated,
		OrderByComparator orderByComparator)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = fetchByisActivated_First(isActivated,
				orderByComparator);

		if (subscribe != null) {
			return subscribe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActivated=");
		msg.append(isActivated);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscribeException(msg.toString());
	}

	/**
	 * Returns the first subscribe in the ordered set where isActivated = &#63;.
	 *
	 * @param isActivated the is activated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscribe, or <code>null</code> if a matching subscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe fetchByisActivated_First(boolean isActivated,
		OrderByComparator orderByComparator) throws SystemException {
		List<Subscribe> list = findByisActivated(isActivated, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Subscribe findByisActivated_Last(boolean isActivated,
		OrderByComparator orderByComparator)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = fetchByisActivated_Last(isActivated,
				orderByComparator);

		if (subscribe != null) {
			return subscribe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActivated=");
		msg.append(isActivated);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscribeException(msg.toString());
	}

	/**
	 * Returns the last subscribe in the ordered set where isActivated = &#63;.
	 *
	 * @param isActivated the is activated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscribe, or <code>null</code> if a matching subscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Subscribe fetchByisActivated_Last(boolean isActivated,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByisActivated(isActivated);

		List<Subscribe> list = findByisActivated(isActivated, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Subscribe[] findByisActivated_PrevAndNext(long subscribeId,
		boolean isActivated, OrderByComparator orderByComparator)
		throws NoSuchSubscribeException, SystemException {
		Subscribe subscribe = findByPrimaryKey(subscribeId);

		Session session = null;

		try {
			session = openSession();

			Subscribe[] array = new SubscribeImpl[3];

			array[0] = getByisActivated_PrevAndNext(session, subscribe,
					isActivated, orderByComparator, true);

			array[1] = subscribe;

			array[2] = getByisActivated_PrevAndNext(session, subscribe,
					isActivated, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subscribe getByisActivated_PrevAndNext(Session session,
		Subscribe subscribe, boolean isActivated,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBSCRIBE_WHERE);

		query.append(_FINDER_COLUMN_ISACTIVATED_ISACTIVATED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isActivated);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subscribe);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subscribe> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the subscribes.
	 *
	 * @return the subscribes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Subscribe> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Subscribe> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Subscribe> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Subscribe> list = (List<Subscribe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBSCRIBE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBSCRIBE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Subscribe>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Subscribe>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the subscribes where email = &#63; from the database.
	 *
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByemail(String email) throws SystemException {
		for (Subscribe subscribe : findByemail(email)) {
			remove(subscribe);
		}
	}

	/**
	 * Removes all the subscribes where isActivated = &#63; from the database.
	 *
	 * @param isActivated the is activated
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByisActivated(boolean isActivated)
		throws SystemException {
		for (Subscribe subscribe : findByisActivated(isActivated)) {
			remove(subscribe);
		}
	}

	/**
	 * Removes all the subscribes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Subscribe subscribe : findAll()) {
			remove(subscribe);
		}
	}

	/**
	 * Returns the number of subscribes where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching subscribes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByemail(String email) throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIBE_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of subscribes where isActivated = &#63;.
	 *
	 * @param isActivated the is activated
	 * @return the number of matching subscribes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByisActivated(boolean isActivated)
		throws SystemException {
		Object[] finderArgs = new Object[] { isActivated };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISACTIVATED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIBE_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVATED_ISACTIVATED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActivated);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISACTIVATED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of subscribes.
	 *
	 * @return the number of subscribes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBSCRIBE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the subscribe persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ru.inrecolan.subscribe.model.model.Subscribe")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Subscribe>> listenersList = new ArrayList<ModelListener<Subscribe>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Subscribe>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SubscribeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = SubscribePersistence.class)
	protected SubscribePersistence subscribePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SUBSCRIBE = "SELECT subscribe FROM Subscribe subscribe";
	private static final String _SQL_SELECT_SUBSCRIBE_WHERE = "SELECT subscribe FROM Subscribe subscribe WHERE ";
	private static final String _SQL_COUNT_SUBSCRIBE = "SELECT COUNT(subscribe) FROM Subscribe subscribe";
	private static final String _SQL_COUNT_SUBSCRIBE_WHERE = "SELECT COUNT(subscribe) FROM Subscribe subscribe WHERE ";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "subscribe.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "subscribe.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(subscribe.email IS NULL OR subscribe.email = ?)";
	private static final String _FINDER_COLUMN_ISACTIVATED_ISACTIVATED_2 = "subscribe.isActivated = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subscribe.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subscribe exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subscribe exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubscribePersistenceImpl.class);
	private static Subscribe _nullSubscribe = new SubscribeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Subscribe> toCacheModel() {
				return _nullSubscribeCacheModel;
			}
		};

	private static CacheModel<Subscribe> _nullSubscribeCacheModel = new CacheModel<Subscribe>() {
			public Subscribe toEntityModel() {
				return _nullSubscribe;
			}
		};
}