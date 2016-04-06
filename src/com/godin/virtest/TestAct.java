package com.godin.virtest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

<<<<<<< HEAD
=======

>>>>>>> bcde77ca2abc5348bdef47f432d9b619cf51d49b
public class TestAct extends UiAutomatorTestCase{
	/*
	 * 这是第1条用例
	 * 
	 * 
	 */
	public void testWakeUp() throws android.os.RemoteException{
		UiDevice.getInstance().wakeUp();
	}
	
	/*
	 * 这是第2条用例
	 */
	
	public void testHome() throws android.os.RemoteException{
		UiDevice.getInstance().pressHome();
	}	
}




