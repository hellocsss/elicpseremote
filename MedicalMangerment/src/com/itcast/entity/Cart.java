package com.itcast.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

//购物车
public class Cart {
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();// 购物项集合
	//Cart 中有一个属性叫cartItems  单列集合
	public Collection<CartItem> getCartItems(){
		return  map.values();//显示map 的value  不用显示key
	}
	private double total;

	// 购物车功能 将购物项添加到 购物车

	public double getTotal() {
		return total;
	}
	
	
	
	
	
	public void addCart(CartItem cartitem) {
		//判断购物车是否存在购物项
		//
		/* 如果存在
		 * 数量相加
		 * 总计=总计+购物项小计
		 * 若果不存在：
		 * 向map中添加购物项
		 * 总计=总计+购物项小计
		 * */
		//看是否包含该id
		Integer fid = cartitem.getFactoryproduct().getFid();
		if(map.containsKey(fid)) {//包含表示存在
			CartItem cartitem2=map.get(fid);//获得购物车中原来的购物项
			cartitem2.setCount(cartitem2.getCount()+cartitem.getCount());
		}else {
			map.put(fid, cartitem);
		}
		//总计
		total+=cartitem.getSubtotal();
	}
	// 从购物车移除购物项
	public void removeCart(Integer fid) {
       //将某个购物项移除
		CartItem cartitem= map.remove(fid);//移除后可以返回商品
		//总计=总计-移除购物项的小计
		total-=cartitem.getSubtotal();
	}

	// 清空购物车

	public void clearCart() {
       //将总计设置为0；
		total=0;
		//清空购物项
		map.clear();
	}

}
