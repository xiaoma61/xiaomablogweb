package com.xiaoma.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class ImageUtil {
	//base64转图片储存
	public static boolean GenerateImage(String imgStr,String Path)
	{
		if(imgStr==null){
			return false;
			}
		BASE64Decoder decoder=new BASE64Decoder();
		
		
		try {
			byte[] bytes=decoder.decodeBuffer(imgStr);
			for(int i=0;i<bytes.length;++i)
			{
				if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }

			}
			OutputStream out=new FileOutputStream(Path);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
		
	}

}
