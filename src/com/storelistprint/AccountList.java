package com.storelistprint;

import java.util.List;

public class AccountList {
	
	private int[] listPrivilgeTwoIndex = new int[Config.price.length];
	private int twoIndex = 0;
	private boolean privilgeOne = false;
	private boolean privilgeTwo = false;
	/**
	 * 
	 * @param count 商品数量
	 * @param price 商品手机
	 * @return		此款商品优惠前的价格
	 */
	private float getToalPrice(int count, float price){
		return count*price;
	}
	/**
	 * 
	 * @param count 		商品数量
	 * @param price			商品售价
	 * @param privilgeCode	商品优惠码
	 * @return				此款商品优惠后的总额
	 */
	private float getFinalPrice(int count,float price,int privilgeCode){
		if(privilgeCode == 1)
			return (float) (0.95*count*price);
		else{
			int privilgeNumber = count/3;
			return price*(count - privilgeNumber);
		}
	}
	/**
	 * 
	 * @param list 存储购物条目的数组
	 * @return 实际付款数
	 */
	public float startCompute(List<BasicItemInfo> list){
		float payNumber = 0;
		float save = 0;
		for(int i = 0; i < list.size(); ++i){
			BasicItemInfo item = list.get(i);
			item.totalPrice = getToalPrice(item.count, item.price);
			item.finalPrice = getFinalPrice(item.count, item.price, item.privilgeCode);
			if(item.privilgeCode != 0){
				markPrivilgeState(i, item.privilgeCode);
			}
			payNumber += item.finalPrice;
			save += (item.totalPrice - item.finalPrice);
		}
		PrintRecript r = new PrintRecript();
		r.startPrint(list,listPrivilgeTwoIndex,payNumber,save,privilgeOne,privilgeTwo);
		return payNumber;
	}
	/**
	 * 
	 * @param number		优惠商品在数组中的索引值
	 * @param privilgeCode	优惠商品的优惠码
	 */
	private void markPrivilgeState(int number, int privilgeCode) {
		// TODO Auto-generated method stub
		
		privilgeOne = true;
		number++;
		if(privilgeCode == 2){
			listPrivilgeTwoIndex[twoIndex++] = number;
			privilgeTwo = true;
		}
	}
}
