package com.godin.virtest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uiautomator.myjar.Utility;

import junit.framework.Assert;

/** 
* @author ypt
* @date 创建时间：2016年4月5日 下午5:03:10 
* @version 1.0  
*/
public class WhiteListPrompt {
	Utility uti=new Utility();
	
	/**
	 * Id:1
	 * Title:安装VirtualPhone，点击图标，启动虚拟手机APP
	 * Checkpoint:判断“马上开始”存在
	 * @throws UiObjectNotFoundException 
	 */
	public void testWhiteListPromote() throws UiObjectNotFoundException{
		uti.openGLauncher();
		UiObject prompt=uti.byText("马上开始");
		Assert.assertEquals(true, prompt.exists());
		
	}
}

