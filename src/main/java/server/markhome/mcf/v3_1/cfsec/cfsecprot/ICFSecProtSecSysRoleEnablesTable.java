
// Description: Java 25 protected DbIO interface for SecSysRoleEnables.

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

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprotobj.*;

/*
 *	CFSecProtSecSysRoleEnablesTable protected database interface for SecSysRoleEnables has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ICFSecProtSecSysRoleEnablesTable
{
	public static final String TABLE_NAME = "SecSysRoleEnables";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecProtSecSysRoleEnables createSecSysRoleEnables( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnables rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecProtSecSysRoleEnables updateSecSysRoleEnables( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnables rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecSysRoleEnables( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnables rec );
	/**
	 *	Delete the SecSysRoleEnables instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecSysRoleEnablesByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecSysRoleId,
		String argEnableName );
	/**
	 *	Delete the SecSysRoleEnables instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecSysRoleEnablesByIdIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesPKey argKey );
	/**
	 *	Delete the SecSysRoleEnables instances identified by the key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecSysRoleEnablesBySysRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecSysRoleId );

	/**
	 *	Delete the SecSysRoleEnables instances identified by the key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysRoleEnablesBySysRoleIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesBySysRoleIdxKey argKey );
	/**
	 *	Delete the SecSysRoleEnables instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecSysRoleEnablesByNameIdx( ICFSecProtAuthorization Authorization,
		String argEnableName );

	/**
	 *	Delete the SecSysRoleEnables instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysRoleEnablesByNameIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesByNameIdxKey argKey );


	/**
	 *	Read the derived SecSysRoleEnables record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleEnables instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecSysRoleEnables readDerived( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesPKey PKey );

	/**
	 *	Read the derived SecSysRoleEnables record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecSysRoleEnables readDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId,
		String EnableName );

	/**
	 *	Lock the derived SecSysRoleEnables record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecSysRoleEnables lockDerived( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesPKey PKey );

	/**
	 *	Read all SecSysRoleEnables instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecProtSecSysRoleEnables[] readProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived SecSysRoleEnables record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecSysRoleEnables readDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId,
		String EnableName );

	/**
	 *	Read an array of the derived SecSysRoleEnables record instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecProtSecSysRoleEnables[] readDerivedBySysRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId );

	/**
	 *	Read an array of the derived SecSysRoleEnables record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecProtSecSysRoleEnables[] readDerivedByNameIdx( ICFSecProtAuthorization Authorization,
		String EnableName );

	/**
	 *	Read the specific SecSysRoleEnables record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables readRec( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesPKey PKey );

	/**
	 *	Read the specific SecSysRoleEnables record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables readRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId,
		String EnableName );

	/**
	 *	Lock the specific SecSysRoleEnables record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables lockRec( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysRoleEnablesPKey PKey );

	/**
	 *	Read all the specific SecSysRoleEnables record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysRoleEnables instances in the database accessible for the Authorization.
	 */
	ICFSecProtSecSysRoleEnables[] readAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecSysRoleEnables record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysRoleEnables instances in the database accessible for the Authorization.
	 */
	ICFSecProtSecSysRoleEnables[] pageAllRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 priorSecSysRoleId,
		String priorEnableName );

	/**
	 *	Read the specific SecSysRoleEnables record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables readRecByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId,
		String EnableName );

	/**
	 *	Read an array of the specific SecSysRoleEnables record instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables[] readRecBySysRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId );

	/**
	 *	Read an array of the specific SecSysRoleEnables record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables[] readRecByNameIdx( ICFSecProtAuthorization Authorization,
		String EnableName );

	/**
	 *	Read a page array of the specific SecSysRoleEnables record instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables[] pageRecBySysRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysRoleId,
		CFLibDbKeyHash256 priorSecSysRoleId,
		String priorEnableName );

	/**
	 *	Read a page array of the specific SecSysRoleEnables record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecSysRoleEnables[] pageRecByNameIdx( ICFSecProtAuthorization Authorization,
		String EnableName,
		CFLibDbKeyHash256 priorSecSysRoleId,
		String priorEnableName );
}
