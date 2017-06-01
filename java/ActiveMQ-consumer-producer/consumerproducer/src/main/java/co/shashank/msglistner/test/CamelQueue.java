package co.shashank.msglistner.test;

import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelQueue {

	public static void sendToQueue(SamplePojo aMessage)
	{
		try {
			CamelContext camelContext = new DefaultCamelContext();
			camelContext.addComponent("activemq",
					ActiveMQComponent.activeMQComponent("vm://192.168.1.161?broker.persistent=false"));
			
			camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("activemq:topic:start").to(
							"stream:out");
				}
			});
			 ProducerTemplate producer = camelContext.createProducerTemplate();
			 camelContext.start();
			 producer.sendBody("activemq:topic:start",aMessage);
			
		} catch (CamelExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
