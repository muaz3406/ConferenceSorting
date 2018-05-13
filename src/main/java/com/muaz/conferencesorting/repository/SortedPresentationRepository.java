package com.muaz.conferencesorting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.muaz.conferencesorting.entity.SortedPresentation;

@Service("sortedPresentationRepository")
public interface SortedPresentationRepository extends JpaRepository<SortedPresentation, Long>{

}
