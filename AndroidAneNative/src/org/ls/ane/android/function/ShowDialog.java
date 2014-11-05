package org.ls.ane.android.function;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class ShowDialog implements FREFunction {
	
	public static final String STATUS_CONFIRM = "confirm";
	public static final String STATUS_CANCEL = "cancel";
	
	@Override
	public FREObject call(final FREContext freContext, FREObject[] args) {
		Log.i("ane", "ShowDialog");
		try {
			final String title = args[0].getAsString();
			final String message = args[1].getAsString();
			
			new Handler().post(new Runnable() {
				@Override
				public void run() {
					AlertDialog dialog = new AlertDialog.Builder(freContext.getActivity())
					.setTitle(title)
					.setMessage(message)
					.setPositiveButton("确定", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							freContext.dispatchStatusEventAsync("confirm", "dialog");
						}
					})
					.setNegativeButton("取消", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							freContext.dispatchStatusEventAsync("cancel", "dialog");
						}
					})
					.create();
					dialog.show();
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
