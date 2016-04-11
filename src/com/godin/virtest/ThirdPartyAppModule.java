package com.godin.virtest;

import junit.framework.Assert;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uiautomator.myjar.MyGodinCustom;
import com.uiautomator.myjar.MyUiScrollable;
import com.uiautomator.myjar.MyUiSelector;

/**
 * @author wubin
 * @date 创建时间：2016年4月01日 下午5:46:13
 * @version 1.0
 */
public class ThirdPartyAppModule extends UiAutomatorTestCase {
	public static void main(String[] args) {
		new My_UiAutomatorHelper("ThirdPartyAppModule",
				"com.godin.virtest.ThirdPartyAppModule", "testInstallApp", "1");
	}

	/**
	 * Id:1 Title:点击进入应用商店，安装第三方应用 Checkpoint:判断桌面有安装的第三方应用
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 */
	public void testInstallApp() throws RemoteException,
			UiObjectNotFoundException, InterruptedException {
		MyGodinCustom godin = new MyGodinCustom();
		godin.openGLauncher();
		godin.openWdj();
		UiObject btn = new MyUiScrollable().byText("排行榜");
		btn.clickAndWaitForNewWindow();
		UiObject install = new MyUiScrollable().byText("安装");
		UiObject title = install.getFromParent(new MyUiSelector()
				.resourceId("com.wandoujia.phoenix2:id/title"));
		String app_name = title.getText();
		System.out.println(app_name);
		install.click();
		sleep(60000);

		new MyGodinCustom().openGLauncher();
		UiObject app = new MyUiScrollable().byTextContains(app_name);
		// app.waitForExists(60000);
		Assert.assertEquals(true, app.exists());

	}

	/**
	 * Id:2 Title:点击桌面第三应用图标，启动相应应用 Checkpoint:判断应用启动
	 */
	public void testOpenStartThirdPartyApp() {

	}

	/**
	 * Id:3 Title:长按桌面图标，拖动到删除区域，可以删除应用 Checkpoint:判断应用图标在桌面上不存在
	 * @throws UiObjectNotFoundException 
	 * @throws RemoteException 
	 */
	public void testDellThirdPartyApp() throws RemoteException, UiObjectNotFoundException {
		new MyGodinCustom().openGLauncher();
		MyUiScrollable scr=new MyUiScrollable(new MyUiSelector().scrollable(false));
		scr.setAsHorizontalList();
		scr.flingForward();
		UiObject grid = new MyUiSelector()
				.byResourceId("com.godinsec.glauncher:id/dragGridView");

		UiObject appicon = grid.getChild(new MyUiSelector().resourceId(
				"com.godinsec.glauncher:id/item_text"));
		String appname = appicon.getText();
		// appicon.longClick();
		// appicon.dragTo(uninstall, 200);
		appicon.dragTo(566, 136, 300);
		new MyUiSelector().byText("确定").click();
		// appicon.longClick();
		UiObject oldapp = new MyUiScrollable().byText(appname);
		assertEquals(false, oldapp.exists());
	}
	

}
