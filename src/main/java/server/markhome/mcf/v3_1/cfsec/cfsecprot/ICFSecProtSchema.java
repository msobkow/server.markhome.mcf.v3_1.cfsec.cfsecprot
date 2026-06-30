// Description: Java 25 public interface for a CFSec schema.

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsecprot;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
//import server.markhome.mcf.v3_1.cfsec.cfsecprot.buff.CFSecProtBuffSchema;
//import server.markhome.mcf.v3_1.cfsec.cfsecprot.buff.CFSecProtBuffFactoryService;

public interface ICFSecProtSchema
{

	public static final String SCHEMA_NAME = "CFSec";
	public static final String DBSCHEMA_NAME = "CFSec31";
	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>(null);
	public static final CFSecPubTableData TABLE_DATA[] = {new CFSecPubTableData("CFSec", "Cluster", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "ISOCcy", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "ISOCtry", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "ISOCtryCcy", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "ISOCtryLang", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "ISOLang", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "ISOTZone", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "SecClusGrp", null, true, false, "Cluster", "Protected"),
		new CFSecPubTableData("CFSec", "SecClusGrpMemb", null, true, false, "Cluster", "Protected"),
		new CFSecPubTableData("CFSec", "SecClusRole", null, true, false, "Cluster", "Protected"),
		new CFSecPubTableData("CFSec", "SecClusRoleMemb", null, true, false, "Cluster", "Protected"),
		new CFSecPubTableData("CFSec", "SecSession", null, false, false, "System", "Public"),
		new CFSecPubTableData("CFSec", "SecSysGrp", null, true, false, "System", "Public"),
		new CFSecPubTableData("CFSec", "SecSysGrpInc", null, true, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SecSysGrpMemb", null, true, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SecSysRole", null, true, false, "System", "Public"),
		new CFSecPubTableData("CFSec", "SecSysRoleEnables", null, true, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SecSysRoleMemb", null, true, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SecTentGrp", null, true, false, "Tenant", "Protected"),
		new CFSecPubTableData("CFSec", "SecTentGrpMemb", null, true, false, "Tenant", "Protected"),
		new CFSecPubTableData("CFSec", "SecTentRole", null, true, false, "Tenant", "Protected"),
		new CFSecPubTableData("CFSec", "SecTentRoleMemb", null, true, false, "Tenant", "Protected"),
		new CFSecPubTableData("CFSec", "SecUser", null, true, false, "System", "Public"),
		new CFSecPubTableData("CFSec", "SecUserEMConf", null, true, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SecUserPWReset", null, true, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SecUserPassword", null, false, false, "System", "Protected"),
		new CFSecPubTableData("CFSec", "SysCluster", null, false, false, "System", "Public"),
		new CFSecPubTableData("CFSec", "TableInfo", null, true, false, "Global", "Public"),
		new CFSecPubTableData("CFSec", "Tenant", null, true, false, "System", "Public")};
	public static final AtomicReference<CFSecPubTableData[]> consolidatedProtTableData = new AtomicReference<>(null);
	public static final CFSecPubRoleInfo ROLE_INFO[] = {new CFSecPubRoleInfo("secclusmanager", "ClusRole", "sectentmanager createsecclusmemb updatesecclusmemb deletesecclusmemb createsecclusrolememb updatesecclusrolememb deletesecclusrolememb", "systemadmin"),
		new CFSecPubRoleInfo("secclusadmin", "ClusRole", "secclusmanager createsecclusgrp updatesecclusgrp deletesecclusgrp readsecclusrole updatesecclusrole createsecclusrole deletesecclusrole", "systemadmin"),
		new CFSecPubRoleInfo("secsysmanager", "SysRole", "secuser secclusmanager createsecsysmemb updatesecsysmemb deletesecsysmemb create secsysrolememb updatesecsysrolememb deletesecsysrolememb", "systemadmin"),
		new CFSecPubRoleInfo("sectentmanager", "TentRole", "secuser createsectentmemb updatesectentmemb deletesectentmemb createsectentrolememb updatesectentrolememb deletesectentrolememb", "systemadmin"),
		new CFSecPubRoleInfo("sectentadmin", "TentRole", "sectentmanager createsectentgrp updatesectentgrp deletesectentgrp createsectentrole updatesectentrole deletesectentrole", "systemadmin"),
		new CFSecPubRoleInfo("secsysadmin", "SysRole", "sectentadmin secclusadmin secsysmanager updatecluster deletecluster updatetenant deletetenant createsecsysgrp updatesecsysgrp deletesecsysgrp createsecsysrole updatesecsysrole deletesecsysrole createsecsysinc updatesecsysinc deletesecsysinc ", "systemadmin"),
		new CFSecPubRoleInfo("secuser", "SysRole", "readcluster readtenant readsecsysgrp readsecsysinc readsecsysmemb readsecsysrole readsecsysinc readsecsysroleenable readsecsysrolememb readsecclusgrp readsecclusmemb readsecclusrole readsecclusrolememb readsectentgrp readsectentmemb readsectentrole readsectentrolememb", "systemadmin")};
	public static final AtomicReference<CFSecPubRoleInfo[]> consolidatedProtRoleInfo = new AtomicReference<>(null);
	public static CFSecPubTableData[] getProtTableData() {
		return TABLE_DATA;
	}

