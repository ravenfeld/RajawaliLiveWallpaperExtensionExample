package fr.ravenfeld.livewallpaper.library.example;

import rajawali.wallpaper.Wallpaper;
import android.content.Context;
import fr.ravenfeld.livewallpaper.library.example.renderer.RendererBackgroundGIFFixed;

public class Service extends Wallpaper {
	private RendererBackgroundGIFFixed mRenderer;

	@Override
	public Engine onCreateEngine() {
		mRenderer = new RendererBackgroundGIFFixed(this);
		return new WallpaperEngine(this.getSharedPreferences(SHARED_PREFS_NAME,
				Context.MODE_PRIVATE), getBaseContext(), mRenderer, false);
	}

	@Override
	public void onDestroy() {
		mRenderer.onSurfaceDestroyed();
		super.onDestroy();
	}
}