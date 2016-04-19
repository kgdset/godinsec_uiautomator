package com.godin.virtest;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uiautomator.myjar.MyGodinCustom;
import com.uiautomator.myjar.MyUiScrollable;
import com.uiautomator.myjar.MyUiSelector;

/**
 * @author xinxue.pu
 * @date 2016-4-18
 * @time 下午6:41:15
 * @version
 */

public class AppProgressMarkModule extends UiAutomatorTestCase {
	public static void main(String[] args) {
		new UiAutomatorHelper("AppProgressMarkModule", "com.godin.virtest.AppProgressMarkModule", "testNotificationMark", "1");
	}
	
	/**
	 * Id:1 Title:点击进入应用商店，安装第三方应用，查看通知栏 Checkpoint:通知栏有“虚拟手机”标记
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 */
	public void testNotificationMark() throws RemoteException,
			UiObjectNotFoundException {
		Utility uti=new Utility();
		uti.openGLauncher();
		uti.byText("豌豆荚").clickAndWaitForNewWindow();
		
		UiObject btn = new MyUiScrollable().byText("排行榜");
		btn.clickAndWaitForNewWindow();
		
		UiObject install = new MyUiScrollable().byText("安装");
		UiObject title = install.getFromParent(new MyUiSelector()
				.resourceId("com.wandoujia.phoenix2:id/title"));
		String app_name = title.getText();
		System.out.println(app_name);
		install.click();
		sleep(5000);
        
		UiDevice.getInstance().openNotification();
//		UiObject ntf_app_name= new UiObject(new UiSelector().textMatches(app_name));
//		UiObject mark_text = ntf_app_name.getFromParent(new UiSelector().textContains("虚"));		
		
		UiObject mark_text = new UiObject(new UiSelector().textContains("虚"));
		sleep(3000);
		assertEquals(true, mark_text.exists());
	}
}
