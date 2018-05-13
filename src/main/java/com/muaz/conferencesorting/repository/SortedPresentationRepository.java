package com.muaz.conferencesorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muaz.conferencesorting.entity.SortedPresentation;

public interface SortedPresentationRepository extends JpaRepository<SortedPresentation, Long>{

}
