package com.muaz.conferencesorting.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.muaz.conferencesorting.entity.Network;
import com.muaz.conferencesorting.entity.Presentation;
import com.muaz.conferencesorting.repository.NetworkRepository;
import com.muaz.conferencesorting.repository.PresentationRepository;
import com.muaz.conferencesorting.services.PresentationService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class PresentationJsonControl {
	
	
	
  @Autowired
  @Qualifier("presentationRepository")
  private PresentationRepository presentationRepository;
  
  @Autowired
  @Qualifier("presentationService")
  private PresentationService presentationService;
  
  @Autowired
  @Qualifier("networkRepository")
  private NetworkRepository networkRepository;
  
  
  
  @RequestMapping("/add/{name}/{duration}")
  public Presentation addPre(
          @PathVariable("name")final String name,
          @PathVariable("duration")final int duration) {

	  
	  Presentation presentation= new Presentation();
	  presentation.setName(name);
	  presentation.setDuration(duration);
	  return presentationRepository.save(presentation);	 	  
  }
  
  @RequestMapping("/sort")
  public  void sortPre(){
	  presentationService.sortedPresentations();
	  
  }
  
  @RequestMapping("/all")
  public Iterable<Presentation> findAll() {
      return presentationRepository.findAll();
  }
  
  @RequestMapping("/network")
  public Network addNetwork() {

	  Network network=new Network();
	  network.setName("network");
	  network.setNetworking(true);
	  networkRepository.save(network);
	  return network;
	 	  
  }
  
  
  
  
  

}
