package com.xiaoma.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//�ļ�������
public class FileUtil {
	public static void uploadFile(byte[]file,String Filepath,String filename) throws IOException
	{
		File imageFile=new File(Filepath);
		if(imageFile.exists()){
			imageFile.mkdirs();//�����༶�ļ���
			
		}
		FileOutputStream out =new FileOutputStream(Filepath+filename);
		out.write(file);
		out.flush();
		out.close();
		
	}
	
}
