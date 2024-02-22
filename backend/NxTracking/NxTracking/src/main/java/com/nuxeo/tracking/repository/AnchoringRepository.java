package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Anchoring;

@Repository
public interface AnchoringRepository extends JpaRepository<Anchoring, Long> { 

	@Query("SELECT o FROM Anchoring o WHERE o.id = :id AND o.dateDelete IS NULL")
	Anchoring findObjectId(Long id); 

	@Query("SELECT o FROM Anchoring o WHERE o.login.id = :idLogin AND o.dateDelete IS NULL")
	List<Anchoring> findByIdLogin(Long idLogin); 

}