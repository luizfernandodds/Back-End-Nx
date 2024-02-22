package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> { 

	@Query("SELECT o FROM Role o WHERE o.id = :id AND o.dateDelete IS NULL")
	Role findObjectId(Long id); 
	
	@Query("SELECT o FROM Role o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Role> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Role o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Role> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM Role o WHERE o.loginCreate = :idLogin AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Role> findByLoginAndCustomer(Long idLogin, Long idCustomer); 

	@Query("SELECT o FROM Role o INNER JOIN o.profiles as p WHERE o.id = :idProfile AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Role> findByRoleProfileAndCustomer(Long idProfile, Long idCustomer); 

	@Query("SELECT o FROM Role o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Role> findAll(); 

}