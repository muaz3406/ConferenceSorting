package com.muaz.conferencesorting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.muaz.conferencesorting.entity.Presentation;

import java.util.List;

@Service("presentationRepository")
public interface PresentationRepository extends JpaRepository<Presentation,Long>{
    List<Presentation> findByName(String name);
}
