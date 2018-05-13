package com.muaz.conferencesorting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.muaz.conferencesorting.entity.Network;

@Service("networkRepository")
public interface NetworkRepository extends JpaRepository<Network,Long>{



}
