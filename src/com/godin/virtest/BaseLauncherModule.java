package com.godin.virtest;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/** 
* @author wubin
* @date 创建时间：2016年4月01日 下午5:16:13 
* @version 1.0 
*/
public class BaseLauncherModule extends UiAutomatorTestCase{
	/**
	 * Id:1
	 * Title:点击虚拟手机图标，进入虚拟手机
	 * Checkpoint判断桌面上有虚拟手机内置app
	 */
	public void testStartVirtualPhone(){
       
	}
	
	/**
	 * Id:2
	 * Title:点击桌面应用图标，启动相应应用
	 * Checkpoint:判断应用启动
	 */
	public void testOpenStartApp(){
     
	}
	
	/**
	 * Id:3
	 * Title:长按桌面应用图标，进行拖动
	 * Checkpoint:判断应用图标被成功拖动到其它位置
	 */
	public void testDragAppIcon(){
		
	}
	
	/**
	 * Id:4
	 * Title:长按桌面应用图标，拖动到另一个应用图标上，可以合并成文件夹
	 * Checkpoint:判断文件夹合并成功
	 */
	public void testDragMergeFolder(){
		
	}
	
	/**
	 * Id:5
	 * Title:长按桌面图标，拖动到删除区域，可以删除应用
	 * Checkpoint:判断应用图标在桌面上不存在
	 */
	public void testDellApp(){
		
	}
	
	/**
	 * Id:6
	 * Title:点击下载完成，开始安装
	 * Checkpoint:判断“安装”存在
	 */
	public void testStartInstallation(){
		
	}
	
	
}
