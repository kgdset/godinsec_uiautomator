package com.godin.virtest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

import junit.framework.Assert;

/** 
* @author ypt
* @date 创建时间：2016年4月1日 下午5:19:33 
* @version 1.0 
*/
public class KillProcessModule {
	/**
	 * Id:1
	 * Title:点击应用管理，打开应用管理页面
	 * Checkpoint:判断“杀死进程”存在
	 * @throws UiObjectNotFoundException 
	 */
	public void testOpenAppManager() throws UiObjectNotFoundException{
		openGLauncher();
		openSettings();
		new UiObject(new UiSelector().text("应用管理")).clickAndWaitForNewWindow();
		UiObject killProcess=new UiObject(new UiSelector().resourceIdMatches("com.godinsec.glauncher:id/settings_app_manage_item_kill"));
		Assert.assertEquals(true, killProcess.exists());	
	}
	
	/**
	 * Id:2
	 * Title:点击杀死应用一进程
	 * Checkpoint:判断“应用一”不存在
	 */
	public void testKillOneProcess(){
		
	}
	
	/**
	 * Id:3
	 * Title:点击杀死2个进程
	 * Checkpoint:判断“杀死进程”按钮减少了2个
	 */
	public void testKillTwoProcess(){
		
	}
	
	/**
	 * Id:4
	 * Title:点击杀死所有进程
	 * Checkpoint:判断“杀死进程”按钮不存在
	 */
	public void testKillAllProcess(){
		
	}
	
	/**
	 * Id:5
	 * Title:应用管理页面，点击返回
	 * Checkpoint:判断“设置”存在
	 */
	public void testExitAppManager(){
		
	}
	
	/**
	 * 打开GLauncher
	 */
	public static void openGLauncher(){
		UiObject gLauncher=new UiObject(new UiSelector().text("GLauncher"));
		try {
			gLauncher.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 打开设置
	 */
	public static void openSettings(){
		UiObject settings=new UiObject(new UiSelector().text("设置"));
		try {
			settings.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}