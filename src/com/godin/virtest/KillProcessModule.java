package com.godin.virtest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;

import junit.framework.Assert;

/** 
* @author ypt
* @date 创建时间：2016年4月1日 下午5:19:33 
* @version 1.0 
*/
public class KillProcessModule {
	Utility uti=new Utility();
	
	/**
	 * Id:1
	 * Title:点击应用管理，打开应用管理页面
	 * Checkpoint:判断“杀死进程”存在
	 * @throws UiObjectNotFoundException 
	 */
	public void testOpenAppManager() throws UiObjectNotFoundException{
		uti.openGLauncher();
		uti.openSettings();
		uti.byText("应用管理").clickAndWaitForNewWindow();
		UiObject killProcess=uti.byResourceId("com.godinsec.glauncher:id/settings_app_manage_item_kill");
		Assert.assertEquals(true, killProcess.exists());	
	}
	
	/**
	 * Id:2
	 * Title:点击杀死应用进程
	 * Checkpoint:判断“杀死进程”不存在
	 */
	public void testKillOneProcess() {
		UiObject killProcess = uti.byResourceId("com.godinsec.glauncher:id/settings_app_manage_item_kill");
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