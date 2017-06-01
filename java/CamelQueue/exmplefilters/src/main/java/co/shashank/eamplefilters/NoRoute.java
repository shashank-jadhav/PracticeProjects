package co.shashank.eamplefilters;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;

public class NoRoute extends RouteBuilder {

	public void configure() {
		Endpoint routeNO = endpoint("activemq:topic:routeNO");
		
		from(routeNO).bean(NoBean.class, "printB");

	}
}
