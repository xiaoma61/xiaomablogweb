package com.xiaoma.service;
import java.util.List;
import com.xiaoma.entity.ARTICLE;
public interface Articleservice {
	public List<ARTICLE>getARTICLE_List();
	public void delete(Integer id);
	public void add(ARTICLE article);
	public ARTICLE getARTICLE_Byid(Integer id);
	public ARTICLE editARTICLE_Byid(Integer id);
}
