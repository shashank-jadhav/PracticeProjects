package co.shashank.camelqueue.test;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

public class TwoConsumersOnSameTopic {
	public static final void main(String[] args) throws Exception {
		

		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addComponent("activemq", ActiveMQComponent
				.activeMQComponent("vm://localhost?broker.persistent=false"));
		try {
			camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("activemq:topic:foo").to("log:a",
							"direct:a");
					
					
					
					from("activemq:topic:foo").to("log:b",
							"direct:b");

					from("direct:a").transform(
							simple("direct:a output: ${body}"))
							.to("stream:out");
					from("direct:b").transform(
							simple("direct:b output: ${body}"))
							.to("stream:out");
				}
			});
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("activemq:topic:foo", "Topic Message");
			Thread.sleep(1000);
		} finally {
			camelContext.stop();
		}
	}
}