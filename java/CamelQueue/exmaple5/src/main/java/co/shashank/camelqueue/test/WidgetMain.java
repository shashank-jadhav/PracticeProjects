package co.shashank.camelqueue.test;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;

/**
 * A plain Java Main to start the widget and gadget example.
 */
public final class WidgetMain {

	 @EndpointInject(uri = "file:src/test/resources")
	  private ProducerTemplate inbox;

    private WidgetMain() {
    	// to comply with checkstyle
    }

    public static void main(String[] args) throws Exception {
        // create the ActiveMQ component
    	
    	CamelContext camelContext = new DefaultCamelContext();
		camelContext.addComponent("activemq", ActiveMQComponent
				.activeMQComponent("vm://localhost?broker.persistent=false"));
		
    	//camelContext.addRoutes(new WidgetGadgetRoute());
    	//camelContext.addRoutes(new CreateOrderRoute());
    	  
		
		camelContext.addRoutes(new RouteBuilder() {
			public void configure() {
				DataFormat jaxbDataFormat = new JaxbDataFormat("com.mycompany.model.entities.weather");// WARNING two packages for JaxbDataFormat

                from("file:src/test/resources/?fileName=order1.xml&noop=true&idempotent=false")
                .split()
                .tokenizeXML("metData")
                .unmarshal(jaxbDataFormat)
                .to("mock:meteo");   
				
			}
		});
		
    	camelContext.start();
       
    }

   
}
