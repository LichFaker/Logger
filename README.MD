# Logger

#### An android log util that help you review the code better.
<br>
Thanks to <https://github.com/orhanobut/logger>

### Provides
* Class information
* Method information
* Jump to source
* Default tag
* Simple to use 

#### Download

1. Add it in your root build.gradle at the end of repositories:

		allprojects {
			repositories {
				...
				maven { url "https://jitpack.io" }
			}
		}
	
2. Add the dependency

		dependencies {
	        compile 'com.github.LichFaker:Logger:v1.0.0'
		}



#### Examples

		Logger.setLevel(true); // true means print, debug mode

		Logger.i("onCreate");
        Logger.i("Hello %s", "LichFaker");
        Logger.d("onStart");
        Logger.d("onResume %tF",System.currentTimeMillis());
		Logger.e("onDestroy", new Exception("Bye bye"));
		
![example1](screenshot/1.png)

![example1](screenshot/2.png)

### License

	Copyright 2015 LichFaker

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 	implied.
	See the License for the specific language governing permissions and
	imitations under the License.
