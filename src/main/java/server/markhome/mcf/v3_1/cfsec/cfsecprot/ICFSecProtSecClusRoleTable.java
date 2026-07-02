
// Description: Java 25 protected DbIO interface for SecClusRole.

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
 *	CFSecProtSecClusRoleTable protected database interface for SecClusRole has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ICFSecProtSecClusRoleTable
{
	public static final String TABLE_NAME = "SecClusRole";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFSecProtSecClusRole protcreateSecClusRole( ICFSecProtAuthorization Authorization,
		ICFSecProtSecClusRole rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFSecProtSecClusRole protupdateSecClusRole( ICFSecProtAuthorization Authorization,
		ICFSecProtSecClusRole rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecClusRole( ICFSecProtAuthorization Authorization,
		ICFSecProtSecClusRole rec );
	/**
	 *	Delete the SecClusRole instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecClusRoleByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecClusRole instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusRole key attribute of the instance generating the id.
	 */
	public void protdeleteSecClusRoleByClusterIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argClusterId );

	/**
	 *	Delete the SecClusRole instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecClusRoleByClusterIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecClusRoleByClusterIdxKey argKey );
	/**
	 *	Delete the SecClusRole instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecClusRole key attribute of the instance generating the id.
	 */
	public void protdeleteSecClusRoleByNameIdx( ICFSecProtAuthorization Authorization,
		String argName );

	/**
	 *	Delete the SecClusRole instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecClusRoleByNameIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecClusRoleByNameIdxKey argKey );
	/**
	 *	Delete the SecClusRole instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecClusRole key attribute of the instance generating the id.
	 */
	public void protdeleteSecClusRoleByUNameIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argClusterId,
		String argName );

	/**
	 *	Delete the SecClusRole instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecClusRoleByUNameIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecClusRoleByUNameIdxKey argKey );


	/**
	 *	Read the derived SecClusRole record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRole instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecClusRole protreadDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecClusRole record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRole instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecClusRole protlockDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecClusRole instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecClusRole[] protreadProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived SecClusRole record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecClusRole protreadDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecClusRoleId );

	/**
	 *	Read an array of the derived SecClusRole record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecClusRole[] protreadDerivedByClusterIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 ClusterId );

	/**
	 *	Read an array of the derived SecClusRole record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecClusRole[] protreadDerivedByNameIdx( ICFSecProtAuthorization Authorization,
		String Name );

	/**
	 *	Read the derived SecClusRole record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecClusRole protreadDerivedByUNameIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 ClusterId,
		String Name );

	/**
	 *	Read the specific SecClusRole record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRole instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRole protreadRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecClusRole record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRole instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRole protlockRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecClusRole record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusRole instances in the database accessible for the Authorization.
	 */
	public ICFSecProtSecClusRole[] protreadAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the specific SecClusRole record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRole protreadRecByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecClusRoleId );

	/**
	 *	Read an array of the specific SecClusRole record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRole[] protreadRecByClusterIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 ClusterId );

	/**
	 *	Read an array of the specific SecClusRole record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRole[] protreadRecByNameIdx( ICFSecProtAuthorization Authorization,
		String Name );

	/**
	 *	Read the specific SecClusRole record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecClusRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecClusRole protreadRecByUNameIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 ClusterId,
		String Name );
}
