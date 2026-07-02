
// Description: Java 25 protected DbIO interface for SecUserPWReset.

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
 *	CFSecProtSecUserPWResetTable protected database interface for SecUserPWReset has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ICFSecProtSecUserPWResetTable
{
	public static final String TABLE_NAME = "SecUserPWReset";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFSecProtSecUserPWReset protcreateSecUserPWReset( ICFSecProtAuthorization Authorization,
		ICFSecProtSecUserPWReset rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFSecProtSecUserPWReset protupdateSecUserPWReset( ICFSecProtAuthorization Authorization,
		ICFSecProtSecUserPWReset rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecUserPWReset( ICFSecProtAuthorization Authorization,
		ICFSecProtSecUserPWReset rec );
	/**
	 *	Delete the SecUserPWReset instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecUserPWResetByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecUserPWReset instances identified by the key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUserPWReset key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserPWResetByUUuid6Idx( ICFSecProtAuthorization Authorization,
		CFLibUuid6 argPasswordResetUuid6 );

	/**
	 *	Delete the SecUserPWReset instances identified by the key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserPWResetByUUuid6Idx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecUserPWResetByUUuid6IdxKey argKey );
	/**
	 *	Delete the SecUserPWReset instances identified by the key SentEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SentToEMailAddr	The SecUserPWReset key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserPWResetBySentEMAddrIdx( ICFSecProtAuthorization Authorization,
		String argSentToEMailAddr );

	/**
	 *	Delete the SecUserPWReset instances identified by the key SentEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserPWResetBySentEMAddrIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecUserPWResetBySentEMAddrIdxKey argKey );
	/**
	 *	Delete the SecUserPWReset instances identified by the key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserPWReset key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserPWResetByNewAcctIdx( ICFSecProtAuthorization Authorization,
		boolean argNewAccount );

	/**
	 *	Delete the SecUserPWReset instances identified by the key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserPWResetByNewAcctIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecUserPWResetByNewAcctIdxKey argKey );


	/**
	 *	Read the derived SecUserPWReset record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWReset instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecUserPWReset protreadDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecUserPWReset record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWReset instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecUserPWReset protlockDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecUserPWReset instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecUserPWReset[] protreadProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived SecUserPWReset record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecUserPWReset protreadDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the derived SecUserPWReset record instance identified by the unique key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecUserPWReset protreadDerivedByUUuid6Idx( ICFSecProtAuthorization Authorization,
		CFLibUuid6 PasswordResetUuid6 );

	/**
	 *	Read an array of the derived SecUserPWReset record instances identified by the duplicate key SentEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SentToEMailAddr	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecUserPWReset[] protreadDerivedBySentEMAddrIdx( ICFSecProtAuthorization Authorization,
		String SentToEMailAddr );

	/**
	 *	Read an array of the derived SecUserPWReset record instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecUserPWReset[] protreadDerivedByNewAcctIdx( ICFSecProtAuthorization Authorization,
		boolean NewAccount );

	/**
	 *	Read the specific SecUserPWReset record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWReset instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset protreadRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecUserPWReset record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWReset instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset protlockRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecUserPWReset record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserPWReset instances in the database accessible for the Authorization.
	 */
	public ICFSecProtSecUserPWReset[] protreadAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecUserPWReset record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserPWReset instances in the database accessible for the Authorization.
	 */
	public ICFSecProtSecUserPWReset[] protpageAllRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read the specific SecUserPWReset record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset protreadRecByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecUserPWReset record instance identified by the unique key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset protreadRecByUUuid6Idx( ICFSecProtAuthorization Authorization,
		CFLibUuid6 PasswordResetUuid6 );

	/**
	 *	Read an array of the specific SecUserPWReset record instances identified by the duplicate key SentEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SentToEMailAddr	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset[] protreadRecBySentEMAddrIdx( ICFSecProtAuthorization Authorization,
		String SentToEMailAddr );

	/**
	 *	Read an array of the specific SecUserPWReset record instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset[] protreadRecByNewAcctIdx( ICFSecProtAuthorization Authorization,
		boolean NewAccount );

	/**
	 *	Read a page array of the specific SecUserPWReset record instances identified by the duplicate key SentEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SentToEMailAddr	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset[] protpageRecBySentEMAddrIdx( ICFSecProtAuthorization Authorization,
		String SentToEMailAddr,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecUserPWReset record instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecUserPWReset[] protpageRecByNewAcctIdx( ICFSecProtAuthorization Authorization,
		boolean NewAccount,
		CFLibDbKeyHash256 priorSecUserId );
}
