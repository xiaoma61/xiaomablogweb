package com.xiaoma.service.impl;

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

import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.repository.ARTICLECOMMENTRepository;
import com.xiaoma.service.ARTICLECOMMENTService;
@Service
public class ARTICLECOMMENTServiceimpl implements  ARTICLECOMMENTService{

	
	@Autowired
	ARTICLECOMMENTRepository articlecommentRepository;
	public Page<ARTICLECOMMENT> findByPARENTID(int page, int size, final int PARENTID) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(page, size,Sort.Direction.ASC,"ID");
		Page<ARTICLECOMMENT>articlecommentPage= articlecommentRepository.findAll(new Specification<ARTICLECOMMENT>(){

			public Predicate toPredicate(Root<ARTICLECOMMENT> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path<String>PARENTIDPath=root.get("PARENTID");
				query.where(cb.equal(PARENTIDPath, PARENTID));
				
				
				return null;
			}
			
			
		}, pageable);
				
				
				
		
		return articlecommentPage;
	}
	public Page<ARTICLECOMMENT> findByARTICLEID(int page, int size, final int PARENTID, final int ARTICLEID) {
		// TODO Auto-generated method stub
		Pageable pageable=new PageRequest(page,size,Sort.Direction.ASC,"ID");
		Page<ARTICLECOMMENT>page1=articlecommentRepository.findAll(new Specification<ARTICLECOMMENT>(){

			public Predicate toPredicate(Root<ARTICLECOMMENT> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path<String>PARENTIDPath=root.get("PARENTID");
				Path<String>ARTICLEIDPath=root.get("ARTICLEID");
				query.where(cb.equal(PARENTIDPath, PARENTID),cb.equal(ARTICLEIDPath, ARTICLEID));
				
				
				return null;
			}
			
			
			
		}, pageable);
		
		
		
		
		return page1;
	}

}
