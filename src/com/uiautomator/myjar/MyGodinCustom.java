package com.uiautomator.myjar;

import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MyGodinCustom extends UiAutomatorTestCase{
	 public void openGLauncher() throws UiObjectNotFoundException, RemoteException {
			
		 new MyUtility().openAppBytext("GLauncher");
		 UiObject obj=new MyUiSelector().byText("马上开始");
		 sleep(10000);
		  while(obj.exists())
		 {
			 obj.clickAndWaitForNewWindow();
		 }
		}
	 public void openWdj() throws UiObjectNotFoundException, RemoteException {
		 new MyUiScrollable().byText("豌豆荚").clickAndWaitForNewWindow();
	
		 UiObject obj=new MyUiSelector().byText("跳过");
		  while(obj.waitForExists(10000))
		 {
			 obj.clickAndWaitForNewWindow();
		 }
		}
	
}
