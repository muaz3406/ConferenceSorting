package com.muaz.conferencesorting.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.muaz.conferencesorting.entity.Presentation;
import com.muaz.conferencesorting.repository.PresentationRepository;

@Service("presentationService")
public class PresentationServiceImpl implements PresentationService{
	
	private static final Logger log = LoggerFactory.getLogger(PresentationServiceImpl.class);


	@Autowired
	@Qualifier("presentationRepository")
	private PresentationRepository presentationRepository;
	
	@Autowired
	@Qualifier("presentationSetTimes")
	private PresentationSetTimesService presentationSetTimesService;
	
	private ArrayList<Presentation> prelist = new ArrayList<Presentation>();
	
	@Override
	public void sortedPresentations(){
		try {
			  prelist=(ArrayList<Presentation>) presentationRepository.findAll();

			
		}catch(Exception b){
			log.error("**************Find All Error*****************", b);

			
		}
		

		try {
			
			presentatitonSortTimes(presentationSetTimesService.PresentatitonSetTimes(presentatitonSortDurations(prelist)));
			
//			presentationRepository.save(presentatitonSortTimes(presentationSetTimesService.PresentatitonSetTimes(presentatitonSortDurations(prelist))));
			  
		}catch(Exception e){
			log.error("**************Sort times Error*****************", e);
	
		}
		
		
try {
			for(Presentation pre:prelist){
				presentationRepository.save(pre);
				
			}
			
			  
		}catch(Exception e){
			log.error("**************Save Error*****************", e);
	
		}
		
	
	}
	
	public ArrayList<Presentation> presentatitonSortDurations(ArrayList<Presentation> prelist) throws Exception {
		int k;
			try {
			for (int i = prelist.size(); i >= 0; i--) {
				for (int j = 0; j < prelist.size() - 1; j++) {
					k=j+1;
					if(prelist.get(j).getDuration()<prelist.get(k).getDuration()) {
						prelist.set(j, prelist.set(k, prelist.get(j)));
					}
				}
			}
			
		}catch(Exception e){
			log.error("**************Sort Duration Error*****************", e);

			
		}
		return prelist;

		
	}

	public ArrayList<Presentation> presentatitonSortTimes(ArrayList<Presentation> prelist) throws Exception {
		int k,hour1,min1,hour2,min2;
		String Hour1,Min1,Hour2,Min2;		
		try {
			for (int i = prelist.size(); i >= 0; i--) {
				for (int j = 0; j < prelist.size() - 1; j++) {
					k=j+1;
					if(prelist.get(k).isProgrammed()&&prelist.get(j).isProgrammed()) { //Control For Unproggramed Presentations
					Hour1=prelist.get(j).getTime().substring(0,prelist.get(j).getTime().indexOf(":"));
					hour1=Integer.parseInt(Hour1);
					Hour2=prelist.get(k).getTime().substring(0,prelist.get(k).getTime().indexOf(":"));
					hour2=Integer.parseInt(Hour2);
					Min1=prelist.get(j).getTime().substring(prelist.get(j).getTime().indexOf(":")+1,prelist.get(j).getTime().length());
					min1=Integer.parseInt(Min1);
					Min2=prelist.get(k).getTime().substring(prelist.get(k).getTime().indexOf(":")+1,prelist.get(k).getTime().length());
					min2=Integer.parseInt(Min2);
					if(hour1>hour2) {
						prelist.set(j, prelist.set(k, prelist.get(j)));
					}else if(hour1==hour2) {
						if(min1>min2) {
							prelist.set(j, prelist.set(k, prelist.get(j)));
						}
					}
					}
				}
			}
			
		}catch(Exception e){
			log.error("**************Sort Times Error*****************", e);

		}
		
		return prelist;
	}
	
	
	public void savePreList(Presentation presentation){
		presentationRepository.save(presentation);
		
	}

	
}
