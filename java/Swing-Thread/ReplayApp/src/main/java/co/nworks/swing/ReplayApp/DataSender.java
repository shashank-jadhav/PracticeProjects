package co.nworks.swing.ReplayApp;

import java.util.ArrayList;
import java.util.List;

import co.nworks.swing.ReplayApp.MessageProducer.Times;

public class DataSender {

private  static List<String> data = new ArrayList<String>();
	
	static {
		String s = "shashank";
		
		for(int i = 0 ; i < 1000 ; i++)
		{
			data.add(s + " :::: " + i);
		}
		
	}

	public static List<String> getData() {
		return data;
	}

	public static void setData(List<String> data) {
		DataSender.data = data;
	}
	
	
	public static void main(String[] args) {
		try {
			MessageProducer mp = new MessageProducer();
			Thread th = new Thread(mp); 
			th.start();
			th.sleep(5000);
			mp.setTime(Times.TwoX);
			th.sleep(10000);
			mp.setTime(Times.OneX);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
