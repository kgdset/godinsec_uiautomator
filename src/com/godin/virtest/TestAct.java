package com.godin.virtest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


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
	
	/**
	 * 
	 */
	
}





