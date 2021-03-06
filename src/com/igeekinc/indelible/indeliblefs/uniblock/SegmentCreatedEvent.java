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

import com.igeekinc.indelible.oid.EntityID;
import com.igeekinc.indelible.oid.ObjectID;

public class SegmentCreatedEvent extends CASCollectionSegmentEvent
{
	private static final long	serialVersionUID	= 4650080989499410109L;

	public SegmentCreatedEvent(ObjectID segmentID, EntityID source, long eventID, long timestamp)
	{
		super(segmentID, source, eventID, timestamp);
	}

	public SegmentCreatedEvent(ObjectID segmentID, EntityID source)
	{
		super(segmentID, source);
	}

	@Override
	public CASCollectionEventType getEventType()
	{
		return CASCollectionEventType.kSegmentCreated;
	}
	
	public String toString()
	{
		Date displayDate = new Date(getTimestamp());
		return "EventID="+getEventID()+" SegmentCreated="+getSegmentID()+" source="+getSource()+" timestamp="+displayDate;
	}
}
