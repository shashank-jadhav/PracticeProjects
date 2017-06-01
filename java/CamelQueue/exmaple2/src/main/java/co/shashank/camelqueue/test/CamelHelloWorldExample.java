package co.shashank.camelqueue.test;



import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelHelloWorldExample {
	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			
			/*camelContext.addRoutes(new RouteBuilder() {
				public void configure() {
					from("activemq:queue:start?asyncConsumer=true&concurrentConsumers=10")
							.unmarshal().json(JsonLibrary.Jackson)
							.to("bean:myBean?method=appendCamel");	
					
				}
			});*/
			
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("activemq:queue:start", "Hello World");
			
			
		} finally {
			camelContext.stop();
		}
	}
}