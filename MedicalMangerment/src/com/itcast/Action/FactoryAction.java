package com.itcast.Action;
//123
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.entity.Admin;
import com.itcast.entity.Cart;
import com.itcast.entity.CartItem;
import com.itcast.entity.Email;
import com.itcast.entity.Factory;
import com.itcast.entity.FactoryEmail;
import com.itcast.entity.FactoryJson;
import com.itcast.entity.FactoryPageCondition;
import com.itcast.entity.Good;
import com.itcast.entity.Indent;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.Orders;
import com.itcast.entity.Repertory;
import com.itcast.entity.RepertoryJson;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;
import com.itcast.service.FactoryService;
import com.itcast.service.RepertoryService;
import com.itcast.service.SupplierService;
import com.itcast.service.TypeService;
import com.itcast.utils.Page;
import com.itcast.utils.Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class FactoryAction extends ActionSupport implements ModelDriven<Factory> {
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	// 模型驱动
	private Factory factory = new Factory();
	// 注入
	private FactoryService factoryService;

	public FactoryService getFactoryService() {
		return factoryService;
	}

	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

	/**
	 * 注入type services
	 * 
	 */
	private TypeService typeService;

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	/**
	 * 注入 supplierService
	 *
	 */
	private SupplierService supplierService;

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	private int page;
	private int limit;

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/*
	 * 'fid' : date.fid, 'num' : value
	 */

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

	// layui分页
	public String factoryall() throws IOException {
		System.out.println("进入分页action");
		System.out.println("page" + page + "limit3" + limit);
		int result = (page - 1) * limit;
		List<Factory> ftory = factoryService.factoryall(result, limit);
		int num = factoryService.count();

		String msg = "";
		FactoryJson factoryjson = new FactoryJson();
		int code = 0;
		factoryjson.setCode(code);
		factoryjson.setMsg(msg);
		factoryjson.setCount(num);
		factoryjson.setData(ftory);

		HttpServletResponse response = ServletActionContext.getResponse();
		String str = JSON.toJSONString(factoryjson);
		response.setContentType("text/html;charset=utf-8");
		System.out.println(str);
		response.getWriter().write(str);

		return NONE;
	}

	/**
	 * 药厂列表--zby
	 * 
	 * @return
	 */

	public String getFactoryList() {
		
		System.out.println("查找所有药厂列表action.....-----------条件查询");
		HttpServletRequest request = ServletActionContext.getRequest();
		FactoryPageCondition factoryPageCondition=new FactoryPageCondition();
		factoryPageCondition.setFname(request.getParameter("fname"));
		factoryPageCondition.setFgongying(request.getParameter("fgongying"));
		factoryPageCondition.setFchufang(request.getParameter("fchufang"));
		Page page = Addpage(request,10,factoryPageCondition);

		List<Factory> factoryList = factoryService.getFactoryList(factoryPageCondition,page);
		List<Type> findAllType = typeService.findAllType();
		List<Supplier> allSuppliers = supplierService.allSuppliers();
		
		
		ActionContext.getContext().getValueStack().set("allSuppliers", allSuppliers);
		ActionContext.getContext().getValueStack().set("findAllType", findAllType);
		ActionContext.getContext().getValueStack().set("factoryList", factoryList);

		return "factoryList";
	}
	/**
	 * ajax 显示小圆点未读/数量
	 * @return
	 * @throws IOException 
	 */
	public void upIsReadNum() throws IOException{
		
		System.out.println("显示小圆点未读/数量action！");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		//未读数量upIsReadNum
		Integer upIsReadNum = factoryService.upIsReadNum();
		response.getWriter().print(upIsReadNum);
		
		
		
	}
	/**
	 * 分页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected Page Addpage(HttpServletRequest request,int pagesize,FactoryPageCondition factoryPageCondition){
		   //获取当前页和当前页数量
		   int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
		   int pageSize = request.getParameter("pageSize") == null ? pagesize : Integer.parseInt(request.getParameter("pageSize"));
		   if (currentPage <= 0) {
            currentPage = 1;
        }
           int currentResult = (currentPage - 1) * pageSize; 
		   Page page=new Page();
		   page.setShowCount(pageSize);
		   page.setCurrentPage(currentPage);
		   page.setCurrentResult(currentResult);
		   page.setTotalResult(factoryService.findTotalCount(factoryPageCondition));
		   
		   request.setAttribute("page", page);
		   request.setAttribute("factoryPageCondition", factoryPageCondition);
		   return page;
	}



	/**
	 * 更新药厂数据
	 * @author zby
	 * @return
	 */
	public String updateFactory() {
		Factory factory=new Factory();
		HttpServletRequest request = ServletActionContext.getRequest();
		factory.setFid(Integer.parseInt(request.getParameter("fid")));
		factory.setFname(request.getParameter("fname"));
		factory.setFprice(Double.parseDouble(request.getParameter("fprice")));
		factory.setFvalDate(request.getParameter("fvalDate"));
		factory.setFproductDate(request.getParameter("fproductDate"));
		factory.setFnum(Integer.parseInt(request.getParameter("fnum")));
		factory.setFgongying(request.getParameter("fgongying"));
		factory.setFchufang(request.getParameter("fchufang"));
		factoryService.updateFactory(factory);
		
		
		return "updateFactory";
		
	}
	
	/**
	 * 弹出提示框
	 * @author zby
	 * @param response
	 * @param msg
	 * @throws IOException
	 */
	public static void writePop(HttpServletResponse response,String msg,String path) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
	    out.println("alert('"+msg+"');");
	    out.println(path);
	    out.println("</script>");
	    out.flush();
		out.close();
		
	}

