package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ContactGroupItem;

@Repository
public interface ContactGroupItemRepository extends JpaRepository<ContactGroupItem, Long> { 

	@Query("SELECT o FROM ContactGroupItem o WHERE o.id = :id")
	ContactGroupItem findObjectId(Long id); 
	
	@Query("SELECT o FROM ContactGroupItem o WHERE o.login.id = :idLogin ORDER BY o.id ASC")
	List<ContactGroupItem> findByLogin(Long idLogin); 

	@Query("SELECT o FROM ContactGroupItem o WHERE o.contactGroup.id = :idContactGroup ORDER BY o.id ASC")
	List<ContactGroupItem> findByContactGroup(Long idContactGroup); 
}