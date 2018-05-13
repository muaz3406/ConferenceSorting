package com.muaz.conferencesorting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muaz.conferencesorting.entity.Presentation;

import java.util.List;

@Repository("presentationRepository")
public interface PresentationRepository extends JpaRepository<Presentation,Long>{
    List<Presentation> findByName(String name);
}
