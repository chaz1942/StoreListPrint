package com.storelistprint;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
/**
 * main 用于测试输出，通过调用PrintManager来打印小票
 * @author scofieldchang
 *
 */
public class main {
	public static String testData = "[ \"ITEM000009-2\",\"ITEM000004\",\"ITEM000004\","
			+ "\"ITEM000004\",\"ITEM000011\",\"ITEM000007-3\",\"ITEM000002\","
			+ "\"ITEM000010\",\"ITEM000006-3\"]";
	public static String testData1 = "[ \"ITEM000010\",\"ITEM000002\",\"ITEM000002\","
			+ "\"ITEM000007\",\"ITEM000010\",\"ITEM000007-2\",\"ITEM000004\","
			+ "\"ITEM000010\",\"ITEM000009\"]";
	public static String testData2 = "[ \"ITEM000001-2\",\"ITEM000003\",\"ITEM000004\","
			+ "\"ITEM000004\",\"ITEM000010\",\"ITEM000005-6\",\"ITEM000002\","
			+ "\"ITEM000010\",\"ITEM000009\"]";
	public static String testData3 = "[ \"ITEM000001-3\",\"ITEM000002\",\"ITEM000004\","
			+ "\"ITEM000003-5\",\"ITEM000010\",\"ITEM000007-2\",\"ITEM000002\","
			+ "\"ITEM000010\",\"ITEM000009\"]";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintManager manager = new PrintManager();
		manager.printRecript(testData);
		manager.printRecript(testData1);
		manager.printRecript(testData2);
		manager.printRecript(testData3);
	}
	

}
