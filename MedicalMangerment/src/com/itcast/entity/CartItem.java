package com.itcast.entity;
//购物项对象
public class CartItem {
     private Factory factoryproduct;//购物车商品信息
     private int count;//数量
     private double subtotal;   //商品小计


     
     
	public Factory getFactoryproduct() {
		return factoryproduct;
	}
	public void setFactoryproduct(Factory factoryproduct) {
		this.factoryproduct = factoryproduct;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return factoryproduct.getFprice()*count;//计算小计
	}
	/*
	 * public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
	 */
     
     
}
