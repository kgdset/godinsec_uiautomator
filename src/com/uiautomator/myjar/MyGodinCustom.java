package com.uiautomator.myjar;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * @author wubin
 * @date 创建时间：2016年4月07日 下午5:16:13
 * @version 1.0
 */
public class MyGodinCustom extends UiAutomatorTestCase {
	public void openGLauncher() throws UiObjectNotFoundException,
			RemoteException {

		new MyUtility().openAppBytext("虚拟手机");
		UiObject obj = new MyUiSelector().byText("马上开始");
		sleep(10000);
		while (obj.exists()) {
			obj.clickAndWaitForNewWindow();
		}
	}

	public void openWdj() throws UiObjectNotFoundException, RemoteException {
		new MyUiScrollable().byText("豌豆荚").clickAndWaitForNewWindow();

		UiObject obj = new MyUiSelector().byText("跳过");
		while (obj.waitForExists(10000)) {
			obj.clickAndWaitForNewWindow();
		}
		
	}

	public void openSettings() throws UiObjectNotFoundException,
			RemoteException {
		new MyUiScrollable().byText("设置").clickAndWaitForNewWindow();


	}
	public void openAppManage() throws RemoteException, UiObjectNotFoundException
	{
		openSettings();
		UiObject obj=new MyUiScrollable().byText("应用管理");
		obj.clickAndWaitForNewWindow();
		
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
