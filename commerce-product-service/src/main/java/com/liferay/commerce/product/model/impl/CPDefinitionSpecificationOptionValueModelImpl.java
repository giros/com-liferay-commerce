/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.commerce.product.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue;
import com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValueModel;
import com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValueSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the CPDefinitionSpecificationOptionValue service. Represents a row in the &quot;CPDSpecificationOptionValue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CPDefinitionSpecificationOptionValueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionSpecificationOptionValueImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionSpecificationOptionValueImpl
 * @see CPDefinitionSpecificationOptionValue
 * @see CPDefinitionSpecificationOptionValueModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CPDefinitionSpecificationOptionValueModelImpl extends BaseModelImpl<CPDefinitionSpecificationOptionValue>
	implements CPDefinitionSpecificationOptionValueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition specification option value model instance should use the {@link CPDefinitionSpecificationOptionValue} interface instead.
	 */
	public static final String TABLE_NAME = "CPDSpecificationOptionValue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "CPDSpecificationOptionValueId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "CPDefinitionId", Types.BIGINT },
			{ "CPSpecificationOptionId", Types.BIGINT },
			{ "CPOptionCategoryId", Types.BIGINT },
			{ "value", Types.VARCHAR },
			{ "priority", Types.DOUBLE },
			{ "lastPublishDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDSpecificationOptionValueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CPDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPSpecificationOptionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPOptionCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table CPDSpecificationOptionValue (uuid_ VARCHAR(75) null,CPDSpecificationOptionValueId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,CPDefinitionId LONG,CPSpecificationOptionId LONG,CPOptionCategoryId LONG,value STRING null,priority DOUBLE,lastPublishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CPDSpecificationOptionValue";
	public static final String ORDER_BY_JPQL = " ORDER BY cpDefinitionSpecificationOptionValue.priority ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CPDSpecificationOptionValue.priority ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue"),
			true);
	public static final long CPDEFINITIONID_COLUMN_BITMASK = 1L;
	public static final long CPOPTIONCATEGORYID_COLUMN_BITMASK = 2L;
	public static final long CPSPECIFICATIONOPTIONID_COLUMN_BITMASK = 4L;
	public static final long COMPANYID_COLUMN_BITMASK = 8L;
	public static final long GROUPID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long PRIORITY_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CPDefinitionSpecificationOptionValue toModel(
		CPDefinitionSpecificationOptionValueSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CPDefinitionSpecificationOptionValue model = new CPDefinitionSpecificationOptionValueImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDefinitionSpecificationOptionValueId(soapModel.getCPDefinitionSpecificationOptionValueId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCPDefinitionId(soapModel.getCPDefinitionId());
		model.setCPSpecificationOptionId(soapModel.getCPSpecificationOptionId());
		model.setCPOptionCategoryId(soapModel.getCPOptionCategoryId());
		model.setValue(soapModel.getValue());
		model.setPriority(soapModel.getPriority());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CPDefinitionSpecificationOptionValue> toModels(
		CPDefinitionSpecificationOptionValueSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CPDefinitionSpecificationOptionValue> models = new ArrayList<CPDefinitionSpecificationOptionValue>(soapModels.length);

		for (CPDefinitionSpecificationOptionValueSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.product.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue"));

	public CPDefinitionSpecificationOptionValueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDefinitionSpecificationOptionValueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDefinitionSpecificationOptionValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDefinitionSpecificationOptionValueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionSpecificationOptionValue.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionSpecificationOptionValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CPDefinitionSpecificationOptionValueId",
			getCPDefinitionSpecificationOptionValueId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("CPDefinitionId", getCPDefinitionId());
		attributes.put("CPSpecificationOptionId", getCPSpecificationOptionId());
		attributes.put("CPOptionCategoryId", getCPOptionCategoryId());
		attributes.put("value", getValue());
		attributes.put("priority", getPriority());
		attributes.put("lastPublishDate", getLastPublishDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long CPDefinitionSpecificationOptionValueId = (Long)attributes.get(
				"CPDefinitionSpecificationOptionValueId");

		if (CPDefinitionSpecificationOptionValueId != null) {
			setCPDefinitionSpecificationOptionValueId(CPDefinitionSpecificationOptionValueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long CPDefinitionId = (Long)attributes.get("CPDefinitionId");

		if (CPDefinitionId != null) {
			setCPDefinitionId(CPDefinitionId);
		}

		Long CPSpecificationOptionId = (Long)attributes.get(
				"CPSpecificationOptionId");

		if (CPSpecificationOptionId != null) {
			setCPSpecificationOptionId(CPSpecificationOptionId);
		}

		Long CPOptionCategoryId = (Long)attributes.get("CPOptionCategoryId");

		if (CPOptionCategoryId != null) {
			setCPOptionCategoryId(CPOptionCategoryId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCPDefinitionSpecificationOptionValueId() {
		return _CPDefinitionSpecificationOptionValueId;
	}

	@Override
	public void setCPDefinitionSpecificationOptionValueId(
		long CPDefinitionSpecificationOptionValueId) {
		_CPDefinitionSpecificationOptionValueId = CPDefinitionSpecificationOptionValueId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCPDefinitionId() {
		return _CPDefinitionId;
	}

	@Override
	public void setCPDefinitionId(long CPDefinitionId) {
		_columnBitmask |= CPDEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalCPDefinitionId) {
			_setOriginalCPDefinitionId = true;

			_originalCPDefinitionId = _CPDefinitionId;
		}

		_CPDefinitionId = CPDefinitionId;
	}

	public long getOriginalCPDefinitionId() {
		return _originalCPDefinitionId;
	}

	@JSON
	@Override
	public long getCPSpecificationOptionId() {
		return _CPSpecificationOptionId;
	}

	@Override
	public void setCPSpecificationOptionId(long CPSpecificationOptionId) {
		_columnBitmask |= CPSPECIFICATIONOPTIONID_COLUMN_BITMASK;

		if (!_setOriginalCPSpecificationOptionId) {
			_setOriginalCPSpecificationOptionId = true;

			_originalCPSpecificationOptionId = _CPSpecificationOptionId;
		}

		_CPSpecificationOptionId = CPSpecificationOptionId;
	}

	public long getOriginalCPSpecificationOptionId() {
		return _originalCPSpecificationOptionId;
	}

	@JSON
	@Override
	public long getCPOptionCategoryId() {
		return _CPOptionCategoryId;
	}

	@Override
	public void setCPOptionCategoryId(long CPOptionCategoryId) {
		_columnBitmask |= CPOPTIONCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCPOptionCategoryId) {
			_setOriginalCPOptionCategoryId = true;

			_originalCPOptionCategoryId = _CPOptionCategoryId;
		}

		_CPOptionCategoryId = CPOptionCategoryId;
	}

	public long getOriginalCPOptionCategoryId() {
		return _originalCPOptionCategoryId;
	}

	@JSON
	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public String getValue(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getValue(languageId);
	}

	@Override
	public String getValue(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getValue(languageId, useDefault);
	}

	@Override
	public String getValue(String languageId) {
		return LocalizationUtil.getLocalization(getValue(), languageId);
	}

	@Override
	public String getValue(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getValue(), languageId,
			useDefault);
	}

	@Override
	public String getValueCurrentLanguageId() {
		return _valueCurrentLanguageId;
	}

	@JSON
	@Override
	public String getValueCurrentValue() {
		Locale locale = getLocale(_valueCurrentLanguageId);

		return getValue(locale);
	}

	@Override
	public Map<Locale, String> getValueMap() {
		return LocalizationUtil.getLocalizationMap(getValue());
	}

	@Override
	public void setValue(String value) {
		_value = value;
	}

	@Override
	public void setValue(String value, Locale locale) {
		setValue(value, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setValue(String value, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(value)) {
			setValue(LocalizationUtil.updateLocalization(getValue(), "Value",
					value, languageId, defaultLanguageId));
		}
		else {
			setValue(LocalizationUtil.removeLocalization(getValue(), "Value",
					languageId));
		}
	}

	@Override
	public void setValueCurrentLanguageId(String languageId) {
		_valueCurrentLanguageId = languageId;
	}

	@Override
	public void setValueMap(Map<Locale, String> valueMap) {
		setValueMap(valueMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setValueMap(Map<Locale, String> valueMap, Locale defaultLocale) {
		if (valueMap == null) {
			return;
		}

		setValue(LocalizationUtil.updateLocalization(valueMap, getValue(),
				"Value", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CPDefinitionSpecificationOptionValue.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CPDefinitionSpecificationOptionValue.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> valueMap = getValueMap();

		for (Map.Entry<Locale, String> entry : valueMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getValue();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(CPDefinitionSpecificationOptionValue.class.getName(),
				getPrimaryKey(), defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String value = getValue(defaultLocale);

		if (Validator.isNull(value)) {
			setValue(getValue(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setValue(getValue(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CPDefinitionSpecificationOptionValue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CPDefinitionSpecificationOptionValue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPDefinitionSpecificationOptionValueImpl cpDefinitionSpecificationOptionValueImpl =
			new CPDefinitionSpecificationOptionValueImpl();

		cpDefinitionSpecificationOptionValueImpl.setUuid(getUuid());
		cpDefinitionSpecificationOptionValueImpl.setCPDefinitionSpecificationOptionValueId(getCPDefinitionSpecificationOptionValueId());
		cpDefinitionSpecificationOptionValueImpl.setGroupId(getGroupId());
		cpDefinitionSpecificationOptionValueImpl.setCompanyId(getCompanyId());
		cpDefinitionSpecificationOptionValueImpl.setUserId(getUserId());
		cpDefinitionSpecificationOptionValueImpl.setUserName(getUserName());
		cpDefinitionSpecificationOptionValueImpl.setCreateDate(getCreateDate());
		cpDefinitionSpecificationOptionValueImpl.setModifiedDate(getModifiedDate());
		cpDefinitionSpecificationOptionValueImpl.setCPDefinitionId(getCPDefinitionId());
		cpDefinitionSpecificationOptionValueImpl.setCPSpecificationOptionId(getCPSpecificationOptionId());
		cpDefinitionSpecificationOptionValueImpl.setCPOptionCategoryId(getCPOptionCategoryId());
		cpDefinitionSpecificationOptionValueImpl.setValue(getValue());
		cpDefinitionSpecificationOptionValueImpl.setPriority(getPriority());
		cpDefinitionSpecificationOptionValueImpl.setLastPublishDate(getLastPublishDate());

		cpDefinitionSpecificationOptionValueImpl.resetOriginalValues();

		return cpDefinitionSpecificationOptionValueImpl;
	}

	@Override
	public int compareTo(
		CPDefinitionSpecificationOptionValue cpDefinitionSpecificationOptionValue) {
		int value = 0;

		if (getPriority() < cpDefinitionSpecificationOptionValue.getPriority()) {
			value = -1;
		}
		else if (getPriority() > cpDefinitionSpecificationOptionValue.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPDefinitionSpecificationOptionValue)) {
			return false;
		}

		CPDefinitionSpecificationOptionValue cpDefinitionSpecificationOptionValue =
			(CPDefinitionSpecificationOptionValue)obj;

		long primaryKey = cpDefinitionSpecificationOptionValue.getPrimaryKey();

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
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CPDefinitionSpecificationOptionValueModelImpl cpDefinitionSpecificationOptionValueModelImpl =
			this;

		cpDefinitionSpecificationOptionValueModelImpl._originalUuid = cpDefinitionSpecificationOptionValueModelImpl._uuid;

		cpDefinitionSpecificationOptionValueModelImpl._originalGroupId = cpDefinitionSpecificationOptionValueModelImpl._groupId;

		cpDefinitionSpecificationOptionValueModelImpl._setOriginalGroupId = false;

		cpDefinitionSpecificationOptionValueModelImpl._originalCompanyId = cpDefinitionSpecificationOptionValueModelImpl._companyId;

		cpDefinitionSpecificationOptionValueModelImpl._setOriginalCompanyId = false;

		cpDefinitionSpecificationOptionValueModelImpl._setModifiedDate = false;

		cpDefinitionSpecificationOptionValueModelImpl._originalCPDefinitionId = cpDefinitionSpecificationOptionValueModelImpl._CPDefinitionId;

		cpDefinitionSpecificationOptionValueModelImpl._setOriginalCPDefinitionId = false;

		cpDefinitionSpecificationOptionValueModelImpl._originalCPSpecificationOptionId = cpDefinitionSpecificationOptionValueModelImpl._CPSpecificationOptionId;

		cpDefinitionSpecificationOptionValueModelImpl._setOriginalCPSpecificationOptionId = false;

		cpDefinitionSpecificationOptionValueModelImpl._originalCPOptionCategoryId = cpDefinitionSpecificationOptionValueModelImpl._CPOptionCategoryId;

		cpDefinitionSpecificationOptionValueModelImpl._setOriginalCPOptionCategoryId = false;

		cpDefinitionSpecificationOptionValueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionSpecificationOptionValue> toCacheModel() {
		CPDefinitionSpecificationOptionValueCacheModel cpDefinitionSpecificationOptionValueCacheModel =
			new CPDefinitionSpecificationOptionValueCacheModel();

		cpDefinitionSpecificationOptionValueCacheModel.uuid = getUuid();

		String uuid = cpDefinitionSpecificationOptionValueCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpDefinitionSpecificationOptionValueCacheModel.uuid = null;
		}

		cpDefinitionSpecificationOptionValueCacheModel.CPDefinitionSpecificationOptionValueId = getCPDefinitionSpecificationOptionValueId();

		cpDefinitionSpecificationOptionValueCacheModel.groupId = getGroupId();

		cpDefinitionSpecificationOptionValueCacheModel.companyId = getCompanyId();

		cpDefinitionSpecificationOptionValueCacheModel.userId = getUserId();

		cpDefinitionSpecificationOptionValueCacheModel.userName = getUserName();

		String userName = cpDefinitionSpecificationOptionValueCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpDefinitionSpecificationOptionValueCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpDefinitionSpecificationOptionValueCacheModel.createDate = createDate.getTime();
		}
		else {
			cpDefinitionSpecificationOptionValueCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpDefinitionSpecificationOptionValueCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpDefinitionSpecificationOptionValueCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpDefinitionSpecificationOptionValueCacheModel.CPDefinitionId = getCPDefinitionId();

		cpDefinitionSpecificationOptionValueCacheModel.CPSpecificationOptionId = getCPSpecificationOptionId();

		cpDefinitionSpecificationOptionValueCacheModel.CPOptionCategoryId = getCPOptionCategoryId();

		cpDefinitionSpecificationOptionValueCacheModel.value = getValue();

		String value = cpDefinitionSpecificationOptionValueCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			cpDefinitionSpecificationOptionValueCacheModel.value = null;
		}

		cpDefinitionSpecificationOptionValueCacheModel.priority = getPriority();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			cpDefinitionSpecificationOptionValueCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			cpDefinitionSpecificationOptionValueCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return cpDefinitionSpecificationOptionValueCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", CPDefinitionSpecificationOptionValueId=");
		sb.append(getCPDefinitionSpecificationOptionValueId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", CPDefinitionId=");
		sb.append(getCPDefinitionId());
		sb.append(", CPSpecificationOptionId=");
		sb.append(getCPSpecificationOptionId());
		sb.append(", CPOptionCategoryId=");
		sb.append(getCPOptionCategoryId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", lastPublishDate=");
		sb.append(getLastPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDefinitionSpecificationOptionValueId</column-name><column-value><![CDATA[");
		sb.append(getCPDefinitionSpecificationOptionValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getCPDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPSpecificationOptionId</column-name><column-value><![CDATA[");
		sb.append(getCPSpecificationOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPOptionCategoryId</column-name><column-value><![CDATA[");
		sb.append(getCPOptionCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CPDefinitionSpecificationOptionValue.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CPDefinitionSpecificationOptionValue.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _CPDefinitionSpecificationOptionValueId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _CPDefinitionId;
	private long _originalCPDefinitionId;
	private boolean _setOriginalCPDefinitionId;
	private long _CPSpecificationOptionId;
	private long _originalCPSpecificationOptionId;
	private boolean _setOriginalCPSpecificationOptionId;
	private long _CPOptionCategoryId;
	private long _originalCPOptionCategoryId;
	private boolean _setOriginalCPOptionCategoryId;
	private String _value;
	private String _valueCurrentLanguageId;
	private double _priority;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private CPDefinitionSpecificationOptionValue _escapedModel;
}