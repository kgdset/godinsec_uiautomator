package com.uiautomator.myjar;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;

/**
 * @author wubin
 * @date 创建时间：2016年4月07日 下午5:16:13
 * @version 1.0
 */

public class MyUtility {
	public void mRegisterWatcher(final String name) {
		UiDevice.getInstance().registerWatcher(name, new UiWatcher() {
			UiObject obj1 = new MyUiSelector().byText(name);
			public boolean checkForCondition() {
				if(obj1.exists())
				{
					try {
						obj1.clickAndWaitForNewWindow();
					} catch (UiObjectNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}
						// TODO Auto-generated method stub
				return false;
			}
		});

	}

	public void Ready() throws RemoteException {
		UiDevice.getInstance().wakeUp();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		mRegisterWatcher("跳过");
		mRegisterWatcher("忽略");
		mRegisterWatcher("马上开始");
	}

	public void openAppBytext(String appname) throws RemoteException,
			UiObjectNotFoundException {
		Ready();
		UiObject obj = new MyUiSelector()
				.byResourceId("com.google.android.googlequicksearchbox:id/hotseat");
		UiObject appbtn = obj.getChild(new MyUiSelector().className(
				"android.widget.TextView").index(2));
		appbtn.clickAndWaitForNewWindow();
		UiObject scrollableObject = new MyUiScrollable().byText(appname);
		scrollableObject.clickAndWaitForNewWindow();
	}

	public void openSettings() throws RemoteException {
		Ready();
		UiObject settings = new UiObject(new UiSelector().text("设置"));
		try {
			settings.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void sleep(int s){
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void exitApp(){
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		sleep(1);
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		sleep(1);
		UiDevice.getInstance().pressHome();
	}
}
