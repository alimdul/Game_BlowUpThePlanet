package controller;

import java.util.prefs.BackingStoreException;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class PreferencesClass implements PreferenceChangeListener {

    private Preferences preferences = Preferences.userRoot().node("preferences");
    private int level;

    public PreferencesClass() {

        preferences.addPreferenceChangeListener(this);
        level = preferences.getInt("level", 0);
    }

    @Override
    public void preferenceChange(PreferenceChangeEvent evt) {
        level = preferences.getInt("level", 0);
    }

    public void clear() {
        try {
            preferences.clear();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    public int getLevel() {
        return preferences.getInt("level", 0);
    }

    public void setLevel(int level) {
        preferences.putInt("level", level);
    }

}
