package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.Good;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;

public interface GoodDao {
	/**
	 * 查询显示所有商品
	 */
	public List<Good> findAllGoods();
	
	/**
	 * 增加药品
	 * @param good
	 */
	public void goodsAdd(Good good,Type type,Supplier supplier);
	
	/**
	 * 更新药品信息
	 * @param good
	 */
	public void updateGoods(Integer id,String tid,String sid,Good good);
	
	/**
	 * 删除药品
	 */
	public void deleteGoods(Integer id);
	
	/**
	 * 模糊查找商品
	 * @return
	 */
	public List<Good> findSomeGood(String goodsname);
	/**
	 * 根据id查询商品
	 * @param gid
	 * @return
	 */
	public Good findById(Integer gid);
	
	/**
	 * 分页
	 */
	public List<Good> pagingGoods(Integer pageNum,Integer pagecount);

	//查询总记录数
	public int findCount();

	//分页查询
	public List<Good> findPage(int begin, int pageSize);

	//加入购物车后，库存减少
	public void update(Good good);

	
	//查询总记录数（前台商品查询）
	public int findGoodCount(String gname);

	//分页查询（前台商品查询）
	public List<Good> findGoodPage(int begin, int pageSize, String gname);

	
	public List<Good> findByName(String name);

	 public void udpateGoodsNum(Integer id, Integer count);

	 public void addNewGoods(Good good);

	public void updateGoods(Integer gid, Double gprice);
}
