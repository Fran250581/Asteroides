package com.example.fran.asteroides;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String category = getArguments().getString("category");
        if (category != null) {
            if (category.equals("categoria_general")) {
                addPreferencesFromResource(R.xml.prefs_general);
            } else if (category.equals("categoria_multijugador")) {
                addPreferencesFromResource(R.xml.prefs_multijugador);
            }
        }
    }

}