	public static CFSecPubTableData[] getConsolidatedProtTableData() {
		if (consolidatedProtTableData.get() == null) {
			ArrayList<CFSecPubTableData> lst = new ArrayList<>();
			for( CFSecPubTableData data: TABLE_DATA) {
				lst.add(data);
			}
			CFSecPubTableData arr[] = new CFSecPubTableData[lst.size()];
			int idx = 0;
			for(CFSecPubTableData data: lst) {
				arr[idx++] = data;
			}
			consolidatedProtTableData.compareAndSet(null, arr);
		}
		return(consolidatedProtTableData.get());
	}

	public static CFSecPubRoleInfo[] getProtRoleInfo() {
		return ROLE_INFO;
	}

	public static CFSecPubRoleInfo[] getConsolidatedProtRoleInfo() {
		if (consolidatedProtRoleInfo.get() == null) {
			ArrayList<CFSecPubRoleInfo> lst = new ArrayList<>();
			for( CFSecPubRoleInfo info: ROLE_INFO) {
				lst.add(info);
			}
			// Dependency order is the natural order of role info comparison
			lst.sort(new CFSecPubRoleInfoDependencyComparator());
			CFSecPubRoleInfo arr[] = new CFSecPubRoleInfo[lst.size()];
			int idx = 0;
			for(CFSecPubRoleInfo info: lst) {
				arr[idx++] = info;
			}
			consolidatedProtRoleInfo.compareAndSet(null, arr);
		}
		return(consolidatedProtRoleInfo.get());
	}

