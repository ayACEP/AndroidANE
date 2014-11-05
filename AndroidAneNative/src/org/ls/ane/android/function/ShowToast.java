package org.ls.ane.android.function;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class ShowToast implements FREFunction {
	
	@Override
	public FREObject call(FREContext freContext, FREObject[] args) {
		Log.i("ane", "ShowToast");
		try {
			final String text = args[0].getAsString();
			Log.i("ane", "ShowToast");
			final Context androidContext = freContext.getActivity();
			Log.i("ane", "ShowToast");
			new Handler().post(new Runnable() {
				@Override
				public void run() {
					Log.i("ane", "ShowToast");
					Toast.makeText(androidContext, text, Toast.LENGTH_SHORT).show();
					Log.i("ane", "ShowToast");
				}
			});
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
}
