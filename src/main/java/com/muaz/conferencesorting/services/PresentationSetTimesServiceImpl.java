package com.muaz.conferencesorting.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.muaz.conferencesorting.entity.Network;
import com.muaz.conferencesorting.entity.Presentation;
import com.muaz.conferencesorting.repository.NetworkRepository;

@Service("presentationSetTimes")
public class PresentationSetTimesServiceImpl implements PresentationSetTimesService{
	private int AM = 180;
	private int PM = 240;
	private String start = "9:00";
	
	@Autowired
	@Qualifier("networkRepository")
	private NetworkRepository networkRepository;
	
	
;

	@Override
	public ArrayList<Presentation> PresentatitonSetTimes(ArrayList<Presentation> o) throws ParseException {
		ArrayList<Integer> order = new ArrayList<Integer>();

		new BinPacking(o, order);
		
//		List<Network> networklist = new ArrayList<Network>();
//		networklist=networkRepository.findAll();
//		int nIndex=0;
//		Network n=networklist.get(0);
Network n=networkRepository.getOne((long) 1);
		if (order.size() < 3) {
			for (int i = 0; i < o.size(); i++) {
				if (AM > 0) {
					AM = AM - o.get(i).getDuration();
					o.get(i).setTime(start);
					o.get(i).setProgrammed(true);
					start = addTime(start, o.get(i).getDuration());
					if (AM < 0) {
						AM = AM + o.get(i).getDuration();
						o.get(i).setTime("0");
						o.get(i).setProgrammed(false);
						start = addTime(start, -o.get(i).getDuration());

					}
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if (order.get(i) / 10 == 0) {
					o.get(order.get(i)).setTime(start);
					o.get(order.get(i)).setProgrammed(true);
					start = addTime(start, o.get(order.get(i)).getDuration());
				} else {
					o.get(order.get(i) / 10).setTime(start);
					o.get(order.get(i) / 10).setProgrammed(true);
					start = addTime(start, o.get(order.get(i) / 10).getDuration());
					o.get(order.get(i) % 10).setTime(start);
					o.get(order.get(i) % 10).setProgrammed(true);
					start = addTime(start, o.get(order.get(i) % 10).getDuration());
				}
			}

		}
		start = "13:00";// LUNCH

		for (int i = 0; i < o.size(); i++) {
			if (PM > 0 && !o.get(i).isProgrammed()) {
				PM = PM - o.get(i).getDuration();
				o.get(i).setTime(start);
				o.get(i).setProgrammed(true);
				start = addTime(start, o.get(i).getDuration());
				if (PM < 0) {
					PM = PM + o.get(i).getDuration();
					o.get(i).setTime("0");
					o.get(i).setProgrammed(false);
					start = addTime(start, -o.get(i).getDuration());
				}
			}
		}
		// NETWORK POJO
		if (PM > 0) {
			if (PM > 60) {
				start = "16:00";
				PM = 60;
			}

			if (n.isNetworking()) {
				n.setTime(start);				
				n.setDuration(PM);
				networkRepository.save(n);
			}
		}
		return o;
	}

	public String addTime(String myTime, int i) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date d = df.parse(myTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, i);
		String newTime = df.format(cal.getTime());
		return newTime;
	}
	
	
	
		
		
	}

	

	
	


