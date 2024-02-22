package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SsmaDriverScore;

@Repository
public interface SsmaDriverScoreRepository extends JpaRepository<SsmaDriverScore, Long> { 

	@Query("SELECT o FROM SsmaDriverScore o WHERE o.id = :id AND o.dateDelete IS NULL")
	SsmaDriverScore findObjectId(Long id); 
	
	@Query("SELECT o FROM SsmaDriverCourse o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<SsmaDriverScore> findAll(); 

	@Query("SELECT o FROM SsmaDriverScore o ORDER BY o.totalScore ASC")
	List<SsmaDriverScore> findLowestScore(); 

	@Query("SELECT o FROM SsmaDriverScore o ORDER BY o.totalScore DESC")
	List<SsmaDriverScore> findHighestScore(); 

	@Query("SELECT o FROM SsmaDriverScore o WHERE o.cpf = :cpf AND o.dateReception >= :begin AND o.dateReception <= :end ORDER BY o.dateReception DESC")
	List<SsmaDriverScore> findByCpfAndDate(String cpf, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM SsmaDriverScore o WHERE o.dateReception >= :begin AND o.dateReception <= :end ORDER BY o.cpf DESC")
	List<SsmaDriverScore> findByDate(LocalDateTime begin, LocalDateTime end); 

}