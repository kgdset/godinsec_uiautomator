package com.godin.virtest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

import junit.framework.Assert;

/** 
* @author ypt
* @date 创建时间：2016年4月5日 下午5:08:31 
* @version 1.0   
*/
public class AppStoreModule {
	/**
	 * Id:1
	 * Title:点击商店，打开商店
	 * Checkpoint:判断“安装”存在
	 * @throws UiObjectNotFoundException 
	 */
	public void testOpenAppStore() throws UiObjectNotFoundException{
		KillProcessModule.openGLauncher();
		new UiObject(new UiSelector().text("豌豆荚")).clickAndWaitForNewWindow();
		UiObject install=new UiObject(new UiSelector().text("安装"));
		Assert.assertEquals(true, install.exists());
	}
	
	/**
	 * Id:2
	 * Title:选择应用A，点击安装
	 * Checkpoint:判断“打开”存在
	 * @throws UiObjectNotFoundException 
	 */
	public void testInstallApp() throws UiObjectNotFoundException{
		new UiObject(new UiSelector().text("安装")).click();
		UiObject openApp=new UiObject(new UiSelector().text("打开"));
		Assert.assertEquals(true, openApp.exists());
	}
	
	/**
	 * Id:3
	 * Title:选择应用A，点击打开
	 * Checkpoint:判断应用A启动
	 */
	public void testAppInstalledSuccessfully(){
		
	}
}