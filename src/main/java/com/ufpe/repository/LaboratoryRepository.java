package com.ufpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpe.model.Laboratory;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long>{

}
