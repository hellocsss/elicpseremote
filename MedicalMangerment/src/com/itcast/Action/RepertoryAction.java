package com.itcast.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.entity.Good;
import com.itcast.entity.OrderDetail;
import com.itcast.entity.PageBean;
import com.itcast.entity.Repertory;
import com.itcast.entity.Supplier;
import com.itcast.entity.Type;
import com.itcast.service.GoodService;
import com.itcast.service.RepertoryService;
import com.itcast.utils.Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RepertoryAction extends ActionSupport implements ModelDriven<Repertory> {
	 private HttpServletRequest request = ServletActionContext.getRequest();
	// 创建模型封装的对象
	private Repertory repertory = new Repertory();
	//属性封装进行分页
    private Integer currentPage;
    //private Integer currentPage=1;页面不写就这里写
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	@Override
	public Repertory getModel() {
		// TODO Auto-generated method stub
		return repertory;
	}

	public Repertory getRepertory() {
		return repertory;
	}

	public void setRepertory(Repertory repertory) {
		this.repertory = repertory;
	}

	/*
	 * public static String getOrderdetial() { return OrderDetial; }
	 */

	private static final String OrderDetial = null;
	// 这里在action注入 service
	private RepertoryService repertoryService;

	public RepertoryService getRepertoryService() {
		return repertoryService;
	}

	public void setRepertoryService(RepertoryService repertoryService) {
		this.repertoryService = repertoryService;
	}

	
	private String count;
	
		
	public void setCount(String count) {
		this.count = count;
	}

	
	private GoodService goodService;

	 public GoodService getGoodService() {
	  return goodService;
	 }

	 public void setGoodService(GoodService goodService) {
	  this.goodService = goodService;
	 }
	
	
	// 查询仓库的所有
	public String repertoryall2() {

		System.out.println("findrepertoryall_Action进....");
		
		//查询所有仓库订单列表
		List<Repertory> repertoryall = repertoryService.repertoryall2();
		//查询对应商品的上架数量
	
		
		String today = Utils.getToday();
		
		for (Repertory repertory : repertoryall) {
		
			Date d1 = null;
	        Date d2 = null;
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        
			try {
				d1 = format.parse(today);
	            d2 = format.parse(repertory.getRdate());
	            
				//获取现在的时间距离生产日期的天数
	            long day =(d1.getTime()-d2.getTime())/(24*60*60*1000);
	            //保质期 - 相差的日期天数 = 距离过期的天数 
	            long overDate = (long)repertory.getRbdate() - day;
	             
	            //两个日期之间相差的天数，转为字符串
	            String daynum = String.valueOf(overDate);
	            
				System.out.println("相差的天数："+ daynum);
				if(daynum != null) {
					if(overDate>0 && overDate<=30) {
						repertory.setRtext("只剩："+daynum+"天！");
					}else if(overDate>30){
						repertory.setRtext("距离过期："+daynum+"天");
					}else{
						repertory.setRtext("已过期！");
					}
				}				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		
		ActionContext.getContext().getValueStack().set("repertoryall", repertoryall);
		
		

		return "repertoryall2";
	}
	
	
	

//  查询 入库所有信息   和good 的级联             
	public String findrepertoryall() {
		System.out.println("findrepertoryall_Action进....");
		List<Good> findrepertoryall = repertoryService.findrepertoryall();
		System.out.println("findrepertoryall_Action出....");

		ActionContext.getContext().getValueStack().set("findrepertoryall", findrepertoryall);

		for (Good good : findrepertoryall) {
			System.out.println("shang");
			//System.out.println("库存名：" + good.getGname() + good.getRepertory().getRname());

		}

		return "repertoryall";

	}

	// 查询是否存在 订单编号
	public String selectorder() throws IOException {
		System.out.println("进action.............");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String ordernumberr = request.getParameter("ordernumber") == null ? "" : request.getParameter("ordernumber");
		System.out.println("前台传过来的值" + ordernumberr);
		//OrderDetial 需要返回list 因为  你里面 主键 不是订单标号不能判断唯一

		if (!ordernumberr.equals("")) {
			System.out.println("进入循环");
			
			List<OrderDetail> Orderdetial = (List<OrderDetail>) repertoryService.selectorder2(ordernumberr);

			if (Orderdetial.size() > 0) {
				ActionContext.getContext().getValueStack().set("Orderdetial", Orderdetial);
				System.out.println("值栈出......");
			for (OrderDetail orderDetial2 : Orderdetial) {
				String onumber = orderDetial2.getOrdernumber();//订但编号
				double oPrice = orderDetial2.getOrUnitPrice();//价格
				String oName = orderDetial2.getOrName();//产品名字
				String parse = orderDetial2.getOrValDate();//保质期
				
				int parseInt = Integer.parseInt(parse);
				String orPDate = orderDetial2.getOrProductDate();//生厂日期
				Integer onum = orderDetial2.getOrnum();//数量
				//double osum = orderDetial2.getOrsum();//数量总价
				String sname = orderDetial2.getOsupplier();//厂家
				String tname = orderDetial2.getOtype();//类别
				/* private Integer rid; //入库编号
			     private String rnumber;//入库订单编号
			     private String rproduct;//入库产品
			     private String rdate; //入库时间
			     private String rtotal; //入库总数 
			    private  String  runit;//单价
			    private String rtype;//类型
			    private String rbdate;//保质期
			    private  String rbrithdate;  //生产日期
			    private String rput;//供应商*/
				//这里是将查到的数据插入repertory
				
				Date date = new Date();
				System.out.println(date);
				SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 多态
				// 2017-04-19 星期三 下午 20:17:38

				String format = bf.format(date);// 格式化 bf.format(date);
				System.out.println(format);
				// 往repertory添加时间
				repertory.setRnumber(onumber);//订单编号
				repertory.setRproduct(oName);//入库产品
				repertory.setRdate(format);//入库时间
				repertory.setRtotal(onum);//
				repertory.setRunit(oPrice);
				repertory.setRput(sname);
				repertory.setRbrithdate(orPDate);//生厂日期
				repertory.setRtype(tname);
				repertory.setRbdate(parseInt);//保质期
				
				Date d1 = null;
		        Date d2 = null;
		        String today = Utils.getToday();
		        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd");
		        
				try {
					d1 = timeformat.parse(today);
		            d2 = timeformat.parse(orderDetial2.getOrProductDate());
		            
					//获取现在的时间距离生产日期的天数
		            long day =(d1.getTime()-d2.getTime())/(24*60*60*1000);
		            //保质期 - 相差的日期天数 = 距离过期的天数 
		            String dataString = orderDetial2.getOrValDate();
		            int parseInt2 = Integer.parseInt(dataString);
		            long overDate = parseInt2 - day;
		             
		            //两个日期之间相差的天数，转为字符串
		            String daynum = String.valueOf(overDate);
		            
					System.out.println("相差的天数："+ daynum);
					if(daynum != null) {
						if(overDate>0 && overDate<=30) {
							repertory.setRtext("只剩："+daynum+"天！");
						}else if(overDate>30){
							repertory.setRtext("距离过期："+daynum+"天");
						}else{
							repertory.setRtext("已过期！");
						}
					}				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				
				
				System.out.println(repertory);
				
				repertoryService.insertrepertory(repertory);
			}
			}
			else {
				 response = ServletActionContext.getResponse();
					FactoryAction.writePop(response,"订单号输入错误或不能为空，请输入正确的订单编号","history.back();");
					return "selectorderfase";
			}
			
		} else {
			
			
			response = ServletActionContext.getResponse();
			FactoryAction.writePop(response,"订单号输入错误或不能为空，请输入正确的订单编号","history.back();");
			return "selectorderfase";
			
			
		}
		
		return "insertrepertory";

	}

	

	// 根据时间模糊查询
	// 根据时间模糊查询
		public String mohuselect() {
			System.out.println("进入action");
			/* HttpServletRequest request = ServletActionContext.getRequest(); */
			String begintime = request.getParameter("begintime") == null ? "" : request.getParameter("begintime");
			String endtime = request.getParameter("endtime") == null ? "" : request.getParameter("endtime");

			String begintime2 = begintime.replaceAll("T"," ");//将时间 中产生的T给替换成 空格
			String endtime2 = endtime.replaceAll("T"," ");//将时间 中产生的T给替换成 空格
			
			System.out.println(begintime2);
			System.out.println(endtime2);

			List<Repertory> mohuselect = repertoryService.mohuselectService(begintime2, endtime2);

			ActionContext.getContext().getValueStack().set("mohuselect", mohuselect);
			ActionContext.getContext().getValueStack().set("begintime2", begintime2);
			ActionContext.getContext().getValueStack().set("endtime2", endtime2);

			System.out.println("Action出");

			return "mohuselect";
		}
	
	
	
		/**
		 * 上架商品ajax
		 * @return
		 */
	   
		public String onshowGoods() {
			
			System.out.println("上架商品ajax action..................。。。。");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			
			//上架数量
			String count1 = request.getParameter("count");
			Integer count = Integer.parseInt(count1);
			
			//库存产品id
			String ridd = request.getParameter("rid");
			Integer rid = Integer.parseInt(ridd);
			
			String rproduct = request.getParameter("rproduct");
			
			System.out.println(count1 + rid + rproduct);
			
			//查找货架上是否存在该商品
			List<Good> findByName = goodService.findByName(rproduct);
			
			
			
			//如果货架上存在改药品
			if(findByName.size()>0) {
				for (Good good : findByName) {
					//修改上架商品数量
					goodService.udpateGoodsNum(good.getGid(),count);
					
					
					
					System.out.println(good.toString());
				}
				
			}else {
				//如果货架不存在，创建新商品
				
				Repertory findRepertoryById = repertoryService.findRepertoryById(rid);
				Good good = new Good();
				good.setGname(findRepertoryById.getRproduct());
				
				good.setStock(count);//库存
				good.setPurchasePrice(findRepertoryById.getRunit());//进货价
				good.setDate(findRepertoryById.getRbrithdate());//生产日期
				
				good.setType(findRepertoryById.getRtype());//类别
				good.setSid(findRepertoryById.getRput());//供应商
				
				good.setQualitaDate(findRepertoryById.getRbdate());//保质期
				
				//添加新药品
				goodService.addNewGoods(good);
				
				
			}
			
			//修改库存商品的数量
			Integer udpateRepertorysNum = repertoryService.udpateRepertorysNum(rid,count);
			
			
			
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				
				PrintWriter writer = response.getWriter();
				mapper.writeValue(writer, udpateRepertorysNum);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return null;
			//return "onshowGoods";
		}
	
	/**
	 * 下架商品
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
   
	public String outshowGoods(){
		System.out.println(count);
		
		System.out.println("下架商品Action..................。。。。");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		
			
		String parameter = request.getParameter("count");
		String parameter2 = request.getParameter("rid");
		
		System.out.println("数量："+parameter+"id:"+parameter2);
			
			Integer id = Integer.parseInt(parameter2);
			Integer count = Integer.parseInt(parameter);
		
			//获得新的仓库药品数量
			Integer outshowGoods = repertoryService.outshowGoods(id,count);
			
			System.out.println(outshowGoods);
			
			
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				
				PrintWriter writer = response.getWriter();
				mapper.writeValue(writer, outshowGoods);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return "outshowGoods";
		
	
	}
	//分页
public String LsitPage() {
		
		
		PageBean pagebean=repertoryService.LsitPage(currentPage);
		System.out.println(pagebean.toString());
		
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "LsitPage";
	}
	
	
	

}
