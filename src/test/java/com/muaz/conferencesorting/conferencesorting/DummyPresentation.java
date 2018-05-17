package com.muaz.conferencesorting.conferencesorting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DummyPresentation {
	private Long id;
    private String name;
	private int duration;
	private String time = "0";
	private boolean programmed;

}
