package org.ls.ane.android;

import java.util.HashMap;
import java.util.Map;

import org.ls.ane.android.function.GetWifiMacAddress;
import org.ls.ane.android.function.ShowDialog;
import org.ls.ane.android.function.ShowToast;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class AndroidContext extends FREContext {
	
	private Map<String, FREFunction> functionMap;
	
	@Override
	public void dispose() {
		Log.i("ane", "AndroidContext dispose");
	}
	
	@Override
	public Map<String, FREFunction> getFunctions() {
		Log.i("ane", "AndroidContext getFunctions");
		functionMap = new HashMap<String, FREFunction>();
		functionMap.put("showToast", new ShowToast());
		functionMap.put("showDialog", new ShowDialog());
		functionMap.put("getWifiMacAddress", new GetWifiMacAddress());
		return functionMap;
	}
}
