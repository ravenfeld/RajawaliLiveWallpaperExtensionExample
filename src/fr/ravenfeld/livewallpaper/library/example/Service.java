package fr.ravenfeld.livewallpaper.library.example;

import fr.ravenfeld.livewallpaper.library.example.renderer.RendererBackgroundFixedEffect;
import fr.ravenfeld.livewallpaper.library.example.renderer.RendererBackgroundFixedScrolling;
import fr.ravenfeld.livewallpaper.library.example.renderer.RendererBackgroundSwipe;
import fr.ravenfeld.livewallpaper.library.example.renderer.RendererTest;
import fr.ravenfeld.livewallpaper.library.example.renderer.RendererText;
import rajawali.wallpaper.Wallpaper;
import android.content.Context;
import fr.ravenfeld.livewallpaper.library.example.renderer.RendererBackgroundFixed;

public class Service extends Wallpaper {
	private RendererBackgroundFixedScrolling mRenderer;

	@Override
	public Engine onCreateEngine() {
		mRenderer = new RendererBackgroundFixedScrolling(this);
		return new WallpaperEngine(this.getSharedPreferences(SHARED_PREFS_NAME,
				Context.MODE_PRIVATE), getBaseContext(), mRenderer, false);
	}

	@Override
	public void onDestroy() {
		mRenderer.onSurfaceDestroyed();
		super.onDestroy();
	}
}