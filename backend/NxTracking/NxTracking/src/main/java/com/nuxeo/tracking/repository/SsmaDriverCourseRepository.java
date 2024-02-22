package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SsmaDriverCourse;

@Repository
public interface SsmaDriverCourseRepository extends JpaRepository<SsmaDriverCourse, Long> { 

	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.id = :id AND o.dateDelete IS NULL")
	SsmaDriverCourse findObjectId(Long id); 
	
	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<SsmaDriverCourse> findAll(); 

	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.cpf = :cpf AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<SsmaDriverCourse> findByCpfAndDate(String cpf, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<SsmaDriverCourse> findByDate(LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.dateRegistration IS NULL AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<SsmaDriverCourse> findByMatriculate(); 

	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.dateRegistration IS NOT NULL AND o.dateFinishedCourse IS NULL AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<SsmaDriverCourse> findByResultCourse(LocalDateTime begin, LocalDateTime end); 

}