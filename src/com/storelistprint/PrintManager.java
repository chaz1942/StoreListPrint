package com.storelistprint;

import java.util.List;

import org.json.JSONArray;

public class PrintManager {
	public void printRecript(String jsonString){
		GetInputInFormation getInput = new GetInputInFormation();
		accountPayInfo(getInput.getStructureArray(jsonString));
		
	}
	public void printRecript(JSONArray jsonArray){
		GetInputInFormation getInput = new GetInputInFormation();
		accountPayInfo(getInput.getStructureArray(jsonArray));
	}
	private void accountPayInfo(List<BasicItemInfo> list){
		AccountList account = new AccountList();
		account.startCompute(list);
	}
}
