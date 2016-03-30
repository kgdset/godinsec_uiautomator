package com.godin.virtest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import junit.framework.Assert;

public class TestAct extends UiAutomatorTestCase{
	
	public void testWakeUp() throws android.os.RemoteException{
		UiDevice.getInstance().wakeUp();
	}
	
	public void testHome() throws android.os.RemoteException{
		UiDevice.getInstance().pressHome();
		Assert.assertEquals(8, 0);
	}	
}





