package com.muaz.conferencesorting.services;
import java.util.ArrayList;

import com.muaz.conferencesorting.entity.Presentation;

public class BinPacking {

	public BinPacking(ArrayList<Presentation> l, ArrayList<Integer> order) {
		int ctrl;

		for (Presentation str : l) {
			System.out.println(str);
		}
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getDuration() == 60) {
				order.add(i);
			}
		}
		for (int i = 0; i < l.size(); i++) {
			for (int j = 1; j < l.size(); j++) {
				if (i != j) {
					if (l.get(i).getDuration() + l.get(j).getDuration() == 60 && l.get(i).getDuration() != 0
							&& l.get(j).getDuration() != 0) {
						order.add(Integer.parseInt(Integer.toString(i) + Integer.toString(j)));
						break;
					}
				}
			}
		}
		for (int i = 0; i < order.size(); i++) {
			for (int j = 0; j < order.size(); j++) {
				if ((i != j) && (order.get(i) / 10 != 0) && (order.get(j) / 10 != 0)) {
					String a = new StringBuilder(Integer.toString(order.get(j))).reverse().toString();
					ctrl = Integer.parseInt(a);
					if (order.get(i) == ctrl) {
						order.remove(j);
						continue;
					}
					if (order.get(i) / 10 == ctrl / 10 || order.get(i) / 10 == ctrl % 10
							|| order.get(i) % 10 == ctrl / 10 || order.get(i) % 10 == ctrl % 10) {
						order.remove(j);
					}
				}
			}
		}
	}

}
