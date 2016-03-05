package com.storelistprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * when input is over return array with BasicItemInfo structure
 * 将输入的json数据处理，为结算数据做准备
 * @author scofieldchang
 *
 */
public class GetInputInFormation {
	
	
	private List<BasicItemInfo> list = new ArrayList<BasicItemInfo>();
	private HashMap<String,Float> map = new HashMap<String,Float>();
	private HashMap<String,String> mapName = new HashMap<String,String>();
	private void getInputInformation(String inputString){
		makeGoodsInfoTable();
		JSONTokener jsonParser = new JSONTokener(inputString);
		try {
			JSONArray jary = (JSONArray)jsonParser.nextValue();
			getInputInformation(jary);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getInputInformation(JSONArray jsonarray) throws NumberFormatException, Exception{
		for(int i = 0; i < jsonarray.length(); i++){
			try {
				String content = (String)jsonarray.get(i);
				if(content != null){
					String[] strs = content.split("-");
					if(strs.length > 1){
						inputItem(strs[0],Integer.parseInt(strs[1]));
					}else{
						inputItem(strs[0],1);
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public List<BasicItemInfo> getStructureArray(String str){
		getInputInformation(str);
		return list;
	}
	public List<BasicItemInfo> getStructureArray(JSONArray jsonarray){
		try {
			getInputInformation(jsonarray);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int isGoodsExit(String number){
		for(int i = 0; i < list.size(); ++i){
			BasicItemInfo item = list.get(i);
			if(item.number.equals(number))
				return i;
		}
		return -1;
	}
	/**
	 *
	 * @param number 商品编号
	 * @param count	 商品数量
	 * 如果存在相同商品将该商品数量修改后再次存入数组，如果不存在则添加相应的商品类型
	 * @throws Exception 抛出输入信息异常
	 */
	public void inputItem(String number,int count) throws Exception{
		BasicItemInfo item;
		int result = isGoodsExit(number);
		if(result == -1){
			String goodsName = mapName.get(number);
			//用来过滤不合法的输入，商品编号如果没有找到则不会录入到购物清单中,并且抛出“info input error”异常，程序终止返回
			if (goodsName != null){
				item = new BasicItemInfo();
				item.number = number;
				item.count = count;
				item.goodsName = goodsName;
				item.price = map.get(number);
				if(count > 2){
					item.privilgeCode = 2;
				}else{
					item.privilgeCode = getPrivilgeCode(number);
				}
				list.add(item);
			}else{
				throw new Exception("info input error");
			}
		}else{
			item = list.get(result);
			list.remove(result);
			item.count += count;
			if(item.count > 2){
				item.privilgeCode = 2;
			}
			list.add(item);
		}
	}
	public int getPrivilgeCode(String number){
		for(int i = 0; i < Config.discount.length; ++i){
			if(number.equals(Config.discount[i])){
				return 1;
			}
		}
		return 0;
	}
	/**
	 * 获取商品信息表，这个表包含了商品的价格、名称
	 */
	public void makeGoodsInfoTable(){
		for(int i = 0 ; i < Config.price.length; ++i){
			String[] strs = Config.price[i].split("%");
			if(strs.length == 3){
				map.put(strs[0], Float.parseFloat(strs[1]));
				mapName.put(strs[0],strs[2]);
			}
		}
	}
}
