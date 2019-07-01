package com.itcast.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testday {
		 
		public static void main(String[] args) throws Exception {
			String beginDate = "2019-05-10";//开始时间
			String endDate = "2019-06-13";//结束时间
	 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(beginDate));
	 
			for (long d = cal.getTimeInMillis(); d <= sdf.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
				System.out.println(sdf.format(d));
			}
	 
		}
	 
		public static long get_D_Plaus_1(Calendar c) {
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
			return c.getTimeInMillis();
		}

}
