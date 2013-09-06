#RajawaliLiveWallpaperExtensionExample


Example to use RajawaliLiveWallpaperExtension (thanks to Rajawali)


## Usage

Please check out the [project](https://github.com/ravenfeld/RajawaliLiveWallpaperExtensionExample/tree/master).


### How to integrate it ?

#### Eclipse
 You have to [download it](https://github.com/ravenfeld/RajawaliLiveWallpaperExtension/archive/master.zip) 
 You have to [download it](https://github.com/ravenfeld/Rajawali/archive/master.zip) 
 
 Import the **RajawaliLiveWallpaperExtensionExample-master** folder in your Eclipse.
 
 Add Rajawali to RajawaliLiveWallpaperExtension as an Android Library Project

 Add RajawaliLiveWallpaperExtension to RajawaliLiveWallpaperExtensionExample as an Android Library Project
   
### How to use it ?
Replaced CLASS_RENDERER by the class you want to test

`` java
private CLASS_RENDERER mRenderer;

@Override
public Engine onCreateEngine() {
	mRenderer = new CLASS_RENDERER(this);
	return new WallpaperEngine(this.getSharedPreferences(SHARED_PREFS_NAME,
			Context.MODE_PRIVATE), getBaseContext(), mRenderer, false);
}
``	  
## Developed by
  * Alexis Lecanu alias Ravenfeld - [alexis.lecanu@gmail.com](mailto:alexis.lecanu@gmail.com)
    	
## Tested 
  * Galaxy S3
  * Galaxy Tab 10 
    
## Bugs
  * 
  
## Licence
    
Copyright 2013-2014 - Alexis Lecanu ([alexis.lecanu@gmail.com](mailto:alexis.lecanu@gmail.com))
    
Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

  [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)
    
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
