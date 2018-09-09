package com.xiaoma.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xiaoma.entity.ARTICLE;
public interface ARTICLERepository extends JpaRepository<ARTICLE,Integer>{

	Page<ARTICLE> findAll(Specification<ARTICLE> specification, Pageable pageable);
	
}
