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

package brut.androlib;

import java.io.File;
import java.io.IOException;
import org.jf.baksmali.baksmali;
import org.jf.dexlib.DexFile;
import org.jf.smali.main;

/**
 * @author Ryszard Wiśniewski <brut.alll@gmail.com>
 */
class AndrolibSmali {
    public void baksmali(File apkFile, File dir) throws AndrolibException {
        baksmali(apkFile.getAbsolutePath(), dir.getAbsolutePath());
    }

    public void baksmali(String apkFile, String dir) throws AndrolibException {
        try {
            DexFile dexFile = new DexFile(apkFile);
            baksmali.disassembleDexFile(dexFile, false, dir, new String[]{}, "", false, true, true, true, false, 0, false);
        } catch (IOException ex) {
            throw new AndrolibException(ex);
        }
    }

    public void smali(File dir, File dexFile) throws AndrolibException {
        smali(dir.getAbsolutePath(), dexFile.getAbsolutePath());
    }

    public void smali(String dir, String dexFile) throws AndrolibException {
        main.main(new String[]{"smali", dir, "-o", dexFile});
    }
}
