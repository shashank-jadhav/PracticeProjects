package co.shashank.camelqueue.test;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FlightData {

	public static void main(String[] args) {
		try {
			CamelContext camelContext = new DefaultCamelContext();
			// Adding routes
			camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("stomp:topic:topic/topicATL?brokerURL=tcp://activemq.airbossclient.com:62626&login=indmex&passcode=9jrk4d1!$ss")
							.to("stream:out");
				}
			});
			camelContext.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
