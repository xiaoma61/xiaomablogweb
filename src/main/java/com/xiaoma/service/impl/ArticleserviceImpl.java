package com.xiaoma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoma.entity.ARTICLE;
import com.xiaoma.repository.ARTICLERepository;
import com.xiaoma.service.Articleservice;
@Service
public class ArticleserviceImpl implements Articleservice{
	@Autowired
	private ARTICLERepository articleRepository;
	public List<ARTICLE> getARTICLE_List() {
		// TODO Auto-generated method stub
		List<ARTICLE>articleList=(List<ARTICLE>)articleRepository.findAll();
		return articleList;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		articleRepository.delete(id);
	}

	public void add(ARTICLE article) {
		// TODO Auto-generated method stub
		articleRepository.save(article);
		
	}

	public ARTICLE getARTICLE_Byid(Integer id) {
		// TODO Auto-generated method stub
		ARTICLE article=articleRepository.findOne(id);
		return article;
	}

	public ARTICLE editARTICLE_Byid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
