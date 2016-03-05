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
### GOODS INFO
	//商品95折商品信息
	public static String[] discount={"ITEM000001","ITEM000003","ITEM000005"};
	//买2赠一商品
	public static String[] priviligeRule = {"ITEM000001","ITEM000003","ITEM000004","ITEM000006"};
	//所有商品信息用％分割 分别是货号、售价、商品名称、数量单位
	public static String[] price = {"ITEM000001%12%苹果%个",
			"ITEM000002%13%杯子%个","ITEM000003%3%口香糖%盒",
			"ITEM000004%45%手套%个","ITEM000005%10%笔记本%本",
			"ITEM000006%129%耳机%个","ITEM000007%54%牛奶%包",
			"ITEM000008%27%卷尺%把","ITEM000009%34%毛巾%条",
			"ITEM000010%6.8%面包%包","ITEM000011%7%香蕉%把"};
###result
####input1
	[ 
	'ITEM000009-2',
	   'ITEM000004',
	   'ITEM000004',
	   'ITEM000004',
	   'ITEM000011',
	   'ITEM000007-3',
	   'ITEM000002',
	   'ITEM000010',
	   'ITEM000006-3',
	 ]
####output1
	***<没钱赚商店>购物清单***
	名称：毛巾，数量：2条，单价：34.0(元)，小计：68.0(元)
	名称：手套，数量：3个，单价：45.0(元)，小计：90.0(元)，节省45.0(元)
	名称：香蕉，数量：1把，单价：7.0(元)，小计：7.0(元)
	名称：牛奶，数量：3包，单价：54.0(元)，小计：162.0(元)
	名称：杯子，数量：1个，单价：13.0(元)，小计：13.0(元)
	名称：面包，数量：1包，单价：6.8(元)，小计：6.8(元)
	名称：耳机，数量：3个，单价：129.0(元)，小计：258.0(元)，节省129.0(元)
	----------------------
	买二赠一商品：
	名称：手套个，数量：1个
	名称：耳机个，数量：1个
	----------------------
	总计：604.8(元)
	节省：174.0(元)
**********************
####input2
	[ 'ITEM000010',
	  'ITEM000002',
	  'ITEM000002',
	  'ITEM000007',
	  'ITEM000010',
	  'ITEM000007-2',
	  'ITEM000004',
	  'ITEM000010',
	  'ITEM000009'
	 ]
####output2
	***<没钱赚商店>购物清单***
	名称：杯子，数量：2个，单价：13.0(元)，小计：26.0(元)
	名称：牛奶，数量：3包，单价：54.0(元)，小计：162.0(元)
	名称：手套，数量：1个，单价：45.0(元)，小计：45.0(元)
	名称：面包，数量：3包，单价：6.8(元)，小计：20.4(元)
	名称：毛巾，数量：1条，单价：34.0(元)，小计：34.0(元)
	----------------------
	总计：287.4(元)
	**********************
####input3
	[ 'ITEM000001-2',
	  'ITEM000003',
	  'ITEM000004',
	  'ITEM000004',
	  'ITEM000010',
	  'ITEM000005-6',
	  'ITEM000002',
	  'ITEM000010',
	  'ITEM000009'
	]
####output3
	***<没钱赚商店>购物清单***
	名称：苹果，数量：2个，单价：12.0(元)，小计：22.8(元)，节省1.2(元)
	名称：口香糖，数量：1盒，单价：3.0(元)，小计：2.85(元)，节省0.15(元)
	名称：手套，数量：2个，单价：45.0(元)，小计：90.0(元)
	名称：笔记本，数量：6本，单价：10.0(元)，小计：57.0(元)，节省3.0(元)
	名称：杯子，数量：1个，单价：13.0(元)，小计：13.0(元)
	名称：面包，数量：2包，单价：6.8(元)，小计：13.6(元)
	名称：毛巾，数量：1条，单价：34.0(元)，小计：34.0(元)
	----------------------
	总计：233.25(元)
	节省：4.35(元)
	**********************
####input4
	[ 
	'ITEM000001-3',
	'ITEM000002',
	'ITEM000004',
	'ITEM000003-5',
	'ITEM000010',
	'ITEM000007-2',
	'ITEM000002',
	'ITEM000010',
	'ITEM000009'
	]
####output4
	***<没钱赚商店>购物清单***
	名称：苹果，数量：3个，单价：12.0(元)，小计：24.0(元)，节省12.0(元)
	名称：手套，数量：1个，单价：45.0(元)，小计：45.0(元)
	名称：口香糖，数量：5盒，单价：3.0(元)，小计：12.0(元)，节省3.0(元)
	名称：牛奶，数量：2包，单价：54.0(元)，小计：108.0(元)
	名称：杯子，数量：2个，单价：13.0(元)，小计：26.0(元)
	名称：面包，数量：2包，单价：6.8(元)，小计：13.6(元)
	名称：毛巾，数量：1条，单价：34.0(元)，小计：34.0(元)
	----------------------
	买二赠一商品：
	名称：苹果个，数量：1个
	名称：口香糖盒，数量：1盒
	----------------------
	总计：262.6(元)
	节省：15.0(元)
	**********************

