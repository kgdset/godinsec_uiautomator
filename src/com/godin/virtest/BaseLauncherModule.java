package com.godin.virtest;

import junit.framework.Assert;
import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/** 
* @author wubin
* @date 创建时间：2016年4月01日 下午5:16:13 
* @version 1.0 
*/
public class BaseLauncherModule extends UiAutomatorTestCase{
	public static void main(String[] args)
	{
		new My_UiAutomatorHelper("BaseLauncherModule","com.godin.virtest.BaseLauncherModule","testStartVirtualPhone","1");
	}
	/**
	 * Id:1
	 * Title:点击虚拟手机图标，进入虚拟手机
	 * Checkpoint:判断桌面上有虚拟手机内置app
	 * @throws RemoteException 
	 * @throws UiObjectNotFoundException 
	 */
	public void testStartVirtualPhone() throws RemoteException, UiObjectNotFoundException{
       UiDevice device=UiDevice.getInstance();
       device.wakeUp();
       device.pressHome();
       UiObject obj=new UiObject(new UiSelector().resourceId("com.android.launcher3:id/hotseat"));
       UiObject appbtn=obj.getChild(new UiSelector().className("android.widget.TextView").index(2));
       appbtn.clickAndWaitForNewWindow();
       UiScrollable collectionObject = new UiScrollable(new UiSelector().scrollable(true));
      
      
if(collectionObject.exists()) {
    	  // collectionObject.scrollForward();
    	   collectionObject.setAsHorizontalList();
    	   UiObject scrollableObject=new UiObject(new UiSelector().description("GLauncher"));
    	   collectionObject.scrollIntoView(scrollableObject);
    	   if(scrollableObject.exists())
    	   {
           scrollableObject.clickAndWaitForNewWindow();
           UiScrollable Gscr=new UiScrollable(new UiSelector().scrollable(true));
           if(Gscr.exists())
           {
        	   UiObject Wdjapp=new UiObject(new UiSelector().resourceId("com.godinsec.glauncher:id/item_image"));
        	   Gscr.scrollIntoView(Wdjapp);
        	   if(!Wdjapp.exists())
        	   {
        		Assert.fail();  
        	   }
           }
           
    	   }
    	   System.out.println("ok");
       } else {
    	   Assert.fail();  
    	   System.out.println("no");
       }
        
	}
	
	/**
	 * Id:2
	 * Title:点击桌面应用图标，启动相应应用
	 * Checkpoint:判断应用启动
	 * @throws RemoteException 
	 * @throws UiObjectNotFoundException 
	 */
	public void testOpenStartApp() throws RemoteException, UiObjectNotFoundException{
		 UiDevice device=UiDevice.getInstance();
	       device.wakeUp();
	       device.pressHome();
	       UiObject obj=new UiObject(new UiSelector().resourceId("com.android.launcher3:id/hotseat"));
	       UiObject appbtn=obj.getChild(new UiSelector().className("android.widget.TextView").index(2));
	       appbtn.clickAndWaitForNewWindow();
	       UiScrollable collectionObject = new UiScrollable(new UiSelector().scrollable(true));
	      
	      
	if(collectionObject.exists()) {
	    	  // collectionObject.scrollForward();
	    	   collectionObject.setAsHorizontalList();
	    	   UiObject scrollableObject=new UiObject(new UiSelector().description("GLauncher"));
	    	   collectionObject.scrollIntoView(scrollableObject);
	    	   if(scrollableObject.exists())
	    	   {
	           scrollableObject.clickAndWaitForNewWindow();
	           UiScrollable Gscr=new UiScrollable(new UiSelector().scrollable(true));
	           if(Gscr.exists())
	           {
	        	   UiObject Wdjapp=new UiObject(new UiSelector().resourceId("com.godinsec.glauncher:id/item_image"));
	        	   Gscr.scrollIntoView(Wdjapp);
	        	   if(!Wdjapp.exists())
	        	   {
	        		Assert.fail();  
	        	   }
	        	   else
	        	   {
	        		   UiObject text=new UiObject(new UiSelector().text("分类"));
	        	   }
	           }
	           
	    	   }
	    	   System.out.println("ok");
	       } else {
	    	   Assert.fail();  
	    	   System.out.println("no");
	       }
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
