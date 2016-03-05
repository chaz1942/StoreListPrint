package com.storelistprint;

import java.util.List;

public class PrintRecript {
	List<BasicItemInfo> list;
	int[] listPrivilgeIndex;
	/**
	 * 
	 * @param list				存储购物条目的数组
	 * @param listPrivilgeIndex	优惠商品在数组中的索引
	 * @param pay				总计
	 * @param save				节省的金额
	 * @param privilgeOne			此数组中是否有95折商品
	 * @param privilgeTwo			此数组中是否有买二赠一商品
	 */
	public void startPrint(List<BasicItemInfo> list,int[] listPrivilgeIndex,float pay,float save,boolean privilgeOne,boolean privilgeTwo){
		this.list = list;
		this.listPrivilgeIndex = listPrivilgeIndex;
		PrintHead();
		printDetail();
		if(privilgeTwo)
			printPriviligeDetail();
		printPayInfo(pay,save,privilgeOne || privilgeTwo);
		
	}
	public void PrintHead(){
		System.out.println("***<没钱赚商店>购物清单***");
	}
	public void printDetail(){
		for(int i = 0; i < list.size(); ++i){
			BasicItemInfo item = list.get(i);
			String print;
			if(item.totalPrice != item.finalPrice){
				print = "名称：" + item.goodsName + "，数量：" + item.count + item.unitOfQuantity + "，单价：" + item.price
						+ "(元)，小计：" + (float)(Math.round(item.finalPrice*100))/100 + "(元)，节省"
						+ (float)(Math.round((item.totalPrice-item.finalPrice)*100))/100 + "(元)";
			}else{
				print = "名称：" + item.goodsName + "，数量：" + item.count + item.unitOfQuantity + "，单价：" + item.price
						+ "(元)，小计：" + (float)(Math.round(item.finalPrice*100))/100 + "(元)";
			}
			System.out.println(print);
		}
	}
	public void printPriviligeDetail(){
		System.out.println("----------------------");
		System.out.println("买二赠一商品：");
		
		for(int i = 0; i < Config.price.length; ++i){
			if(listPrivilgeIndex[i] == 0)
				break;
			BasicItemInfo item = list.get(listPrivilgeIndex[i]-1);
			System.out.println("名称：" + item.goodsName + item.unitOfQuantity + "，数量：" + (item.count/3) + item.unitOfQuantity);
			
		}
	}
	/**
	 * 
	 * @param pay		总计金额
	 * @param save		节省金额
	 * @param privilge	是否有优惠金额
	 */
	public void printPayInfo(float pay, float save,boolean privilge){
		System.out.println("----------------------");
		System.out.println("总计：" + (float)(Math.round(pay*100))/100 + "(元)");
		if(privilge)
			System.out.println("节省：" + (float)(Math.round(save*100))/100 + "(元)");
		System.out.println("**********************");
	}
}
