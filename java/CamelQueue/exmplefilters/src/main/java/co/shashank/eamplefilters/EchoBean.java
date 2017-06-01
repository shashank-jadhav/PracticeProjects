package co.shashank.eamplefilters;

import java.util.List;

import scala.Array;

public class EchoBean {
	
	public void printWeatherStation(Persons p) {
		System.out.println("IN ECHO BEAn :::" + p.getPersons().get(1).getName());
        //System.out.println("SSS" + " *****************"+ v.getAge());
    }
}
