package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> { 

	@Query("SELECT o FROM Device o WHERE o.id = :id AND o.dateDelete IS NULL")
	Device findObjectId(Long id); 

	@Query("SELECT o FROM Device o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Device> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM Device o WHERE o.name = :name AND o.dateDelete IS NULL")
	Device findByName(String name); 

	@Query("SELECT o FROM Device o WHERE o.customer.id = :idCustomer AND o.name = :name AND o.dateDelete IS NULL")
	Device findByNameAndCustomer(String name, Long idCustomer); 

	@Query("SELECT o FROM Device o WHERE o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Device> findByNameLike(String name); 

	@Query("SELECT o FROM Device o WHERE o.customer.id = :idCustomer AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Device> findByCustomerAndNameLike(Long idCustomer, String name); 

	@Query("SELECT o FROM Device o WHERE o.customer.company.id = :idCompany AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Device> findByCompanyNameLike(Long idCompany, String name); 

}