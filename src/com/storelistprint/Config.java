package com.storelistprint;

public class Config {
	//商品95折商品信息
	public static String[] discount = {"ITEM000001","ITEM000003","ITEM000005"};
	public static String[] priviligeRule = {"ITEM000001","ITEM000003","ITEM000004","ITEM000006"};
	//所有商品信息用％分割 分别是货号、售价、商品名称
	public static String[] price = {"ITEM000001%12%苹果%个",
			"ITEM000002%13%杯子%个","ITEM000003%3%口香糖%盒",
			"ITEM000004%45%手套%个","ITEM000005%10%笔记本%本",
			"ITEM000006%129%耳机%个","ITEM000007%54%牛奶%包",
			"ITEM000008%27%卷尺%把","ITEM000009%34%毛巾%条",
			"ITEM000010%6.8%面包%包","ITEM000011%7%香蕉%把"};
}
