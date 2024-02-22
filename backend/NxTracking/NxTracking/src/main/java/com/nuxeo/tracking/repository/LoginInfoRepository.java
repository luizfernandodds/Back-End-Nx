package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginInfo;

@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> { 

	@Query("SELECT o FROM LoginInfo o WHERE o.id = :id AND o.dateDelete IS NULL")
	LoginInfo findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginInfo o WHERE o.login.id = :idLogin AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<LoginInfo> findByLogin(Long idLogin); 
	
	@Query("SELECT o FROM LoginInfo o WHERE o.contactGroupItem.id = :idContactGroupItem")
	List<LoginInfo> findByContactGroupItem(Long idContactGroupItem); 

	@Query("SELECT o FROM LoginInfo o WHERE o.contactGroup.id = :idContactGroup")
	List<LoginInfo> findByContactGroup(Long idContactGroup); 

	@Query("SELECT o FROM LoginInfo o WHERE o.contactGroup.id IN (:listIdContactGroup)")
	List<LoginInfo> findByListContactGroup(List<Long> listIdContactGroup); 

}