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
 
package com.igeekinc.indelible.oid;

import java.io.Serializable;

public class CASSegmentID extends ObjectID
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 3258411746367846711L;
	static final public byte kObjectIDType = ObjectID.kCASSegmentOIDType;
	public static void initMapping()
	{
		ObjectIDFactory.addObjectIDClass(kObjectIDType, CASSegmentID.class);
	}
    CASSegmentID(GeneratorID inGeneratorID)
    {
        this.generatorID=inGeneratorID;
        this.type=ObjectID.kCASSegmentOIDType;
    }

    CASSegmentID(String inPlanIDString)
    {
        super.setFromString(inPlanIDString);
    }

    CASSegmentID(byte [] idBytes, int offset)
    {
        super.setFromBytes(idBytes, offset);
    }
}