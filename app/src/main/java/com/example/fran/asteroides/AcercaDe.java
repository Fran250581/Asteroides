package com.example.fran.asteroides;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AcercaDe extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);

        TextView tv = findViewById(R.id.TextoAcercaDe);
        String texto = getString(R.string.acercaDe);
        tv.setText(Html.fromHtml(texto));
    }
}

