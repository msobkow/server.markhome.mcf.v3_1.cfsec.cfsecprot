
// Description: Java 25 protected DbIO interface for ISOCtryLang.

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
 *	CFSecProtISOCtryLangTable protected database interface for ISOCtryLang has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFSecProtISOCtryLangTable
{
	public static final String TABLE_NAME = "ISOCtryLang";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFSecProtISOCtryLang protcreateISOCtryLang( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLang rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFSecProtISOCtryLang protupdateISOCtryLang( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLang rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteISOCtryLang( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLang rec );
	/**
	 *	Delete the ISOCtryLang instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	public void protdeleteISOCtryLangByIdIdx( ICFSecProtAuthorization Authorization,
		short argISOCtryId,
		short argISOLangId );
	/**
	 *	Delete the ISOCtryLang instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteISOCtryLangByIdIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangPKey argKey );
	/**
	 *	Delete the ISOCtryLang instances identified by the key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	public void protdeleteISOCtryLangByCtryIdx( ICFSecProtAuthorization Authorization,
		short argISOCtryId );

	/**
	 *	Delete the ISOCtryLang instances identified by the key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteISOCtryLangByCtryIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangByCtryIdxKey argKey );
	/**
	 *	Delete the ISOCtryLang instances identified by the key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	public void protdeleteISOCtryLangByLangIdx( ICFSecProtAuthorization Authorization,
		short argISOLangId );

	/**
	 *	Delete the ISOCtryLang instances identified by the key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteISOCtryLangByLangIdx( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangByLangIdxKey argKey );


	/**
	 *	Read the derived ISOCtryLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtISOCtryLang protreadDerived( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangPKey PKey );

	/**
	 *	Read the derived ISOCtryLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtISOCtryLang protreadDerived( ICFSecProtAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Lock the derived ISOCtryLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtISOCtryLang protlockDerived( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangPKey PKey );

	/**
	 *	Read all ISOCtryLang instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFSecProtISOCtryLang[] protreadProtAllDerived( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the derived ISOCtryLang record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFSecProtISOCtryLang protreadDerivedByIdIdx( ICFSecProtAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Read an array of the derived ISOCtryLang record instances identified by the duplicate key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtISOCtryLang[] protreadDerivedByCtryIdx( ICFSecProtAuthorization Authorization,
		short ISOCtryId );

	/**
	 *	Read an array of the derived ISOCtryLang record instances identified by the duplicate key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFSecProtISOCtryLang[] protreadDerivedByLangIdx( ICFSecProtAuthorization Authorization,
		short ISOLangId );

	/**
	 *	Read the specific ISOCtryLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLang protreadRec( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangPKey PKey );

	/**
	 *	Read the specific ISOCtryLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLang protreadRec( ICFSecProtAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Lock the specific ISOCtryLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLang protlockRec( ICFSecProtAuthorization Authorization,
		ICFSecProtISOCtryLangPKey PKey );

	/**
	 *	Read all the specific ISOCtryLang record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOCtryLang instances in the database accessible for the Authorization.
	 */
	public ICFSecProtISOCtryLang[] protreadAllRec( ICFSecProtAuthorization Authorization );

	/**
	 *	Read the specific ISOCtryLang record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLang protreadRecByIdIdx( ICFSecProtAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Read an array of the specific ISOCtryLang record instances identified by the duplicate key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLang[] protreadRecByCtryIdx( ICFSecProtAuthorization Authorization,
		short ISOCtryId );

	/**
	 *	Read an array of the specific ISOCtryLang record instances identified by the duplicate key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecProtISOCtryLang[] protreadRecByLangIdx( ICFSecProtAuthorization Authorization,
		short ISOLangId );
}
