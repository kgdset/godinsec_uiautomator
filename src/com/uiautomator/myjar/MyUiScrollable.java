package com.uiautomator.myjar;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

/**
 * 封装UiScrollable，可滚动控件中查找元素
 * 
 * @author kgdset
 * 
 */
public class MyUiScrollable extends UiScrollable{

	public MyUiScrollable(UiSelector container) {
		super(container);
		// TODO Auto-generated constructor stub
	}
	public MyUiScrollable() {
		super(null);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 通过ResourceID查询元素
	 * 
	 * @param text
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */
	public UiObject byResourceId(String text) throws UiObjectNotFoundException {

		UiObject obj = new MyUiSelector().byResourceId(text);
		return GetUiObject(obj);

	}

	/**
	 * 通过Description查询元素
	 * 
	 * @param text
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byDescription(String text) throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byDescription(text);
		return GetUiObject(obj);

	}

	/**
	 * 通过text查询元素
	 * 
	 * @param text
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byText(String text) throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byText(text);
		return GetUiObject(obj);
	}

	/**
	 * 通过text包含查询元素
	 * 
	 * @param text
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byTextContains(String text)
			throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byTextContains(text);
		return GetUiObject(obj);
	}

	/**
	 * 通过CalssName查询元素
	 * 
	 * @param text
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byClassName(String text) throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byClassName(text);
		return GetUiObject(obj);
	}

	/**
	 * 通过Index查询元素
	 * 
	 * @param index
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byIndex(int index) throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byIndex(index);
		return GetUiObject(obj);
	}

	/**
	 * 通过PackName查询元素
	 * 
	 * @param text
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byPackName(String text) throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byPackageName(text);
		return GetUiObject(obj);
	}

	/**
	 * 通过Instance查询元素
	 * 
	 * @param instance
	 * @return 返回查找的元素
	 * @throws UiObjectNotFoundException
	 */

	public UiObject byInstance(int instance) throws UiObjectNotFoundException {
		UiObject obj = new MyUiSelector().byInstance(instance);
		return GetUiObject(obj);
	}

	private UiObject GetUiObject(UiObject obj) throws UiObjectNotFoundException {
		// TODO Auto-generated method stub
		UiScrollable collectionObject = new UiScrollable(
				new UiSelector().scrollable(false));
		collectionObject.setAsHorizontalList();
		collectionObject.scrollIntoView(obj);
		if (obj.exists()) {
			return obj;
		} else {
			collectionObject.setAsHorizontalList();
			collectionObject.scrollIntoView(obj);

			return obj;

		}

	}
}
