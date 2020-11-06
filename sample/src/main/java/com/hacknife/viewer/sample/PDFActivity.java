package com.hacknife.viewer.sample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hacknife.pdfviewer.PDFView;

import com.hacknife.pdfviewer.core.mupdf.source.AssetSource;
import com.hacknife.pdfviewer.scroll.DefaultScrollHandle;
import com.hacknife.pdfviewer.util.FitPolicy;

public class PDFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromSource(new AssetSource("sample.pdf"))
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .swipeHorizontal(false)
                .enableSwipe(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(0) // in dp
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();
    }
}
