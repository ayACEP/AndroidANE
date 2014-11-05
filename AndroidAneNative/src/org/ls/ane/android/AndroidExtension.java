package org.ls.ane.android;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class AndroidExtension implements FREExtension {

	@Override
	public FREContext createContext(String contextType) {
		Log.i("ane", "AndroidExtension contextType: " + contextType);
		if ("android".equals(contextType)) {
			return new AndroidContext();
		}
		return null;
	}

	@Override
	public void dispose() {
		Log.i("ane", "AndroidExtension dispose");
	}

	@Override
	public void initialize() {
		Log.i("ane", "AndroidExtension initialize");
	}
}
