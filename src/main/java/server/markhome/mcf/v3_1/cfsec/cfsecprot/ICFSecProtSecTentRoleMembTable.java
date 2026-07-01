
// Description: Java 25 protected DbIO interface for SecTentRoleMemb.

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
 *	CFSecProtSecTentRoleMembTable protected database interface for SecTentRoleMemb has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ICFSecProtSecTentRoleMembTable
{
	public static final String TABLE_NAME = "SecTentRoleMemb";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecProtSecTentRoleMemb createSecTentRoleMemb( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecProtSecTentRoleMemb updateSecTentRoleMemb( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecTentRoleMemb( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMemb rec );
	/**
	 *	Delete the SecTentRoleMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecTentRoleMembByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecTentRoleId,
		String argLoginId );
	/**
	 *	Delete the SecTentRoleMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecTentRoleMembByIdIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembPKey argKey );
	/**
	 *	Delete the SecTentRoleMemb instances identified by the key TentRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecTentRoleMembByTentRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecTentRoleId );

	/**
	 *	Delete the SecTentRoleMemb instances identified by the key TentRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecTentRoleMembByTentRoleIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembByTentRoleIdxKey argKey );
	/**
	 *	Delete the SecTentRoleMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecTentRoleMembByUserIdx( ICFSecProtAuthorization Authorization,
		String argLoginId );

	/**
	 *	Delete the SecTentRoleMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecTentRoleMembByUserIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembByUserIdxKey argKey );


	/**
	 *	Read the derived SecTentRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentRoleMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecTentRoleMemb readDerived( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembPKey PKey );

	/**
	 *	Read the derived SecTentRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecTentRoleMemb readDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId,
		String LoginId );

	/**
	 *	Lock the derived SecTentRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecTentRoleMemb lockDerived( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembPKey PKey );

	/**
	 *	Read all SecTentRoleMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecProtSecTentRoleMemb[] readProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived SecTentRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecProtSecTentRoleMemb readDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId,
		String LoginId );

	/**
	 *	Read an array of the derived SecTentRoleMemb record instances identified by the duplicate key TentRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecProtSecTentRoleMemb[] readDerivedByTentRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId );

	/**
	 *	Read an array of the derived SecTentRoleMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecProtSecTentRoleMemb[] readDerivedByUserIdx( ICFSecProtAuthorization Authorization,
		String LoginId );

	/**
	 *	Read the specific SecTentRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb readRec( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembPKey PKey );

	/**
	 *	Read the specific SecTentRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb readRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId,
		String LoginId );

	/**
	 *	Lock the specific SecTentRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb lockRec( ICFSecProtAuthorization Authorization,
		ICFSecProtSecTentRoleMembPKey PKey );

	/**
	 *	Read all the specific SecTentRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentRoleMemb instances in the database accessible for the Authorization.
	 */
	ICFSecProtSecTentRoleMemb[] readAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecTentRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentRoleMemb instances in the database accessible for the Authorization.
	 */
	ICFSecProtSecTentRoleMemb[] pageAllRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 priorSecTentRoleId,
		String priorLoginId );

	/**
	 *	Read the specific SecTentRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb readRecByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId,
		String LoginId );

	/**
	 *	Read an array of the specific SecTentRoleMemb record instances identified by the duplicate key TentRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb[] readRecByTentRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId );

	/**
	 *	Read an array of the specific SecTentRoleMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb[] readRecByUserIdx( ICFSecProtAuthorization Authorization,
		String LoginId );

	/**
	 *	Read a page array of the specific SecTentRoleMemb record instances identified by the duplicate key TentRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb[] pageRecByTentRoleIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecTentRoleId,
		CFLibDbKeyHash256 priorSecTentRoleId,
		String priorLoginId );

	/**
	 *	Read a page array of the specific SecTentRoleMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecProtSecTentRoleMemb[] pageRecByUserIdx( ICFSecProtAuthorization Authorization,
		String LoginId,
		CFLibDbKeyHash256 priorSecTentRoleId,
		String priorLoginId );
}
