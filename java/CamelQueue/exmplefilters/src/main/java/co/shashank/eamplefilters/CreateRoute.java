package co.shashank.eamplefilters;

import org.apache.camel.builder.RouteBuilder;

public class CreateRoute extends RouteBuilder{

	public void configure() {
		//errorHandler(deadLetterChannel("mock:error"));
		from("file:src/main/resources?noop=true")
				.to("activemq:topic:newOrder");

	}
}
