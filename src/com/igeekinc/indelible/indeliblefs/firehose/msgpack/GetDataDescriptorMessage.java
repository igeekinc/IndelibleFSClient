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
package com.igeekinc.indelible.indeliblefs.firehose.msgpack;

import org.msgpack.annotation.Message;

import com.igeekinc.firehose.CommandResult;
import com.igeekinc.indelible.indeliblefs.datamover.msgpack.NetworkDataDescriptorMsgPack;
import com.igeekinc.indelible.indeliblefs.firehose.IndelibleFSServerCommand;
import com.igeekinc.indelible.indeliblefs.firehose.IndelibleFSFirehoseClient;
import com.igeekinc.indelible.indeliblefs.firehose.IndelibleFSForkHandle;
import com.igeekinc.indelible.indeliblefs.firehose.proxies.IndelibleFSServerConnectionProxy;
import com.igeekinc.indelible.indeliblefs.uniblock.CASIDDataDescriptor;
import com.igeekinc.util.async.AsyncCompletion;

@Message
public class GetDataDescriptorMessage<A> extends
		IndelibleFSForkCommandMessage<CASIDDataDescriptor, A, NetworkDataDescriptorMsgPack>
{
	public long offset, dataLength;
	
	public GetDataDescriptorMessage()
	{
		// for message pack
	}

	public GetDataDescriptorMessage(
			IndelibleFSFirehoseClient client,
			IndelibleFSServerConnectionProxy connection,
			IndelibleFSForkHandle forkHandle,
			long offset, long length,
			AsyncCompletion<CASIDDataDescriptor, A> callerCompletionHandler, A attachment)
	{
		super(client, connection, forkHandle, callerCompletionHandler,
				attachment);
		this.offset = offset;
		this.dataLength = length;
	}

	@Override
	protected CASIDDataDescriptor getValueFromResult(NetworkDataDescriptorMsgPack result)
	{
		return result.getNetworkDataDescriptor();
	}

	@Override
	public Class<NetworkDataDescriptorMsgPack> getResultClass()
	{
		return NetworkDataDescriptorMsgPack.class;
	}

	@Override
	public CommandResult execute(IndelibleFSFirehoseServerIF server,
			IndelibleFSClientInfoIF clientInfo) throws Exception
	{
		return server.readDataDescriptor(clientInfo, getConnectionHandle(), forkHandle, offset, dataLength);
	}

	@Override
	protected IndelibleFSServerCommand getInitServerCommand()
	{
		return IndelibleFSServerCommand.kGetDataDescriptor;
	}
}
