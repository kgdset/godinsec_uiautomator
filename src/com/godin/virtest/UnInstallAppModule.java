package com.godin.virtest;

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
public class UnInstallAppModule extends UiAutomatorTestCase {

	public static void main(String[] args) {
		new My_UiAutomatorHelper("UnInstallAppModule",
				"com.godin.virtest.UnInstallAppModule", "testUnInstallApp", "1");
	}

	/**
	 * Id:1 Title:长按桌面第三方应用图标，拖动到删除区域，可以卸载应用 Checkpoint:判断应用在桌面不存在，判断应用在应用管理中不存在
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws RemoteException 
	 */
	public void testUnInstallApp() throws UiObjectNotFoundException, RemoteException {
		
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

	/**
	 * Id:2 Title:在应用管理中，卸载第三方应用 Checkpoint:判断应用在桌面不存在，判断应用在应用管理中不存在
	 */
	public void testOpenStartThirdPartyApp() {

	}

}
