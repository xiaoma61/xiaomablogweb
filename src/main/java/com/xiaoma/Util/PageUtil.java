package com.xiaoma.Util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
	
	private int PageNum;//第几页
	private int Total;//多少条
	private int Pages;//总页数
	
	
	private int PageSize;//条数
	private List<T>list;
	
	
	
	public PageUtil(List<T>list,int PageNum,int PageSize)
	{
		//从1开始
		this.PageNum=PageNum;
		this.PageSize=PageSize;
		this.Total=list.size();
		
		System.out.println("list2 :    "+Total);
		boolean full = Total % PageSize == 0;
		
		
		if(!full){
			//如果凑不成整数
			this.Pages = Total/PageSize + 1;
		}else{
			//如果凑成整数
			this.Pages = Total/PageSize;
		}

		int fromIndex = 0;
		int toIndex   = 0;
		fromIndex = PageNum*PageSize-PageSize;
		if(PageNum == 0){
			throw new ArithmeticException("第0页无法展示");
		}else if(PageNum>Pages){
			//如果查询的页码数大于总的页码数，list设置为[]
			list = new ArrayList<T>();
		}else if(PageNum == Pages){
			//如果查询的当前页等于总页数，直接索引到total处
			toIndex = Total;
		}else{		
			//如果查询的页码数小于总页数，不用担心切割List的时候toIndex索引会越界，直接等
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
