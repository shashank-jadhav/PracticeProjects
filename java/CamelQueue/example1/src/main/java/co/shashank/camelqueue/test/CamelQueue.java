package co.shashank.camelqueue.test;

import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelQueue {

	public static void sendToQueue()
	{
		try {
			CamelContext camelContext = new DefaultCamelContext();
			camelContext.addComponent("activemq",
					ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
			
			camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("activemq:queue:start").to(
							"stream:out");
				}
			});
			 ProducerTemplate producer = camelContext.createProducerTemplate();
			 camelContext.start();
			 producer.sendBody("activemq:queue:start","SHANKS");
			
		} catch (CamelExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
			CamelContext camelContext = new DefaultCamelContext();
			camelContext.addComponent("activemq",
					ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
			
			camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("activemq:queue:start").to(
							"stream:out");
				}
			});
			 ProducerTemplate producer = camelContext.createProducerTemplate();
			 camelContext.start();
			 producer.sendBody("activemq:queue:start","SHANKS");
			
		} catch (CamelExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
