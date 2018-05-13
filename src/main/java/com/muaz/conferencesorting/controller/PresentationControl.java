package com.muaz.conferencesorting.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.muaz.conferencesorting.entity.Network;
import com.muaz.conferencesorting.entity.Presentation;
import com.muaz.conferencesorting.repository.NetworkRepository;
import com.muaz.conferencesorting.repository.PresentationRepository;
import com.muaz.conferencesorting.repository.SortedPresentationRepository;
import com.muaz.conferencesorting.services.PresentationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PresentationControl {
	
	
	
  @Autowired
  @Qualifier("presentationRepository")
  private PresentationRepository presentationRepository;
  
  @Autowired
  @Qualifier("presentationService")
  private PresentationService presentationService;
  
  @Autowired
  @Qualifier("networkRepository")
  private NetworkRepository networkRepository;
  
  @Autowired
  @Qualifier("sortedPresentationRepository")
  private SortedPresentationRepository sortedPresentationRepository;
  
  
  @RequestMapping(path = "/")
  public String index() {
      return "index";
  }
  
  
  @RequestMapping(path = "/presentation/add", method = RequestMethod.GET)
  public String createProduct(Model model) {
      model.addAttribute("presentation", new Presentation());
      return "edit";
  }
  
  @RequestMapping(path = "/save", method = RequestMethod.POST)
  public String savePresentation(Presentation presentation) {
      presentationRepository.save(presentation);
    // presentationService.sortedPresentations();
      return "index";
  }
  
  @RequestMapping(path = "/sortedlist", method = RequestMethod.GET)
  public String getAllSortedPresentations(Model model) {
	  presentationService.sortedPresentations();
      model.addAttribute("sortedlist", sortedPresentationRepository.findAll());
      return "sortedlist";
  }
  
  @RequestMapping(path = "/sortedlistNetwork", method = RequestMethod.GET)
  public String getAllSortedPresentationsWithNetwork(Model model) {
	  Network network=new Network();
	  network.setName("network");
	  network.setNetworking(true);
	  networkRepository.save(network);
	  
	  presentationService.sortedPresentations();
      model.addAttribute("sortedlist", sortedPresentationRepository.findAll());
      model.addAttribute("network", networkRepository.findAll());
      return "sortedlist";
  }

  
//  @RequestMapping(path = "/sort")
//  public String sortPrelist() {
//	  presentationService.sortedPresentations();
//	  return "index";
//  }
//  
//  @RequestMapping("/add/{name}/{duration}")
//  public Presentation addPre(
//          @PathVariable("name")final String name,
//          @PathVariable("duration")final int duration) {
//
//	  
//	  Presentation presentation= new Presentation();
//	  presentation.setName(name);
//	  presentation.setDuration(duration);
//	  return presentationRepository.save(presentation);	 	  
//  }
//  
//  @RequestMapping("/sort")
//  public  void sortPre(){
//	  presentationService.sortedPresentations();
//	  
//  }
//  
//  @RequestMapping("/pretable")
//  public Iterable<Presentation> findAllPreTable() {
//      return presentationRepository.findAll();
//  }
//  
//  
//  @RequestMapping("/sortedtable")
//  public Iterable<SortedPresentation> findAllSortedTable(){
//	  return sortedPresentationRepository.findAll();
//  }
//  
//  
//  @RequestMapping("/network")
//  public Network addNetwork() {
//
//	  Network network=new Network();
//	  network.setName("network");
//	  network.setNetworking(true);
//	  networkRepository.save(network);
//	  return network;
//	 	  
//  }
  
  
  
  
  

}
