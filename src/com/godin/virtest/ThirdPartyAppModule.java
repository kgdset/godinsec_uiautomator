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
* @date 创建时间：2016年4月01日 下午5:46:13 
* @version 1.0 
*/
public class ThirdPartyAppModule extends UiAutomatorTestCase{
	/**
	 * Id:1
	 * Title:点击进入应用商店，安装第三方应用
	 * Checkpoint:判断桌面有安装的第三方应用
	 * @throws RemoteException 
	 * @throws UiObjectNotFoundException 
	 */
	public void testInstallApp() throws RemoteException, UiObjectNotFoundException{
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
	        	   UiObject Wdjapp=new UiObject(new UiSelector().text("豌豆荚"));
	        	   Gscr.scrollIntoView(Wdjapp);
	        	   if(!Wdjapp.exists())
	        	   {
	        		Assert.fail();  
	        	   }
	        	   else
	        	   {
	        		   Wdjapp.clickAndWaitForNewWindow();
	        		   sleep(5000);
	        		   UiObject text=new UiObject(new UiSelector().text("必备"));
	        		  text.clickAndWaitForNewWindow();
	        		  UiObject qqtext=new UiObject(new UiSelector().text("QQ"));
	        		  
	        		  
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
	 * Title:点击桌面第三应用图标，启动相应应用
	 * Checkpoint:判断应用启动
	 */
	public void testOpenStartThirdPartyApp(){
     
	}
	
	/**
	 * Id:3
	 * Title:长按桌面图标，拖动到删除区域，可以删除应用
	 * Checkpoint:判断应用图标在桌面上不存在
	 */
	public void testDellThirdPartyApp(){
		
	}
	
	
}
