package org.ls.ane.android {
	
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	public class AndroidAne {
		
		public static const STATUS_CONFIRM: String = "confirm";
		public static const STATUS_CANCEL: String = "cancel";
		
		private static var extContext: ExtensionContext = null;
		
		public function AndroidAne() {
			if (extContext == null) {
				extContext = ExtensionContext.createExtensionContext("org.ls.ane.android", "android");
			}
		}
		
		public function showToast(text: String): void {
			extContext.call("showToast", text);
		}
		
		public function showDialog(title: String, message: String, onClickHandler: Function): void {
			extContext.addEventListener(StatusEvent.STATUS, onClickHandler);
			extContext.call("showDialog", title, message);
		}
		
		public function getWifiMacAddress(): String {
			return extContext.call("getWifiMacAddress") as String;
		}
	}
}
