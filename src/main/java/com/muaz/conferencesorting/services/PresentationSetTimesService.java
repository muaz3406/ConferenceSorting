package com.muaz.conferencesorting.services;

import java.text.ParseException;
import java.util.ArrayList;

import com.muaz.conferencesorting.entity.Network;
import com.muaz.conferencesorting.entity.Presentation;


public interface PresentationSetTimesService{
	ArrayList<Presentation> PresentatitonSetTimes(ArrayList<Presentation> prelist) throws ParseException ;

}
