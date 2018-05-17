package com.muaz.conferencesorting.conferencesorting;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.muaz.conferencesorting.entity.Network;
import com.muaz.conferencesorting.entity.Presentation;
import com.muaz.conferencesorting.repository.NetworkRepository;
import com.muaz.conferencesorting.repository.PresentationRepository;
import com.muaz.conferencesorting.repository.SortedPresentationRepository;
import com.muaz.conferencesorting.services.PresentationService;
import com.muaz.conferencesorting.services.PresentationServiceImpl;
import com.muaz.conferencesorting.services.PresentationSetTimesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConferencesortingApplicationTests {
	
	@Mock
	private PresentationRepository presentationRepository;
	  
	@Mock
	private PresentationServiceImpl presentationServiceImpl;
	  
	@Mock
	private PresentationSetTimesService presentationSetTimesService;
	  
	@Mock 
	private SortedPresentationRepository sortedPresentationRepository;
	
	
	@Before
	public void setUp() {
		ArrayList<Presentation> dummyPreList = new ArrayList<Presentation>();

		Presentation p0=mock(Presentation.class);
		p0.setId(1L);
		p0.setName("p1");
		p0.setDuration(50);
		p0.setProgrammed(false);
		dummyPreList.set(0,p0);
		Presentation p1=mock(Presentation.class);
		p1.setId(1L);
		p1.setName("p9");
		p1.setDuration(39);
		p1.setProgrammed(false);
		dummyPreList.set(1,p1);
		Presentation p2=mock(Presentation.class);
		p2.setId(1L);
		p2.setName("p2");
		p2.setDuration(55);
		p2.setProgrammed(false);
		dummyPreList.set(2,p2);

		Presentation p3=mock(Presentation.class);
		p3.setId(1L);
		p3.setName("p3");
		p3.setDuration(60);
		p3.setProgrammed(false);
		dummyPreList.set(3,p3);

		Presentation p4=mock(Presentation.class);
		p4.setId(1L);
		p4.setName("p4");
		p4.setDuration(45);
		p4.setProgrammed(false);
		dummyPreList.set(4,p4);

		Presentation p5=mock(Presentation.class);
		p5.setId(1L);
		p5.setName("p5");
		p5.setDuration(35);
		p5.setProgrammed(false);
		dummyPreList.set(5,p5);

		Presentation p6=mock(Presentation.class);
		p6.setId(1L);
		p6.setName("p6");
		p6.setDuration(46);
		p6.setProgrammed(false);
		dummyPreList.set(6,p6);

		Presentation p7=mock(Presentation.class);
		p7.setId(1L);
		p7.setName("p7");
		p7.setDuration(34);
		p7.setProgrammed(false);
		dummyPreList.set(7,p7);

		Presentation p8=mock(Presentation.class);
		p8.setId(1L);
		p8.setName("p8");
		p8.setDuration(58);
		p8.setProgrammed(false);
		dummyPreList.set(8,p8);

		Presentation p9=mock(Presentation.class);
		p9.setId(1L);
		p9.setName("p9");
		p9.setDuration(39);
		p9.setProgrammed(false);
		dummyPreList.set(9,p9);
		
		Network n=mock(Network.class);

	}
	

	
	
	@Test
	public void testNoNetwork() {
		
		
		
		
		
		
	}
	
	@Test
	public void testForNetwork() {
		
		
		
		
		
	}

}