/**
 * 添加药品
 * @author zby
 * @return
 * @throws IOException 
 */
	public String addFactory() throws IOException {
		Factory factory=new Factory();
		HttpServletRequest request = ServletActionContext.getRequest();
		factory.setFname(request.getParameter("fname"));
		factory.setFprice(Double.parseDouble(request.getParameter("fprice")));
		factory.setFvalDate(request.getParameter("fvalDate"));
		factory.setFproductDate(request.getParameter("fproductDate"));
		factory.setFnum(Integer.parseInt(request.getParameter("fnum")));
		factory.setFgongying(request.getParameter("fgongying"));
		factory.setFchufang(request.getParameter("fchufang"));
		try {
			factoryService.addFactory(factory);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception该商品已存在，请前往修改库存
			HttpServletResponse response = ServletActionContext.getResponse();
			writePop(response,"该商品已存在，请前往修改库存","history.back();");
			
		}
		
		
		
		return "addFactory";
	}
	// 模型驱动
	@Override
	public Factory getModel() {
		// TODO Auto-generated method stub
		return factory;
	}

	public String delect() {
		// HttpServletRequest request=ServletActionContext.getRequest();
		// String str = request.getParameter("dat");
		System.out.println(factory.getFid());

		factoryService.delect(factory);

		return NONE;

	}

	public String shopping() throws IOException {
		/*
		 * HttpServletRequest request=ServletActionContext.getRequest(); String str2 =
		 * request.getParameter("num");
		 */

		/*
		 * HttpServletRequest request=ServletActionContext.getRequest(); int fid =
		 * Integer.parseInt(request.getParameter("fid"));
		 */
		System.out.println(num);
		System.out.println(factory.getFid());
		 System.out.println("执行数量---------------------");
		
		Factory fac=factoryService.select(factory.getFid());
		 //通过这个id来查找数量
		 System.out.println(fac+"------");
		  int number=fac.getFnum();
	
		  System.out.println(number);
		  int total; 
		 total=number-num;
		  System.out.println(total);
	
		  fac.setFnum(total);
		 System.out.println(factory.getFnum()+"zhi");
		 factoryService.updatenum(fac);
		 System.out.println("跟新数量出----------");

			
			
		 
		// 封装

		Factory factory2 = factoryService.shopping(factory.getFid());
		CartItem cartitem = new CartItem();// 购物项
		cartitem.setCount(num);
		cartitem.setFactoryproduct(factory2);
		// 将购物车放入session
		Cart cart = getCart();
		cart.addCart(cartitem);
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
	
		response.getWriter().print(total);
		
		

		return NONE;

	}

