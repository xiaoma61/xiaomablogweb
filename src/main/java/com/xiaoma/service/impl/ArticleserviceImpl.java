package com.xiaoma.service.impl;

import java.sql.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



import com.xiaoma.entity.ARTICLE;
import com.xiaoma.repository.ARTICLERepository;
import com.xiaoma.service.ArticleService;
@Service
public class ArticleServiceimpl implements ArticleService{

	
	@Autowired
	
	ARTICLERepository articlerepository;
	public Page<ARTICLE> findARTICLECriteria(Integer page, Integer size) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(page,size, Sort.Direction.ASC,"ID");
		
		Page<ARTICLE> article= articlerepository.findAll(new Specification<ARTICLE>(){

			public javax.persistence.criteria.Predicate toPredicate(Root<ARTICLE> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path<String>ISSHOWPath=root.get("ISSHOW");
				Path<String>WRITERPath=root.get("WRITER");
				//Ä¬ÈÏÎªxiaoma
				query.where(cb.equal(ISSHOWPath, "1"),cb.equal(WRITERPath, "xiaoma"));
				return null;
			}

		
		},pageable);
		
		
		return  article;
	}
	public Page<ARTICLE> findALLByTitle(Integer page, Integer size,final String title) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(page,size, Sort.Direction.ASC,"ID");
		Page<ARTICLE>article=articlerepository.findAll(new Specification<ARTICLE>(){

			public Predicate toPredicate(Root<ARTICLE> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path<String>ISSHOWPATH=root.get("ISSHOW");
				Path<String>TITLEPATH=root.get("TITLE");
				Path<String>WRITERPATH=root.get("WRITER");
				
				query.where(cb.equal(ISSHOWPATH, "1"),cb.like(TITLEPATH, title),cb.like(WRITERPATH, "xiaoma"));
				return null;
			}
			
			
		}, pageable);
		
		
		return article;
	}
	public Page<ARTICLE> findByCREATETIMEBetween(Integer page, Integer size, final Date sDate, final Date eDate) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(page,size,Sort.Direction.ASC,"ID");
		Page<ARTICLE>article=articlerepository.findAll(new Specification<ARTICLE>(){

			

			public Predicate toPredicate(Root<ARTICLE> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path<String>ISSHOWPATH=root.get("ISSHOW");
				Path<String>WRITERPATH=root.get("WRITER");
				Path<Date>CREATETIMEPATH=root.<Date>get("CREATETIME");
			
				
				query.where(cb.equal(ISSHOWPATH, "1"),cb.equal(WRITERPATH, "xiaoma"),cb.between(CREATETIMEPATH, sDate,  eDate));
				
				
				return null;
				}
			}, pageable);
		return article;
	}

}
