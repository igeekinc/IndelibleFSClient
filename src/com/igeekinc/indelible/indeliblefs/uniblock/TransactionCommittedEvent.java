/*
 * Copyright 2002-2014 iGeek, Inc.
 * All Rights Reserved
 * @Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.@
 */
 
package com.igeekinc.indelible.indeliblefs.uniblock;

import java.util.Date;

import com.igeekinc.indelible.indeliblefs.core.IndelibleFSTransaction;
import com.igeekinc.indelible.oid.EntityID;

public class TransactionCommittedEvent extends CASCollectionEvent
{
	private static final long	serialVersionUID	= -1871970852109773552L;
	IndelibleFSTransaction transaction;
	public TransactionCommittedEvent(IndelibleFSTransaction transaction, EntityID source, long eventID, long timestamp)
	{
		super(source, eventID, timestamp);
		this.transaction = transaction;
	}

	public TransactionCommittedEvent(IndelibleFSTransaction transaction, EntityID source)
	{
		super(source);
		this.transaction = transaction;
	}

	@Override
	public CASCollectionEventType getEventType()
	{
		return CASCollectionEventType.kTransactionCommited;
	}

	public IndelibleFSTransaction getTransaction()
	{
		return transaction;
	}
	
	public String toString()
	{
		Date displayDate = new Date(getTimestamp());
		return "EventID="+getEventID()+"TransactionCommited="+getTransaction().getTransactionID()+" source="+getSource()+" timestamp="+displayDate;
	}
}
