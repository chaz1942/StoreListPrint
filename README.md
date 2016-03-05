#StoreListPrint

###ThoughtWorks' test issue,if you want know more about the issue please click link.
https://jinshuju.net/f/n0ddSe
##Issue requirement description:
####In supermakrt they use cash register system to settle accounts. The cash register will charge and print receipt, according to the customer's shopping cart and the privilge rule.
####Now we know Information is: goods name, unit of quantity, unit price, category. We also could set rule so that can support different privilges. We need a module print receipt, the cash register will input a JSON data, the module shoule output settle accounts details information from consle.
    input example:
    [  
    'ITEM000001',  
    'ITEM000001',  
    'ITEM000001',  
    'ITEM000001',  
    'ITEM000001',  
    'ITEM000003-2',  
    'ITEM000005',  
    'ITEM000005',  
    'ITEM000005'  
    ]  
for 'ITEM000003-2', before '-' means goods'ID, after '-' means goods'count.
####The markte has some privilge is open,the rule:
	1.privilger I: 95%,when settle account customer shoud pay = 95% * unit price * count
	2.privilger II: when customer buy Two cup, it can get another for free.(cup is for example)

####All goods has mark which privilge the can get. if some goods can get both, privilge II has more higher priority level.

    output example:

	if customer' shopping cart have privilge II's goods.

	<没钱赚商店>购物清单
	名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)
	名称：羽毛球，数量：5个，单价：1.00(元)，小计：4.00(元)
	名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)
	------------------------
	买二赠一商品：
	名称：可口可乐，数量：1瓶
	名称：羽毛球，数量：1个
	------------------------
	总计：21.00(元)
	节省：4.00(元)
	**********************

	if customer' shopping cart don't have privilge goods.
	<没钱赚商店>购物清单
	名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)
	名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)
	名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)
	------------------------
	总计：25.00(元)
	**********************

	if customer' shopping cart have privilge I's goods.
	<没钱赚商店>购物清单
	名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)
	名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)
	名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)，节省0.55(元)
	------------------------
	总计：24.45(元)
	节省：0.55(元)
	**********************

	if customer' shopping cart have privilge I's and privilge II's goods.
	<没钱赚商店>购物清单
	名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)
	名称：羽毛球，数量：6个，单价：1.00(元)，小计：4.00(元)
	名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)，节省0.55(元)
	------------------------
	买二赠一商品：
	名称：可口可乐，数量：1瓶
	名称：羽毛球，数量：2个
	------------------------
	总计：20.45(元)
	节省：5.55(元)
	**********************

