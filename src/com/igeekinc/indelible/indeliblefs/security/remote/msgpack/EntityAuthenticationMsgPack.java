/*
 * Copyright 2002-2014 iGeek, Inc.
 * All Rights Reserved
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igeekinc.indelible.indeliblefs.security.remote.msgpack;

import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;

import org.apache.log4j.Logger;
import org.msgpack.annotation.Message;

import com.igeekinc.indelible.indeliblefs.security.EntityAuthentication;
import com.igeekinc.util.logging.ErrorLogMessage;

@Message
public class EntityAuthenticationMsgPack
{
	X509CertificateMsgPack x509Certificate;
	public EntityAuthenticationMsgPack()
	{
		// for message pack
	}
	
	public EntityAuthenticationMsgPack(EntityAuthentication entityAuthentication)
	{
		try
		{
			x509Certificate = new X509CertificateMsgPack(entityAuthentication.getCertificate());
		} catch (CertificateEncodingException e)
		{
			Logger.getLogger(getClass()).error(new ErrorLogMessage("Caught exception"), e);
			throw new InternalError("Bad certificate");
		}
	}
	
	public EntityAuthentication getEntityAuthentication()
	{
		try
		{
			return new EntityAuthentication(x509Certificate.getX509Certificate());
		} catch (CertificateException e)
		{
			Logger.getLogger(getClass()).error(new ErrorLogMessage("Caught exception"), e);
			throw new InternalError("Bad certificate");
		}
	}
}
