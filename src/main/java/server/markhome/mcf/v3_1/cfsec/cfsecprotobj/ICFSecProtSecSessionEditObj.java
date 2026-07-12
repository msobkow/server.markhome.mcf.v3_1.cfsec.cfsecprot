// Description: Java 25 Protected Instance Edit Object interface for CFSec SecSession.

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

package server.markhome.mcf.v3_1.cfsec.cfsecprotobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;

public interface ICFSecProtSecSessionEditObj
	extends ICFSecProtSecSessionObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecProtSecSessionObj.
	 */
	ICFSecProtSecSessionObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecProtSecSessionObj.
	 */
	ICFSecProtSecSessionObj getOrigAsSecSession();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecProtSecSessionObj create();

	/*
	 *	Update the instance.
	 */
	ICFSecProtSecSessionEditObj update();

	/*
	 *	Delete the instance.
	 */
	ICFSecProtSecSessionEditObj deleteInstance();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute SecSessionId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute SecSessionId.
	 */
	CFLibDbKeyHash256 getRequiredSecSessionId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute SecSessionId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute SecSessionId value to be applied.
	 */
	void setRequiredSecSessionId(CFLibDbKeyHash256 value);

	/**
	 *	Get the required CFLibDbKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute SecUserId.
	 */
	CFLibDbKeyHash256 getRequiredSecUserId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute SecUserId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute SecUserId value to be applied.
	 */
	void setRequiredSecUserId(CFLibDbKeyHash256 value);

	/**
	 *	Get the optional CFLibDbKeyHash256 attribute SecProxyId.
	 *
	 *	@return	The optional CFLibDbKeyHash256 attribute SecProxyId.
	 */
	CFLibDbKeyHash256 getOptionalSecProxyId();

	/**
	 *	Set the optional CFLibDbKeyHash256 attribute SecProxyId.
	 *
	 *	@param value The optional CFLibDbKeyHash256 attribute SecProxyId value to be applied.
	 */
	void setOptionalSecProxyId(CFLibDbKeyHash256 value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
