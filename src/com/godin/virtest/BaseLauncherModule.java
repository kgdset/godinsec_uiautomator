package com.godin.virtest;

import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uiautomator.myjar.MyGodinCustom;
import com.uiautomator.myjar.MyUiScrollable;
import com.uiautomator.myjar.MyUiSelector;
import com.uiautomator.myjar.My_UiAutomatorHelper;

/**
 * @author wubin
 * @date 创建时间：2016年4月01日 下午5:16:13
 * @version 1.0
 */
public class BaseLauncherModule extends UiAutomatorTestCase {
	public static void main(String[] args) {
		new My_UiAutomatorHelper("BaseLauncherModule",
				"com.godin.virtest.BaseLauncherModule", "testOpenStartApp", "1");
	}

	/**
	 * Id:1 Title:点击虚拟手机图标，进入虚拟手机 Checkpoint:判断桌面上有虚拟手机内置app
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testStartVirtualPhone() throws RemoteException,
			UiObjectNotFoundException {

		new MyGodinCustom().openGLauncher();

		UiObject Wdjapp = new MyUiScrollable().byText("豌豆荚");
		assertEquals(true, Wdjapp.exists());

	}

	/**
	 * Id:2 Title:点击桌面应用图标，启动相应应用 Checkpoint:判断应用启动
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testOpenStartApp() throws RemoteException,
			UiObjectNotFoundException {

		MyGodinCustom godin = new MyGodinCustom();
		godin.openGLauncher();
		godin.openWdj();
		sleep(5000);

		UiObject text = new MyUiScrollable().byText("分类");
		assertEquals(true, text.exists());

	}

	/**
	 * Id:3 Title:长按桌面应用图标，进行拖动 Checkpoint:判断应用图标被成功拖动到其它位置
	 */
	public void testDragAppIcon() {

	}

	/**
	 * Id:4 Title:长按桌面应用图标，拖动到另一个应用图标上，可以合并成文件夹 Checkpoint:判断文件夹合并成功
	 */
	public void testDragMergeFolder() {

	}

	/**
	 * Id:5 Title:长按桌面图标，拖动到删除区域，可以删除应用 Checkpoint:判断应用图标在桌面上不存在
	 * @throws UiObjectNotFoundException 
	 * @throws RemoteException 
	 */
	public void testDellApp() throws UiObjectNotFoundException, RemoteException {
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
