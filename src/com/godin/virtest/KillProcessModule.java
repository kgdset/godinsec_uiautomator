package com.godin.virtest;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uiautomator.myjar.MyGodinCustom;
import com.uiautomator.myjar.MyUiScrollable;

import junit.framework.Assert;

/** 
* @author ypt
* @date 创建时间：2016年4月1日 下午5:19:33 
* @version 1.0 
*/
public class KillProcessModule {
	MyGodinCustom uti=new MyGodinCustom();
	
	/**
	 * Id:1
	 * Title:点击应用管理，打开应用管理页面
	 * Checkpoint:判断“杀死进程”存在
	 * @throws UiObjectNotFoundException 
	 * @throws RemoteException 
	 */
	public void testOpenAppManager() throws UiObjectNotFoundException, RemoteException{
		uti.openGLauncher();
		uti.openWdj();
		UiDevice.getInstance().pressHome();
		uti.openSettings();
		uti.openAppManage();
		UiObject killProcess=new MyUiScrollable().byResourceId("com.godinsec.glauncher:id/settings_app_manage_item_kill");
		Assert.assertEquals(true, killProcess.exists());	
		uti.exitApp();
	}
	
	/**
	 * Id:2
	 * Title:点击杀死应用进程
	 * Checkpoint:判断“杀死进程”不存在
	 * @throws UiObjectNotFoundException 
	 * @throws RemoteException 
	 */
	public void testKillOneProcess() throws UiObjectNotFoundException, RemoteException {
		uti.openGLauncher();
		uti.openWdj();
		UiDevice.getInstance().pressHome();
		uti.openSettings();
		uti.openAppManage();
		UiObject killProcess = new MyUiScrollable().byResourceId("com.godinsec.glauncher:id/settings_app_manage_item_kill");
		while (killProcess.exists()) {
			try {
				killProcess.click();
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
		}
		Assert.assertEquals(false, killProcess.exists());
	}
}