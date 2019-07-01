package com.itcast.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Good;
import com.itcast.entity.Shop;
import com.itcast.entity.ShopItem;
import com.itcast.service.GoodService;
import com.itcast.service.ShopService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ShopAction extends ActionSupport implements ModelDriven<ShopItem>{

	private ShopItem shopItem=new ShopItem();
	
	@Override
	public ShopItem getModel() {
		// TODO Auto-generated method stub
		return shopItem;
	}
	
	
	  //注入Service 
	  private ShopService shopService;
	  
	  public void setShopService(ShopService shopService) { 
	  	this.shopService =shopService;
}
	 
	
	//注入GoodService
	private GoodService goodService;
	
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	private Integer gid;
	
	//private Integer count;
	
	//private Double price;

	
	
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	
	/**
	 * 购物车保存到session中
	 * @return
	 */
	private Shop getShop() {
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop");
		if (shop == null) {
			shop = new Shop();
			ServletActionContext.getRequest().getSession().setAttribute("shop", shop);
		}
		return shop;
	}
	
	
	

	/**
	 * 加入结算
	 * @return
	 */
	public String addShop() {
		System.out.println(gid+".."+shopItem.getCount());
		//shopItem.setCount(count);
		Good good=goodService.findById(gid);
		//设置商品
		shopItem.setGood(good);
		System.out.println(shopItem.getGood());
		//获得购物车
		Shop shop=getShop();
		shop.addShop(shopItem);
		
		good.setStock(good.getStock()-shopItem.getCount());
		
		goodService.update(good);

		return "addSuccess"; 
	}

	/**
	 * 删除单个药品
	 * @return
	 */
	public String removeShopItem() {
		Shop shop=getShop();
		//删除单个药品，并且返回一个该药品在购物车中的数量
		int shopItemCount = shop.removeShopItem(gid);
		Good good = goodService.findById(gid);
		//把药品的库存数量加回去
		good.setStock(good.getStock()+shopItemCount);
		//修改药品
		goodService.update(good);
		return "removeSuccess";
	}
	
	/**
	 * 清空所有药品
	 * @return
	 */
	public String clearShop() {
		Shop shop=getShop();
		//清空购物车的同时，拿到请空前的map集合
		Map<Integer, ShopItem> mapShop =new LinkedHashMap<Integer, ShopItem>();
		mapShop = shop.clearShop();
		System.out.println(".x.x."+mapShop);
		//遍历map集合
		for (Integer gid : mapShop.keySet()) {
			//通过集合的键去找到对应的药品
			Good good = goodService.findById(gid);
			//把购物项中的数量获取出来 加上 药品之前的库存
			good.setStock(good.getStock()+mapShop.get(gid).getCount());
			//修改库存
			goodService.update(good);
		}
		return "clearSuccess";
	}
	

	public String commit() {
		getShop();
		return "commitSuccess";
	}
	
}
