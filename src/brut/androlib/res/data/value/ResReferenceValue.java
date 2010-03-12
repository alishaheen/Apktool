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

import brut.androlib.AndrolibException;
import brut.androlib.res.data.ResPackage;
import brut.androlib.res.data.ResResSpec;

/**
 * @author Ryszard Wiśniewski <brut.alll@gmail.com>
 */
public class ResReferenceValue extends ResIntValue {
    private final ResPackage mPackage;
    private final boolean mTheme;

    public ResReferenceValue(ResPackage package_, int value) {
        this(package_, value, false);
    }
    
    public ResReferenceValue(ResPackage package_, int value, boolean theme) {
        super(value);
        mPackage = package_;
        mTheme = theme;
    }

    @Override
    public String toResXmlFormat() throws AndrolibException {
        if (isNull()) {
            return "@null";
        }
//        try {
        return
            (mTheme ? '?' : '@') +
            getReferent().getFullName(mPackage, mTheme);
//        } catch (AndrolibException ex) {
//            return "@" + String.valueOf(mValue);
//        }
    }

    public ResResSpec getReferent() throws AndrolibException {
        return mPackage.getResTable().getResSpec(getValue());
    }

    public boolean isNull() {
        return mValue == 0;
    }
}
