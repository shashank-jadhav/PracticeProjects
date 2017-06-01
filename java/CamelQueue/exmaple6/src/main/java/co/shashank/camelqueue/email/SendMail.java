package co.shashank.camelqueue.email;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Producer;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class SendMail {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext camelContext = new DefaultCamelContext();

		camelContext.addComponent("activemq",
				ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
		
		camelContext.addRoutes(new RouteBuilder() {
			public void configure() {
				from("activemq:queue:start").to(
						"smtp://smtp.1and1.com:25?username=USERNAME@abc.co&password=PASSWORD&to=shashankjadhav08@gmail.com");

			}
		});
		ProducerTemplate template = camelContext.createProducerTemplate();
		camelContext.start();
		template.sendBody("activemq:queue:start", "hello this is camel queue example");
	}

}
