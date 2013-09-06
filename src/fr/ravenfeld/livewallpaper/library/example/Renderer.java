package fr.ravenfeld.livewallpaper.library.example;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import rajawali.Camera2D;
import rajawali.materials.textures.ATexture.TextureException;
import rajawali.renderer.RajawaliRenderer;
import rajawali.wallpaper.Wallpaper;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.MotionEvent;
import fr.ravenfeld.livewallpaper.library.objects.simple.BackgroundSwipe;

public class Renderer extends RajawaliRenderer implements
		SharedPreferences.OnSharedPreferenceChangeListener {
	private final SharedPreferences mSharedPreferences;

	private BackgroundSwipe mBackgroundSwipe;


	public Renderer(Context context) {
		super(context);

		mSharedPreferences = context.getSharedPreferences(
				Wallpaper.SHARED_PREFS_NAME, 0);
		mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void initScene() {
		Camera2D cam = new Camera2D();
		this.replaceAndSwitchCamera(getCurrentCamera(), cam);
		getCurrentScene().setBackgroundColor(Color.RED);
		getCurrentCamera().setLookAt(0, 0, 0);

		try {
			mBackgroundSwipe = new BackgroundSwipe("bg1", R.drawable.bg);

		} catch (TextureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addChild(mBackgroundSwipe.getObject3D());

	}



	@Override
	public void onDrawFrame(GL10 glUnused) {
		super.onDrawFrame(glUnused);
	}

	@Override
	public void onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		super.onSurfaceChanged(gl, width, height);
		if (mBackgroundSwipe != null) {
			mBackgroundSwipe.surfaceChanged(width, height);
		}
	}

	@Override
	public void onVisibilityChanged(boolean visible) {
		super.onVisibilityChanged(visible);

	}

	@Override
	public void onSurfaceDestroyed() {

		super.onSurfaceDestroyed();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
	}

	@Override
	public void onOffsetsChanged(float xOffset, float yOffset,
			float xOffsetStep, float yOffsetStep, int xPixelOffset,
			int yPixelOffset) {
		if (mBackgroundSwipe != null) {
			mBackgroundSwipe.offsetsChanged(xOffset);
		}
	}
}
