package com.itcast.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Shop implements Serializable {

	private Map<Integer, ShopItem> map =new LinkedHashMap<Integer, ShopItem>();

	private Double total=0.0; //总价
	
	// Shop对象中有一个叫shopItems属性.
	public Collection<ShopItem> getShopItems(){
		return map.values();	
	}
	

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	//药品加入购物车
	public void addShop(ShopItem shopItem) {
		Integer gid = shopItem.getGood().getGid();		 
		//判断购物车是否存在购物项
		if(map.containsKey(gid)) {
			//存在
			ShopItem shopItemOld = map.get(gid);
			//购买数量设置为 (老购物项的总数=老购物项的总数+新购物项的数量)
			shopItemOld.setCount(shopItemOld.getCount()+shopItem.getCount());
			
		}else {
			/*
			 * System.out.println("map111"); System.out.println(map);
			 * System.out.println(shopItem);
			 */
			map.put(gid, shopItem);
			System.out.println(map);
			System.out.println("map222");
		}
		//Double total = shop.getTotal();
		total +=shopItem.getSubtotal();
		System.out.println("能到吗！！！！！？？");
	}
	
	//移除购物车里的药品
	public int removeShopItem(Integer gid) {
		ShopItem shopItem = map.remove(gid);
		total-=shopItem.getSubtotal();
		return shopItem.getCount();
	}
	
	//清空购物车
	public Map<Integer, ShopItem> clearShop() {
		//先将map集合存在集合m中
		System.out.println(map);
		Map<Integer, ShopItem> m =new LinkedHashMap<Integer, ShopItem>();
		m.putAll(map);
		System.out.println("xx"+m);
		map.clear();
		total=0.0;
		return m;
	}
}
