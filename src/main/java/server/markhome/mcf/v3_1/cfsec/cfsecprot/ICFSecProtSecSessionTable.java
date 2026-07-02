
// Description: Java 25 protected DbIO interface for SecSession.

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
 *	CFSecProtSecSessionTable protected database interface for SecSession has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFSecProtSecSessionTable
{
	public static final String TABLE_NAME = "SecSession";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFSecProtSecSession protcreateSecSession( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSession rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFSecProtSecSession protupdateSecSession( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSession rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecSession( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSession rec );
	/**
	 *	Delete the SecSession instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecSessionByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecSession instances identified by the key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 */
	public void protdeleteSecSessionBySecUserIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the SecSession instances identified by the key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSessionBySecUserIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSessionBySecUserIdxKey argKey );
	/**
	 *	Delete the SecSession instances identified by the key StartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 */
	public void protdeleteSecSessionByStartIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId,
		LocalDateTime argStart );

	/**
	 *	Delete the SecSession instances identified by the key StartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSessionByStartIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSessionByStartIdxKey argKey );
	/**
	 *	Delete the SecSession instances identified by the key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 */
	public void protdeleteSecSessionByFinishIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId,
		LocalDateTime argFinish );

	/**
	 *	Delete the SecSession instances identified by the key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSessionByFinishIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSessionByFinishIdxKey argKey );
	/**
	 *	Delete the SecSession instances identified by the key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 */
	public void protdeleteSecSessionBySecProxyIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 argSecProxyId );

	/**
	 *	Delete the SecSession instances identified by the key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSessionBySecProxyIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtSecSessionBySecProxyIdxKey argKey );


	/**
	 *	Read the derived SecSession record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSession instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSession protreadDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecSession record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSession instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSession protlockDerived( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecSession instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecSession[] protreadProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived SecSession record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSession protreadDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSessionId );

	/**
	 *	Read an array of the derived SecSession record instances identified by the duplicate key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecSession[] protreadDerivedBySecUserIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the derived SecSession record instance identified by the unique key StartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtSecSession protreadDerivedByStartIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start );

	/**
	 *	Read an array of the derived SecSession record instances identified by the duplicate key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecSession[] protreadDerivedByFinishIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish );

	/**
	 *	Read an array of the derived SecSession record instances identified by the duplicate key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtSecSession[] protreadDerivedBySecProxyIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecProxyId );

	/**
	 *	Read the specific SecSession record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSession instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession protreadRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecSession record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSession instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession protlockRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecSession record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSession instances in the database accessible for the Authorization.
	 */
	public ICFSecProtSecSession[] protreadAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecSession record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSession instances in the database accessible for the Authorization.
	 */
	public ICFSecProtSecSession[] protpageAllRec( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 priorSecSessionId );

	/**
	 *	Read the specific SecSession record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession protreadRecByIdIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecSessionId );

	/**
	 *	Read an array of the specific SecSession record instances identified by the duplicate key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession[] protreadRecBySecUserIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecSession record instance identified by the unique key StartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession protreadRecByStartIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start );

	/**
	 *	Read an array of the specific SecSession record instances identified by the duplicate key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession[] protreadRecByFinishIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish );

	/**
	 *	Read an array of the specific SecSession record instances identified by the duplicate key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession[] protreadRecBySecProxyIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecProxyId );

	/**
	 *	Read a page array of the specific SecSession record instances identified by the duplicate key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession[] protpageRecBySecUserIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecSessionId );

	/**
	 *	Read a page array of the specific SecSession record instances identified by the duplicate key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession[] protpageRecByFinishIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish,
		CFLibDbKeyHash256 priorSecSessionId );

	/**
	 *	Read a page array of the specific SecSession record instances identified by the duplicate key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtSecSession[] protpageRecBySecProxyIdx( ICFSecProtAuthorization Authorization,
		CFLibDbKeyHash256 SecProxyId,
		CFLibDbKeyHash256 priorSecSessionId );
}
