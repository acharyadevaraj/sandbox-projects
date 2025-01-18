package com.kafkawikimediaconsumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafkawikimediaconsumer.model.WikiMediaData;

@Repository
public interface WikiMediaDataRepo extends JpaRepository<WikiMediaData, Long> {

}
