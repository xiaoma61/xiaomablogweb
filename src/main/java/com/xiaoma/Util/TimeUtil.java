package com.xiaoma.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String GetDate()
	{
		String Sdate = null;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date=new Date();
		Sdate=df.format(date);
		return Sdate;
	}

}
