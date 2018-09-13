package com.xiaoma.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static java.sql.Date GetDate()
	{
		/*String Sdate = null;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");*/
		Date date=new Date();
	/*	Sdate=df.format(date);*/
		java.sql.Date d= new java.sql.Date(date.getTime());
		return d;
	}
	public static java.sql.Date StringToDate(String sDate) throws ParseException
	{
		SimpleDateFormat sDateF=new SimpleDateFormat("yyyy-MM-dd");//把MM变成mm导致出现错误
		Date date=sDateF.parse(sDate);
		System.out.println("sDate+++"+sDate);
		System.out.println("date+++"+date);
		java.sql.Date Sqldate=new java.sql.Date(date.getTime());
		return  Sqldate;
		
	}

}
