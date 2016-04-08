package com.godin.virtest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

import android.os.RemoteException;

/**
 * @author ypt
 * @date 创建时间：2016年4月7日 上午9:57:38
 * @version 1.0
 */
public class Utility {
	
	public UiObject byText(String text) {
		return new UiObject(new UiSelector().textMatches(text));
	}

	public UiObject byDescription(String text) {
		return new UiObject(new UiSelector().descriptionMatches(text));
	}

	public UiObject byClassName(String text) {
		return new UiObject(new UiSelector().classNameMatches(text));
	}

	public UiObject byResourceId(String text) {
		return new UiObject(new UiSelector().resourceIdMatches(text));
	}

	public UiObject byPackageName(String text) {
		return new UiObject(new UiSelector().packageNameMatches(text));
	}

	public UiObject byIndex(int index) {
		return new UiObject(new UiSelector().index(index));
	}

	public UiObject byInstance(int instance) {
		return new UiObject(new UiSelector().instance(instance));
	}
	
	public void sleep(int s){
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void exitApp(){
		
	}

	public void openGLauncher() throws UiObjectNotFoundException {
		UiDevice device = UiDevice.getInstance();
		try {
			device.wakeUp();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		device.pressHome();
		UiObject obj = new UiObject(new UiSelector().resourceId("com.android.launcher3:id/hotseat"));
		UiObject appbtn = obj.getChild(new UiSelector().className("android.widget.TextView").index(2));
		appbtn.clickAndWaitForNewWindow();
		UiScrollable collectionObject = new UiScrollable(new UiSelector().scrollable(true));

		if (collectionObject.exists()) {
			// collectionObject.scrollForward();
			collectionObject.setAsHorizontalList();
			UiObject scrollableObject = byDescription("GLauncher");
			collectionObject.scrollIntoView(scrollableObject);
			scrollableObject.clickAndWaitForNewWindow();
		}
	}

	public void openSettings(){
		UiObject settings=new UiObject(new UiSelector().text("设置"));
		try {
			settings.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
