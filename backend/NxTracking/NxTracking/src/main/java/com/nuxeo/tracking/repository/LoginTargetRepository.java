package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginTarget;

@Repository
public interface LoginTargetRepository extends JpaRepository<LoginTarget, Long> { 

	@Query("SELECT o FROM LoginTarget o WHERE o.id = :id")
	LoginTarget findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginTarget o WHERE o.idLogin = :idLogin AND o.target.dateDelete IS NULL")
	List<LoginTarget> findAllLogin(Long idLogin); 

	@Query("SELECT o FROM LoginTarget o WHERE o.target.id = :idTarget AND o.target.dateDelete IS NULL")
	List<LoginTarget> findAllTarget(Long idTarget); 

	@Query("SELECT o FROM LoginTarget o WHERE o.idLogin = :idLogin AND o.target.device IS NOT NULL AND o.target.dateDelete IS NULL")
	List<LoginTarget> findAllLoginIdPosition(Long idLogin); 

	@Query("SELECT NEW com.nuxeo.tracking.commons.entity.IdentifierKey(o.target.device.id) FROM LoginTarget o WHERE o.idLogin = :idLogin AND o.target.device IS NOT NULL AND o.target.dateDelete IS NULL")
	List<LoginTarget> findAllLoginPosition(Long idLogin); 

	@Query("SELECT NEW com.nuxeo.tracking.commons.entity.IdentifierKey(o.target.device.id) FROM LoginTarget o WHERE o.idLogin = :idLogin AND o.target.device.id IN (:listDevice) AND o.target.device IS NOT NULL AND o.target.dateDelete IS NULL")
	List<LoginTarget> findAllLoginPositionAndListDevice(Long idLogin, List<Long> listDevice); 

	@Query("SELECT o FROM LoginTarget o WHERE o.idLogin = :idLogin AND o.target.name LIKE %:complement% AND o.target.dateDelete IS NULL ORDER by o.target.identifier ASC")
	List<LoginTarget> findAllComplementLike(Long idLogin, String complement); 

	@Query("SELECT o FROM LoginTarget o WHERE o.idLogin = :idLogin AND o.target.identifier LIKE %:identifier% AND o.target.dateDelete IS NULL ORDER by o.target.identifier ASC")
	List<LoginTarget> findAllIdentifierLike(Long idLogin, String identifier); 

}