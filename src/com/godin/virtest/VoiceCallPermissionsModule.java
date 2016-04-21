package com.godin.virtest;

import android.os.RemoteException;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uiautomator.myjar.UiAutomatorHelper;
import com.uiautomator.myjar.Utility;

/**
 * @author xinxue.pu
 * @date 2016-4-20下午5:21:38
 * @version 1.0
 * 
 */

public class VoiceCallPermissionsModule extends UiAutomatorTestCase{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UiAutomatorHelper("VoiceCallPermissionsModule", "com.godin.virtest.VoiceCallPermissionsModule", "testCallSystemCall", "1");
	}
	
	/**
	 * Id:1 Case1:进入虚拟手机，点击拨号，进入系统拨号界面 Checkpoint:找到“拨号键盘”
	 * Case2:输入号码，点击拨号 Checkpoint:拨号成功，通话记录宿主机无，虚拟手机有
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testVoiceCallRecord() throws RemoteException,
			UiObjectNotFoundException {
		Utility uti=new Utility();
		uti.openGLauncher();	
		UiObject dial = new UiObject(new UiSelector().text("拨号"));
		dial.clickAndWaitForNewWindow();
		sleep(5000);
		UiObject dial_pad = new UiObject(new UiSelector().resourceId("com.android.dialer:id/floating_action_button"));
//		assertEquals(true, dial_pad.exists());
		String dial_pad_desc = dial_pad.getContentDescription();
		System.out.println("description:"+ dial_pad_desc);
		assertEquals("拨号键盘", dial_pad_desc);	
		
//		case2
		dial_pad.click();
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_1);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_0);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_0);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_1);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_0);
		UiObject dial_out = new UiObject(new UiSelector().description("拨打"));
		dial_out.click();
		UiObject iscalling = new UiObject(new UiSelector().text("正在拨号"));
		assertEquals(true, iscalling.exists());
		//need add call success
		UiObject hang_up = new UiObject (new UiSelector().description("挂断"));
		hang_up.click();
		//host has no records
		UiObject zuijin = new UiObject(new UiSelector().text("最近"));
		zuijin.click();
		UiObject elem10010 = new UiObject(new UiSelector().text("10010"));
		assertEquals(false, elem10010.exists());
		UiDevice.getInstance().pressHome();
		//VPT has records
		uti.openGLauncher();	
		UiObject dial_v = new UiObject(new UiSelector().text("拨号"));
		dial_v.clickAndWaitForNewWindow();
		UiObject zuijin_v = new UiObject(new UiSelector().text("最近"));
		zuijin_v.click();
		UiObject elem10010_v = new UiObject(new UiSelector().text("10010"));
		assertEquals(true, elem10010_v.exists());
		
	}
	
	/**
	 * Id:2 Title:通讯录 Checkpoint:
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testContact() throws RemoteException,
			UiObjectNotFoundException {		

		
	}
	
	/**
	 * Id:3 Title:通话记录删除 Checkpoint:
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testVoiceCallRecordDelete() throws RemoteException,
			UiObjectNotFoundException {		

		
	}
	
	/**
	 * Id:4 Title:通讯录删除 Checkpoint:
	 * 
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testContactDelete() throws RemoteException,
			UiObjectNotFoundException {		

		
	}
	
	
}