	public default void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}

	public static interface BackingRecConstructor {
		public Object instantiate();
	}
	
	public static class ClassMapEntry {
		final String schemaName;
		final String tableName;
		final int backingClassCode;
		int runtimeClassCode;
		BackingRecConstructor cbRecConstructor;
		
		public ClassMapEntry(String schemaName, String tableName, int backingClassCode) {
			this.schemaName = schemaName;
			this.tableName = tableName;
			this.backingClassCode = backingClassCode;
			runtimeClassCode = 0;
			cbRecConstructor = null;
		}
		
		public String getSchemaName() { return schemaName; }
		public String getTableName() { return tableName; }
		public int getBackingClassCode() { return backingClassCode; }

		public int getRuntimeClassCode() { return runtimeClassCode; }
		public void setRuntimeClassCode(int runtimeClassCode) { this.runtimeClassCode = runtimeClassCode; }
		
		public BackingRecConstructor getBackingRecConstructor() { return cbRecConstructor; }
		public void setBackingRecConstructor(BackingRecConstructor backingRecConstructor) { this.cbRecConstructor = backingRecConstructor; }
	}

		final static ArrayList<ICFSecProtSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ICFSecProtSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ICFSecProtSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ICFSecProtSchema> backingCFSecProtSchema = new AtomicReference<>();
	final static AtomicReference<ICFSecProtAuthorizationCallback> authorizationCallback = new AtomicReference<>();
	
	public static ICFSecProtAuthorizationCallback getAuthorizationCallback() {
		ICFSecProtAuthorizationCallback retval = authorizationCallback.get();
		if (retval == null) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "getAuthorizationCallback", 0, "authorizationCallback.get()");
		}
		return( retval );
	}
	
	public static void setAuthorizationCallback(ICFSecProtAuthorizationCallback callback) {
		if (callback == null) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "setAuthorizationCallback", 0, "callback");
		}
		authorizationCallback.set(callback);
	}

	final static AtomicReference<ICFSecProtSecurityService> securityService = new AtomicReference<>();
	
	public static ICFSecProtSecurityService getSecurityService() {
		ICFSecProtSecurityService retval = securityService.get();
		if (retval == null) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "getSecurityService", 0, "securityService.get()");
		}
		return( retval );
	}
	
	public static void setSecurityService(ICFSecProtSecurityService service) {
		if (service == null) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "setSecurityService", 0, "service");
		}
		securityService.compareAndSet(null, service);
	}

	public enum AuditActionEnum {
		Created,
		Updated,
		Deleted,
		Mutated
	};

	static HashMap<String,AuditActionEnum> lookupAuditActionEnum = new HashMap<String,AuditActionEnum>();

	public static AuditActionEnum parseAuditActionEnum( String value ) {
		AuditActionEnum retval = parseAuditActionEnum( ICFSecProtSchema.class.getName(), value );
		return( retval );
	}

	public static AuditActionEnum parseAuditActionEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseAuditActionEnum";
		if( lookupAuditActionEnum.isEmpty() ) {
			lookupAuditActionEnum.put( "Created", AuditActionEnum.Created );
			lookupAuditActionEnum.put( "Updated", AuditActionEnum.Updated );
			lookupAuditActionEnum.put( "Deleted", AuditActionEnum.Deleted );
			lookupAuditActionEnum.put( "Mutated", AuditActionEnum.Mutated );
		}
		AuditActionEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupAuditActionEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,AuditActionEnum> lookupOrdinalAuditActionEnum = new HashMap<Integer,AuditActionEnum>();

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Integer value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( ICFSecProtSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToAuditActionEnum";
		if( lookupOrdinalAuditActionEnum.isEmpty() ) {
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Created.ordinal() ), AuditActionEnum.Created );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Updated.ordinal() ), AuditActionEnum.Updated );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Deleted.ordinal() ), AuditActionEnum.Deleted );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Mutated.ordinal() ), AuditActionEnum.Mutated );
		}
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalAuditActionEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum SecLevelEnum {
		System,
		Global,
		Cluster,
		Tenant,
		SysRole,
		ClusRole,
		TentRole
	};

	static HashMap<String,SecLevelEnum> lookupSecLevelEnum = new HashMap<String,SecLevelEnum>();

	public static SecLevelEnum parseSecLevelEnum( String value ) {
		SecLevelEnum retval = parseSecLevelEnum( ICFSecProtSchema.class.getName(), value );
		return( retval );
	}

	public static SecLevelEnum parseSecLevelEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecLevelEnum";
		if( lookupSecLevelEnum.isEmpty() ) {
			lookupSecLevelEnum.put( "System", SecLevelEnum.System );
			lookupSecLevelEnum.put( "Global", SecLevelEnum.Global );
			lookupSecLevelEnum.put( "Cluster", SecLevelEnum.Cluster );
			lookupSecLevelEnum.put( "Tenant", SecLevelEnum.Tenant );
			lookupSecLevelEnum.put( "SysRole", SecLevelEnum.SysRole );
			lookupSecLevelEnum.put( "ClusRole", SecLevelEnum.ClusRole );
			lookupSecLevelEnum.put( "TentRole", SecLevelEnum.TentRole );
		}
		SecLevelEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecLevelEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecLevelEnum> lookupOrdinalSecLevelEnum = new HashMap<Integer,SecLevelEnum>();

	public static SecLevelEnum ordinalToSecLevelEnum( String fieldOrClassName, Short value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( Short value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( Integer value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( ICFSecProtSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecLevelEnum";
		if( lookupOrdinalSecLevelEnum.isEmpty() ) {
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.System.ordinal() ), SecLevelEnum.System );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Global.ordinal() ), SecLevelEnum.Global );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Cluster.ordinal() ), SecLevelEnum.Cluster );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Tenant.ordinal() ), SecLevelEnum.Tenant );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.SysRole.ordinal() ), SecLevelEnum.SysRole );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.ClusRole.ordinal() ), SecLevelEnum.ClusRole );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.TentRole.ordinal() ), SecLevelEnum.TentRole );
		}
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecLevelEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum SecAccountStatusEnum {
		System,
		VerifyingEmail,
		CreatingDevKey,
		NormalUser,
		ResettingPassword,
		Locked
	};

	static HashMap<String,SecAccountStatusEnum> lookupSecAccountStatusEnum = new HashMap<String,SecAccountStatusEnum>();

	public static SecAccountStatusEnum parseSecAccountStatusEnum( String value ) {
		SecAccountStatusEnum retval = parseSecAccountStatusEnum( ICFSecProtSchema.class.getName(), value );
		return( retval );
	}

	public static SecAccountStatusEnum parseSecAccountStatusEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecAccountStatusEnum";
		if( lookupSecAccountStatusEnum.isEmpty() ) {
			lookupSecAccountStatusEnum.put( "System", SecAccountStatusEnum.System );
			lookupSecAccountStatusEnum.put( "VerifyingEmail", SecAccountStatusEnum.VerifyingEmail );
			lookupSecAccountStatusEnum.put( "CreatingDevKey", SecAccountStatusEnum.CreatingDevKey );
			lookupSecAccountStatusEnum.put( "NormalUser", SecAccountStatusEnum.NormalUser );
			lookupSecAccountStatusEnum.put( "ResettingPassword", SecAccountStatusEnum.ResettingPassword );
			lookupSecAccountStatusEnum.put( "Locked", SecAccountStatusEnum.Locked );
		}
		SecAccountStatusEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecAccountStatusEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecAccountStatusEnum> lookupOrdinalSecAccountStatusEnum = new HashMap<Integer,SecAccountStatusEnum>();

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( String fieldOrClassName, Short value ) {
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecAccountStatusEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( Short value ) {
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecAccountStatusEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( Integer value ) {
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecAccountStatusEnum( ICFSecProtSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecAccountStatusEnum";
		if( lookupOrdinalSecAccountStatusEnum.isEmpty() ) {
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.System.ordinal() ), SecAccountStatusEnum.System );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.VerifyingEmail.ordinal() ), SecAccountStatusEnum.VerifyingEmail );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.CreatingDevKey.ordinal() ), SecAccountStatusEnum.CreatingDevKey );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.NormalUser.ordinal() ), SecAccountStatusEnum.NormalUser );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.ResettingPassword.ordinal() ), SecAccountStatusEnum.ResettingPassword );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.Locked.ordinal() ), SecAccountStatusEnum.Locked );
		}
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecAccountStatusEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static final AtomicReference<CFLibDbKeyHash256> sysClusterId = new AtomicReference<>();
	static final AtomicReference<CFLibDbKeyHash256> sysTenantId = new AtomicReference<>();
	static final AtomicReference<CFLibDbKeyHash256> systemId = new AtomicReference<>();

	public static String getPasswordHash(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "getPasswordHash", 1, "pw");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(pw.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
	}

	public static CFLibDbKeyHash256 getSysClusterId() {
		return (sysClusterId.get());
	}

	public static void setSysClusterId(CFLibDbKeyHash256 argClusterId) {
		if (argClusterId == null || argClusterId.isNull()) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "setSysClusterId", 1, "argClusterId");
		}
		CFLibDbKeyHash256 oldid = sysClusterId.get();
		if (oldid == null) {
			sysClusterId.compareAndSet(null, argClusterId);
		}
		else if (oldid.isNull()) {
			sysClusterId.compareAndSet(oldid, argClusterId);
		}
		else {
			throw new CFLibInvalidArgumentException(ICFSecProtSchema.class, "setSysClusterId", "sysClusterId has already been set", "sysClusterId has already been set");
		}
	}

	public static CFLibDbKeyHash256 getSysTenantId() {
		return (sysTenantId.get());
	}

	public static void setSysTenantId(CFLibDbKeyHash256 argTenantId) {
		if (argTenantId == null || argTenantId.isNull()) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "setSysTenantId", 1, "argTenantId");
		}
		CFLibDbKeyHash256 oldid = sysTenantId.get();
		if (oldid == null) {
			sysTenantId.compareAndSet(null, argTenantId);
		}
		else if (oldid.isNull()) {
			sysTenantId.compareAndSet(oldid, argTenantId);
		}
		else {
			throw new CFLibInvalidArgumentException(ICFSecProtSchema.class, "setSysTenantId", "sysTenantId has already been set", "sysTenantId has already been set");
		}
	}

	public static CFLibDbKeyHash256 getSystemId() {
		return (systemId.get());
	}

	public static void setSystemId(CFLibDbKeyHash256 argSystemId) {
		if (argSystemId == null || argSystemId.isNull()) {
			throw new CFLibNullArgumentException(ICFSecProtSchema.class, "setSystemId", 1, "argSystemId");
		}
		CFLibDbKeyHash256 oldid = systemId.get();
		if (oldid == null) {
			systemId.compareAndSet(null, argSystemId);
		}
		else if (oldid.isNull()) {
			systemId.compareAndSet(oldid, argSystemId);
		}
		else {
			throw new CFLibInvalidArgumentException(ICFSecProtSchema.class, "setSystemId", "systemId has already been set", "systemId has already been set");
		}
	}

		public static ICFSecProtSchema getBackingCFSecProtSchema() {
			return( ICFSecProtSchema.backingCFSecProtSchema.get() );
		}
		
		public static void setBackingCFSecProtSchema(ICFSecProtSchema backingSchema) {
			ICFSecProtSchema.backingCFSecProtSchema.set(backingSchema);
		}
		
		public ICFSecProtSchema getCFSecProtSchema();
		public void setCFSecProtSchema(ICFSecProtSchema schema);
		
		public static int doInitClassMapEntries(int value) {
			if (ICFSecProtSchema.entries.isEmpty()) {
				ICFSecProtSchema.ClassMapEntry entry;
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "Cluster", ICFSecProtCluster.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "ISOCcy", ICFSecProtISOCcy.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "ISOCtry", ICFSecProtISOCtry.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "ISOCtryCcy", ICFSecProtISOCtryCcy.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "ISOCtryLang", ICFSecProtISOCtryLang.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "ISOLang", ICFSecProtISOLang.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "ISOTZone", ICFSecProtISOTZone.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecClusGrp", ICFSecProtSecClusGrp.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecClusGrpMemb", ICFSecProtSecClusGrpMemb.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecClusRole", ICFSecProtSecClusRole.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecClusRoleMemb", ICFSecProtSecClusRoleMemb.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSession", ICFSecProtSecSession.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSysGrp", ICFSecProtSecSysGrp.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSysGrpInc", ICFSecProtSecSysGrpInc.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSysGrpMemb", ICFSecProtSecSysGrpMemb.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSysRole", ICFSecProtSecSysRole.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSysRoleEnables", ICFSecProtSecSysRoleEnables.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecSysRoleMemb", ICFSecProtSecSysRoleMemb.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecTentGrp", ICFSecProtSecTentGrp.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecTentGrpMemb", ICFSecProtSecTentGrpMemb.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecTentRole", ICFSecProtSecTentRole.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecTentRoleMemb", ICFSecProtSecTentRoleMemb.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecUser", ICFSecProtSecUser.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecUserEMConf", ICFSecProtSecUserEMConf.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecUserPWReset", ICFSecProtSecUserPWReset.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SecUserPassword", ICFSecProtSecUserPassword.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "SysCluster", ICFSecProtSysCluster.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "TableInfo", ICFSecProtTableInfo.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFSecProtSchema.SCHEMA_NAME, "Tenant", ICFSecProtTenant.CLASS_CODE);
				ICFSecProtSchema.entries.add(entry);
				for( ICFSecProtSchema.ClassMapEntry cur: ICFSecProtSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ICFSecProtSchema.mapBackingClassCodeToEntry.clear();
				ICFSecProtSchema.mapRuntimeClassCodeToEntry.clear();
				for( ICFSecProtSchema.ClassMapEntry cur: ICFSecProtSchema.entries) {
					ICFSecProtSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ICFSecProtSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ICFSecProtSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ICFSecProtSchema.ClassMapEntry entry;
			entry = ICFSecProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ICFSecProtSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ICFSecProtSchema.ClassMapEntry entry;
			entry = ICFSecProtSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public int initClassMapEntries(int value);
		public void wireRecConstructors();
		public void wireTableTableInstances();

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ICFSecProtSchema instance.
	 */
	public ICFSecProtSchema newSchema();

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen();

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen();

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen();

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen();

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextClusterIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecUserIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTenantIdGen();

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSysGrpIdGen();

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecClusGrpIdGen();

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecClusRoleIdGen();

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecTentGrpIdGen();

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecTentRoleIdGen();

	/**
	 *	Get the factory for CFSecProt data objects.
	 */
	// public ICFSecProtFactory getCFSecProtFactory();

	/**
	 *	Get the buffer factory for CFSecProt data buffers.
	 */
	// public CFSecProtBuffFactoryService getCFSecProtBuffFactory();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtClusterTable getTableCluster();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOLangTable getTableISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOTZoneTable getTableISOTZone();

	/**
	 *	Get the SecClusGrp Table interface for the schema.
	 *
	 *	@return	The SecClusGrp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusGrpTable getTableSecClusGrp();

	/**
	 *	Get the SecClusGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusGrpMembTable getTableSecClusGrpMemb();

	/**
	 *	Get the SecClusRole Table interface for the schema.
	 *
	 *	@return	The SecClusRole Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRoleTable getTableSecClusRole();

	/**
	 *	Get the SecClusRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecClusRoleMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRoleMembTable getTableSecClusRoleMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSysGrp Table interface for the schema.
	 *
	 *	@return	The SecSysGrp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrpTable getTableSecSysGrp();

	/**
	 *	Get the SecSysGrpInc Table interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrpIncTable getTableSecSysGrpInc();

	/**
	 *	Get the SecSysGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrpMembTable getTableSecSysGrpMemb();

	/**
	 *	Get the SecSysRole Table interface for the schema.
	 *
	 *	@return	The SecSysRole Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysRoleTable getTableSecSysRole();

	/**
	 *	Get the SecSysRoleEnables Table interface for the schema.
	 *
	 *	@return	The SecSysRoleEnables Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysRoleEnablesTable getTableSecSysRoleEnables();

	/**
	 *	Get the SecSysRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecSysRoleMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysRoleMembTable getTableSecSysRoleMemb();

	/**
	 *	Get the SecTentGrp Table interface for the schema.
	 *
	 *	@return	The SecTentGrp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecTentGrpTable getTableSecTentGrp();

	/**
	 *	Get the SecTentGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecTentGrpMembTable getTableSecTentGrpMemb();

	/**
	 *	Get the SecTentRole Table interface for the schema.
	 *
	 *	@return	The SecTentRole Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecTentRoleTable getTableSecTentRole();

	/**
	 *	Get the SecTentRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecTentRoleMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecTentRoleMembTable getTableSecTentRoleMemb();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserTable getTableSecUser();

	/**
	 *	Get the SecUserEMConf Table interface for the schema.
	 *
	 *	@return	The SecUserEMConf Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserEMConfTable getTableSecUserEMConf();

	/**
	 *	Get the SecUserPWReset Table interface for the schema.
	 *
	 *	@return	The SecUserPWReset Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWResetTable getTableSecUserPWReset();

	/**
	 *	Get the SecUserPassword Table interface for the schema.
	 *
	 *	@return	The SecUserPassword Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPasswordTable getTableSecUserPassword();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSysClusterTable getTableSysCluster();

	/**
	 *	Get the TableInfo Table interface for the schema.
	 *
	 *	@return	The TableInfo Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtTableInfoTable getTableTableInfo();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtTenantTable getTableTenant();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	//public static ICFSecProtTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ICFSecProtTablePerms getCFSecProtTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ICFSecProtTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ICFSecProtTablePerms value );

	public void bootstrapSchema(CFSecPubTableData tableData[]);
	public void bootstrapAllTablesSecurity(CFLibDbKeyHash256 clusterId, CFLibDbKeyHash256 tenantId, CFSecPubTableData tableData[]);
}
