package com.godin.virtest;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uiautomator.myjar.MyUiScrollable;
import com.uiautomator.myjar.MyUiSelector;
import com.uiautomator.myjar.UiAutomatorHelper;
import com.uiautomator.myjar.Utility;

/**
 * @author xinxue.pu
 * @date 2016-4-18
 * @time 下午6:41:15
 * @version
 */

public class AppProgressMarkModule extends UiAutomatorTestCase {
	public static void main(String[] args) {
		new UiAutomatorHelper("AppProgressMarkModule", "com.godin.virtest.AppProgressMarkModule", "testProgressMark", "1");
	}
	
	/**
	 * Id:1 Title:进入虚拟手机，打开豌豆荚，安装第三方应用，查看通知栏 Checkpoint:通知栏有“虚拟手机”标记
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testNotificationMark() throws RemoteException,
			UiObjectNotFoundException {
		Utility uti=new Utility();
		uti.openGLauncher();
		uti.byText("豌豆荚").clickAndWaitForNewWindow();
		
		UiObject btn = new MyUiScrollable().byText("排行榜");
		btn.clickAndWaitForNewWindow();
		UiObject ignore = new UiObject (new UiSelector().text("忽略"));
		while (ignore.exists()){
			System.out.println("click 忽略!!!");
			ignore.click();	
		}
		
		UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(false));
//		scroll.setAsVerticalList();
		UiObject install = new UiObject(new UiSelector().text("安装"));
		scroll.scrollIntoView(install);
		
		UiObject title = install.getFromParent(new MyUiSelector()
				.resourceId("com.wandoujia.phoenix2:id/title"));
		String app_name = title.getText();
		System.out.println(app_name);
		install.click();
		sleep(5000);
        
		UiDevice.getInstance().openNotification();		
		UiObject mark_text = new UiObject(new UiSelector().textContains("(虚"));
		sleep(3000);
		assertEquals(true, mark_text.exists());
	}

	/**
	 * Id:2 Title:进入虚拟手机，打开豌豆荚，查看进程 Checkpoint:进程有“虚拟手机”标记
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testProgressMark() throws RemoteException,
			UiObjectNotFoundException {
		Utility uti = new Utility();
		uti.openGLauncher();
		uti.byText("豌豆荚").clickAndWaitForNewWindow();
		sleep(5000);
		UiObject text = new MyUiScrollable().byText("推荐");
		text.waitForExists(15000);		
		UiDevice.getInstance().pressRecentApps();
		UiObject mark_text = new UiObject(new UiSelector().textContains("（虚拟手机）"));
		sleep(3000);
		assertEquals(true, mark_text.exists());	
	}
	
	
	
}
