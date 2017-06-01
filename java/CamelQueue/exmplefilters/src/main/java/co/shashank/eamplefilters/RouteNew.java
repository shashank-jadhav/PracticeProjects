package co.shashank.eamplefilters;


import org.apache.camel.Endpoint;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

public class RouteNew extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// you can define the endpoints and predicates here
		// it is more common to inline the endpoints and predicates in the route
		// as shown in the CreateOrderRoute

		Endpoint newOrder = endpoint("activemq:topic:newOrder");
		Endpoint endpt = endpoint("activemq:topic:endpt");

		DataFormat jaxbDataFormat = new JaxbDataFormat("co.nworks.eamplefilters");
		Predicate is = xpath("persons/person/name = 'name0'");
		//from(newOrder).unmarshal(jaxbDataFormat).bean(EchoBean.class, "printWeatherStation");

		/*from(newOrder).unmarshal(jaxbDataFormat)
				.to("activemq:queue:routeYes", "activemq:queue:routeNO").bean(EchoBean.class, "printWeatherStation");*/
		
		//from(newOrder).filter().xpath("persons/person[@name = 'name0']").to("activemq:topic:routeNO");
		from(newOrder).unmarshal(jaxbDataFormat).bean(EchoBean.class,"printWeatherStation");
		/*
		 * from(newOrder) .choice()
		 * .when(is).unmarshal(jaxbDataFormat).to("activemq:queue:routeYes")
		 * .bean(EchoBean.class, "printWeatherStation")
		 * .otherwise().unmarshal(jaxbDataFormat)
		 * .to("activemq:queue:routeNO").bean(EchoBean.class,
		 * "printWeatherStation");
		 */

		// from(newOrder).to("activemq:queue:newOrder1").to("log:activemq:queue:newOrder");
	}
}
