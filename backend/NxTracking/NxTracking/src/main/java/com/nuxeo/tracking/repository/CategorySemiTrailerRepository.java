package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CategorySemiTrailer;

@Repository
public interface CategorySemiTrailerRepository extends JpaRepository<CategorySemiTrailer, Long> { 

	@Query("SELECT o FROM CategorySemiTrailer o WHERE o.id = :id AND o.dateDelete IS NULL")
	CategorySemiTrailer findObjectId(Long id); 
	
}