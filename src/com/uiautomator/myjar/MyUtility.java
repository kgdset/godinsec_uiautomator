package com.uiautomator.myjar;
import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
/**
 * @author wubin
 * @date 创建时间：2016年4月07日 下午5:16:13
 * @version 1.0
 */
public class MyUtility {

	public void Ready() throws RemoteException
	{
		UiDevice.getInstance().wakeUp();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
	}
	
	 public void openAppBytext(String appname) throws RemoteException, UiObjectNotFoundException{
			Ready();
			UiObject obj = new MyUiSelector().byResourceId("com.google.android.googlequicksearchbox:id/hotseat");
			UiObject appbtn = obj.getChild(new MyUiSelector().className("android.widget.TextView").index(2));
			appbtn.clickAndWaitForNewWindow();
			UiObject scrollableObject = new MyUiScrollable().byText(appname);
			scrollableObject.clickAndWaitForNewWindow();
		}

	public void openSettings() throws RemoteException{
		Ready();
		UiObject settings=new UiObject(new UiSelector().text("设置"));
		try {
			settings.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
}
