
// Description: Java 25 protected DbIO interface for SecSysGrp.

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
 *	CFSecProtSecSysGrpTable protected database interface for SecSysGrp has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFSecProtSecSysGrpTable
{
	public static final String TABLE_NAME = "SecSysGrp";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFSecProtSecSysGrp protcreateSecSysGrp( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysGrp rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFSecProtSecSysGrp protupdateSecSysGrp( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysGrp rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecSysGrp( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysGrp rec );
	/**
	 *	Delete the SecSysGrp instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecSysGrpByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecSysGrp instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecSysGrp key attribute of the instance generating the id.
	 */
	public void protdeleteSecSysGrpByUNameIdx( ICFSecProtAuthorization Authorization,
		String argName );

	/**
	 *	Delete the SecSysGrp instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSysGrpByUNameIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysGrpByUNameIdxKey argKey );
	/**
	 *	Delete the SecSysGrp instances identified by the key SecLevelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecLevel	The SecSysGrp key attribute of the instance generating the id.
	 */
	public void protdeleteSecSysGrpBySecLevelIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSchema.SecLevelEnum argSecLevel );

	/**
	 *	Delete the SecSysGrp instances identified by the key SecLevelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSysGrpBySecLevelIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSysGrpBySecLevelIdxKey argKey );


	/**
	 *	Read the derived SecSysGrp record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrp instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSysGrp protreadDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecSysGrp record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrp instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSysGrp protlockDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecSysGrp instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecSysGrp[] protreadProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived SecSysGrp record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSysGrp protreadDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId );

	/**
	 *	Read the derived SecSysGrp record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecSysGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSysGrp protreadDerivedByUNameIdx( ICFSecProtAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the derived SecSysGrp record instances identified by the duplicate key SecLevelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecLevel	The SecSysGrp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecSysGrp[] protreadDerivedBySecLevelIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSchema.SecLevelEnum SecLevel );

	/**
	 *	Read the specific SecSysGrp record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrp instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrp protreadRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecSysGrp record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrp instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrp protlockRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecSysGrp record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrp instances in the database accessible for the Authorization.
	 */
	public ICFSecProtSecSysGrp[] protreadAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the specific SecSysGrp record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrp protreadRecByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId );

	/**
	 *	Read the specific SecSysGrp record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecSysGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrp protreadRecByUNameIdx( ICFSecProtAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the specific SecSysGrp record instances identified by the duplicate key SecLevelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecLevel	The SecSysGrp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSysGrp[] protreadRecBySecLevelIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSchema.SecLevelEnum SecLevel );
}
