package com.rest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.main.entity.Musicians;

@Repository
public interface MusiciansRepository extends JpaRepository<Musicians, Long>
{

}
