package com.xiaoma.Util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
	
	private int PageNum;//�ڼ�ҳ
	private int Total;//������
	private int Pages;//��ҳ��
	
	
	private int PageSize;//����
	private List<T>list;
	
	
	
	public PageUtil(List<T>list,int PageNum,int PageSize)
	{
		//��1��ʼ
		this.PageNum=PageNum;
		this.PageSize=PageSize;
		this.Total=list.size();
		
		System.out.println("list2 :    "+Total);
		boolean full = Total % PageSize == 0;
		
		
		if(!full){
			//����ղ�������
			this.Pages = Total/PageSize + 1;
		}else{
			//����ճ�����
			this.Pages = Total/PageSize;
		}

		int fromIndex = 0;
		int toIndex   = 0;
		fromIndex = PageNum*PageSize-PageSize;
		if(PageNum == 0){
			throw new ArithmeticException("��0ҳ�޷�չʾ");
		}else if(PageNum>Pages){
			//�����ѯ��ҳ���������ܵ�ҳ������list����Ϊ[]
			list = new ArrayList<T>();
		}else if(PageNum == Pages){
			//�����ѯ�ĵ�ǰҳ������ҳ����ֱ��������total��
			toIndex = Total;
		}else{		
			//�����ѯ��ҳ����С����ҳ�������õ����и�List��ʱ��toIndex������Խ�磬ֱ�ӵ�
			toIndex   = PageNum*PageSize;			
		}	
		
		if(list.size() == 0){
			this.list = list;
		}else{
			this.list = list.subList(fromIndex, toIndex);
		}


		
		
	}


    public boolean hasPrevious()
    {
    	
    	if(this.PageNum-1>0)
    	{
    		return true;
    	}
    	return false;
    	
    }
    public boolean hasNext()
    {
    	if(this.Pages>=this.PageNum+1)
    	{
    		return true;
    	}
    	return false;
    }
	public int getPageNum() {
		return PageNum;
	}



	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}



	public int getTotal() {
		return Total;
	}



	public void setTotal(int total) {
		Total = total;
	}



	public int getPages() {
		return Pages;
	}



	public void setPages(int pages) {
		Pages = pages;
	}



	public int getPageSize() {
		return PageSize;
	}



	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	

}
