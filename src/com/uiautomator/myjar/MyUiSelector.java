package com.uiautomator.myjar;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
/**
 * @author wubin
 * @date 创建时间：2016年4月07日 下午5:16:13
 * @version 1.0
 */
public class MyUiSelector extends UiSelector {
	public UiObject byText(String text) {

		return new UiObject(new UiSelector().textMatches(text));
	}

	public UiObject byDescription(String text) {
		return new UiObject(new UiSelector().descriptionMatches(text));
	}

	public UiObject byClassName(String text) {
		return new UiObject(new UiSelector().classNameMatches(text));
	}

	public UiObject byResourceId(String text) {
		return new UiObject(new UiSelector().resourceIdMatches(text));
	}

	public UiObject byPackageName(String text) {
		return new UiObject(new UiSelector().packageNameMatches(text));
	}

	public UiObject byIndex(int index) {
		return new UiObject(new UiSelector().index(index));
	}

	public UiObject byInstance(int instance) {
		return new UiObject(new UiSelector().instance(instance));
	}
	public UiObject byTextContains(String text) {
		return new UiObject(new UiSelector().textContains(text));
	}
}
