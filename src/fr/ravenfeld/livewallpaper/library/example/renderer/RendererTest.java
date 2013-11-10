/**
 * Copyright 2013 Alexis Lecanu
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package fr.ravenfeld.livewallpaper.library.example.renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import rajawali.Object3D;
import rajawali.parser.LoaderOBJ;
import rajawali.parser.ParsingException;
import rajawali.renderer.RajawaliRenderer;
import rajawali.util.RajLog;
import rajawali.wallpaper.Wallpaper;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.MotionEvent;
import fr.ravenfeld.livewallpaper.library.example.R;

public class RendererTest extends RajawaliRenderer implements
		SharedPreferences.OnSharedPreferenceChangeListener {

private Object3D mDigito;
	public RendererTest(Context context) {
		super(context);
	}

    @Override
    public void setSharedPreferences(SharedPreferences preferences) {
        super.setSharedPreferences(preferences);
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

	@Override
	protected void initScene() {
		RajLog.systemInformation();
        getCurrentCamera().setZ(15);
        LoaderOBJ objParserNew = new LoaderOBJ (mContext.getResources (), mTextureManager, R.raw.tomahawk_obj);
        mDigito = new Object3D  ();
        try {
            objParserNew.parse ();
            mDigito = objParserNew.getParsedObject ();
        } catch (ParsingException e1) {
            e1.printStackTrace ();
            Log.e("TEST", "ERREUR " + e1.getMessage());
        }
        addChild(mDigito);
        mDigito.setRotZ(90);
    }


	@Override
	public void onDrawFrame(GL10 glUnused) {
		super.onDrawFrame(glUnused);
        mDigito.setRotY(mDigito.getRotY() + 1f);

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
	}
}
