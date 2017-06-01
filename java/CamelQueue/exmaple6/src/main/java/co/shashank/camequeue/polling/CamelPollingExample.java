package co.shashank.camequeue.polling;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.util.jndi.JndiContext;

public class CamelPollingExample {
	public static final void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		
		camelContext.addComponent("activemq",
				ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
		try {
			camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("activemq:queue:start?asyncConsumer=true&concurrentConsumers=10").to("activemq:queue:first");

					from("activemq:queue:first").to("activemq:queue:second");
				}
			});
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("activemq:queue:start", "hello");
			ConsumerTemplate templt = camelContext.createConsumerTemplate();
			String body = templt.receiveBody("activemq:queue:second", 100, String.class);
			System.out.println("YES polling done :: " + body);
			
			
			Endpoint endpoint = camelContext.getEndpoint("activemq:queue:start");
			
			PollingConsumer consumer = endpoint.createPollingConsumer();
			consumer.start();
			
			Exchange exchange = consumer.receiveNoWait();
			
			System.out.println(exchange + "  lololo");
		 
			
		} finally {
			camelContext.stop();
		}
	}
}