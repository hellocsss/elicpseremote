package com.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GetDays {
		 
		public static List getDays (String beginDate,String endDate) throws Exception{
//			String beginDate = "2019-05-10";//开始时间
//			String endDate = "2019-06-13";//结束时间
	 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(beginDate));
			
			List daysList = new ArrayList();
			
			for (long d = cal.getTimeInMillis(); d <= sdf.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
				System.out.println(sdf.format(d));
				daysList.add(sdf.format(d));
			}
			System.out.println(".......");
			
			System.out.println(daysList.toString());
			
			return daysList;
			
	 
		}
	 
		public static long get_D_Plaus_1(Calendar c) {
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
			return c.getTimeInMillis();
		}


}
