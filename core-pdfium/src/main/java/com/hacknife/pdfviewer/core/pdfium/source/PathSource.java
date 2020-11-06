/*
 * Copyright (C) 2016 Bartosz Schiller.
 *
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
package com.hacknife.pdfviewer.core.pdfium.source;

import android.content.Context;
import android.os.ParcelFileDescriptor;

import com.hacknife.pdfviewer.core.CoreSource;
import com.hacknife.pdfviewer.core.DocumentSource;
import com.hacknife.pdfviewer.core.pdfium.kernel.PdfCoreSource;
import com.shockwave.pdfium.PdfiumCore;

import java.io.File;
import java.io.IOException;

public class PathSource implements DocumentSource {

    private String file;

    public PathSource(String file) {
        this.file = file;
    }


    @Override
    public CoreSource createCore(Context context, String password) throws IOException {
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(new File(file), ParcelFileDescriptor.MODE_READ_ONLY);
        PdfiumCore pdfiumCore = new PdfiumCore(context);
        return PdfCoreSource.create(pdfiumCore.newDocument(pfd, password), pdfiumCore);
    }
}
