/*
 *  Copyright 2010 Ryszard Wiśniewski <brut.alll@gmail.com>.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package brut.androlib.res.data.value;

import java.util.Map;

/**
 * @author Ryszard Wiśniewski <brut.alll@gmail.com>
 */
public class ResAttrFactory {
    static ResValue factory(ResReferenceValue parent,
            Map<ResReferenceValue, ResScalarValue> items) {
        int type = ((ResIntValue) items.values().iterator().next()).getValue();

        int attrType = type & 0x0000ffff;
        switch (type & 0x00ff0000) {
            case TYPE_ENUM:
                return new ResEnumAttr(parent, items, attrType);
            case TYPE_SET:
                return new ResSetAttr(parent, items, attrType);
        }
        return new ResAttr(parent, items, attrType);
    }

    private final static int TYPE_ENUM = 0x00010000;
    private final static int TYPE_SET = 0x00020000;
}
