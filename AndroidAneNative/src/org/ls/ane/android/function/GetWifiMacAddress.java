package org.ls.ane.android.function;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class GetWifiMacAddress implements FREFunction {
	
	@Override
	public FREObject call(final FREContext freContext, FREObject[] args) {
		Log.i("ane", "GetWifiMacAddress");
		try {
			WifiManager wifiManager = (WifiManager) freContext.getActivity().getSystemService(Context.WIFI_SERVICE);
			String macAddress = wifiManager.getConnectionInfo().getMacAddress();
			return FREObject.newObject(macAddress);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
}