//获取购物车 从session中获取
	private Cart getCart() {
		// TODO Auto-generated method stub
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}

		return cart;
	}

	/**
	 * 删除商品按钮
	 * @author zby
	 * @param factoryid
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	public String deleteFactory() throws UnsupportedEncodingException {

		HttpServletRequest request = ServletActionContext.getRequest();
		String factoryid = new String(request.getParameter("factoryid").getBytes("iso-8859-1"), "utf-8");
		factoryService.deleteFactory(Integer.valueOf(factoryid));
		return "deleteFactory";

	}
	/**
	 * 展示首页订单信息
	 * 收到药店提醒
	 * @author zby
	 */
	public String getFactoryIndex(){
		List<Orders> orderList=factoryService.getFactoryIndex_indent();
		List<FactoryEmail> factoryEmailList=factoryService.getFactoryEmail();
		ActionContext.getContext().getValueStack().set("orderList", orderList);
		ActionContext.getContext().getValueStack().set("factoryEmailList", factoryEmailList);
		return "getFactoryIndex";
	}
	/**
	 * 获取邮件列表
	 * 收到药店提醒
	 * @author zby
	 */
	public String getEmailList(){
		System.out.println("显示所有通知信息");
		//查询今天的消息
		List<FactoryEmail> showAllNotification = factoryService.showAllNotification();
		//查询昨天的消息
		List<FactoryEmail> showYesterday = factoryService.showYesterday();
		//查询更久之前的消息
		List<FactoryEmail> showOld = factoryService.showOld();
		
		
		
		//向值栈放对象
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		
		valueStack.set("showAllNotification", showAllNotification);
		valueStack.set("showYesterday", showYesterday);
		valueStack.set("showOld", showOld);
		
		
		
		
		System.out.println("action结束！");
		
		
		return "getEmailList";
	}
	/**
	 * ajax 修改已读/未读消息
	 * @return
	 * @throws IOException 
	 */
	public void updateRead() throws IOException{
		
		System.out.println("修改已读/未读消息action！");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String feid = request.getParameter("feid");
		int parseInt = Integer.parseInt(feid);
		
		//response.getWriter().print(eid);
		
		//System.out.println(eid);
		
		//更新已读/未读
		factoryService.updateRead(parseInt);
		
		Integer upIsReadNum = factoryService.upIsReadNum();
		
		response.getWriter().print(upIsReadNum);
		
		
		
	}
	
	


	// 清空购物车
	public String clearCart() {
		Cart cart = getCart();
		cart.clearCart();
		return "clearCart";
	}

	
	// 删除单项
	public String removeCart() {
		Cart cart = getCart();
		Factory fac= factoryService.shopping(factory.getFid());
		
		int number=fac.getFnum();
		
		int num=Integer.parseInt(request.getParameter("num"));
		System.out.println("删除的数量"+num);
		int total=number+num;
		
		 fac.setFnum(total);
		 factoryService.updatenum(fac);
		
		
		cart.removeCart(factory.getFid());
		return "removeCart";
	}
	
	// 判断数量是否正确
		public String number() throws IOException {
			System.out.println("进入数量判断");
			int str = Integer.parseInt(request.getParameter("count"));
			System.out.println(str);
			System.out.println(factory.getFid());
			System.out.println(factory.getFnum());
			// factoryService
			if (str < factory.getFnum()) {
				response.getWriter().write("ture");
				// return "true";
			} else {
				response.getWriter().write("flase");
				// return "flase";
			}

			return NONE;
		}

		// 提交订单
		public String commit() {
			getCart();
			return "commit";
		}

		/**
		 * 加入到订单列表
		 * 
		 * @return
		 */
		Orders orders = new Orders();

		public Orders getOrders() {
			return orders;
		}

		public void setOrders(Orders orders) {
			this.orders = orders;
		}

		public String addfactory() {

			System.out.println("啦啦啦啦啦");
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式, 编号
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式, 下单时间
			String ordernumber = df.format(new Date());
			String orderDate = date.format(new Date());
			Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
			Admin admin = (Admin) ServletActionContext.getRequest().getSession().getAttribute("adminlogin");
			// System.out.println(orderShop.getTotal()+".."+ordernumber+".."+orderDate+"..."+admin.getName());
			orders.setOrderSum(cart.getTotal());
			orders.setOrderCode(ordernumber);
			orders.setOrderDate(orderDate);
			orders.setOrderName(admin.getName());

			factoryService.addorders(orders);// 保存到订单中

			Collection<CartItem> orderItems = cart.getCartItems();
			// orProductDate

			
			OrderDetail orderDetail = new OrderDetail();
			for (CartItem cartItem : orderItems) {
				orderDetail.setOrdernumber(ordernumber);
				orderDetail.setOrName(cartItem.getFactoryproduct().getFname());
				orderDetail.setOrUnitPrice(cartItem.getFactoryproduct().getFprice());
				orderDetail.setOrValDate(cartItem.getFactoryproduct().getFvalDate());
				orderDetail.setOrProductDate(cartItem.getFactoryproduct().getFproductDate());
				orderDetail.setOrnum(cartItem.getCount());// 数量
				orderDetail.setOrsum(cartItem.getSubtotal());// 总金额
				orderDetail.setOsupplier(cartItem.getFactoryproduct().getFgongying());// 供应商
				orderDetail.setOtype(cartItem.getFactoryproduct().getFchufang());// 类别

				System.out.println(orderDetail);
				factoryService.addOrderDetail(orderDetail);

			
				 System.out.println("执行数量---------------------");
				  int num=cartItem.getFactoryproduct().getFid(); 
				  //factory.setFid(num);
				  System.out.println("id...."+num);
				  //System.out.println(factory.getFid()); 
				
				  Factory fac=factoryService.select(num);
				 //通过这个id来查找数量
				 System.out.println(fac+"------");
				  int number=fac.getFnum();
				  System.out.println(number);
				  int total; 
				  total=number-cartItem.getCount();
				  System.out.println(total);
			
				  fac.setFnum(total);
				 System.out.println(factory.getFnum());
				 factoryService.updatenum(fac);
				 System.out.println("跟新数量出----------");
				 

				// factoryService.alternum();
			}
			ServletActionContext.getRequest().getSession().removeAttribute("cart");

			return "addfactory";
		}

}
