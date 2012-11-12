/*****************************************************************************
Copyright (c) 2012 - Adrián Rodríguez Vargas - www.adrianrodriguez.es

AUTHOR: Adrián Rodríguez Vargas <info@adrianrodriguez.es>

This file is part of Password Generator.

Password Generator is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Password Generator is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Password Generator.  If not, see <http://www.gnu.org/licenses/>.
*****************************************************************************/

package es.adrianrodriguez.passwordgenerator;

import java.util.Locale;

import org.apache.cordova.*;

import com.google.ads.*;

import android.os.Bundle;
import android.widget.LinearLayout;

public class App extends DroidGap {
    /** Called when the activity is first created. */
	private AdView adView;
	private AdRequest request;
	
	public void onStart() {
	    super.onStart();
	    request = new AdRequest();
        adView.loadAd(request);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	if (Locale.getDefault().getLanguage().equals("es")) {
    		super.loadUrl("file:///android_asset/www/index-es.html");	
    	} else {
    		super.loadUrl("file:///android_asset/www/index-en.html");	
    	}
        adView = new AdView(this, AdSize.BANNER, "ADMOB_ID_here"); 
        LinearLayout layout = super.root; 
        layout.setHorizontalGravity(android.view.Gravity.CENTER_HORIZONTAL);
        layout.addView(adView);
        request = new AdRequest();
        //request.addTestDevice("YOUR_ID_for_testing");
        adView.loadAd(request);
        //More info:
        //https://developers.google.com/mobile-ads-sdk/docs/android/intermediate?hl=es-ES
        //http://developer.android.com/guide/topics/location/obtaining-user-location.html
    }
}
