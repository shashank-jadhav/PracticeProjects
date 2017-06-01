package co.shashank.examplefilters.test;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultProducerTemplate;

public class FilterByHeaderExample {

	 public static void main(String[] args) throws Exception {
	        CamelContext camelContext = new DefaultCamelContext();
	        try {
	            camelContext.addRoutes(new RouteBuilder() {
	                public void configure() {
	                    from("direct:customer")
	                    .process(new PrioritySetter())
	                    .filter(header("highPriority")                           
	                            .isEqualTo(true))
	                        .to("direct:highPriority");
	                    from("direct:highPriority").to("stream:out");
	            }});
	            camelContext.start();
	            ProducerTemplate template = new DefaultProducerTemplate(camelContext);
	            template.start();
	            System.out.println("Post high priority message");
	            template.sendBody("direct:customer", new PriorityPayload(true, "This is high priority message"));
	            System.out.println("Post low priority message");
	            template.sendBody("direct:customer", new PriorityPayload(false, "This is low priority message"));
	            Thread.sleep(5000);
	        } finally {
	            camelContext.stop();
	        }
	    }
	     
	    private static class PrioritySetter implements Processor {
	        public void process(Exchange exchange) throws Exception {
	            PriorityPayload payload = (PriorityPayload) exchange.getIn().getBody();
	            exchange.getIn().setHeader("highPriority", payload.isHighPriority);
	            exchange.getIn().setBody(payload.payload);
	        }
	    }
	     
	    private static class PriorityPayload {
	        private boolean isHighPriority;
	        private String payload;
	        public PriorityPayload(boolean isHigh, String payload) {
	            isHighPriority = isHigh;
	            this.payload = payload;
	        }
	    }
}
