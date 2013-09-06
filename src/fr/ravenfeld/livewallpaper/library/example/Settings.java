package fr.ravenfeld.livewallpaper.library.example;

import rajawali.wallpaper.Wallpaper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

// Deprecated PreferenceActivity methods are used for API Level 10 (and lower) compatibility
// https://developer.android.com/guide/topics/ui/settings.html#Overview
@SuppressWarnings("deprecation")
public class Settings extends PreferenceActivity implements
		SharedPreferences.OnSharedPreferenceChangeListener {

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		getPreferenceManager().setSharedPreferencesName(
				Wallpaper.SHARED_PREFS_NAME);
		addPreferencesFromResource(R.xml.settings);
		getPreferenceManager().getSharedPreferences()
				.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		getPreferenceManager().getSharedPreferences()
				.unregisterOnSharedPreferenceChangeListener(this);
		super.onDestroy();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
	}
}