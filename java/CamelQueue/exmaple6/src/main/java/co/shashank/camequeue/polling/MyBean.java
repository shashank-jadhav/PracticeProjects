package co.shashank.camequeue.polling;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;

public class MyBean {
	private ConsumerTemplate consumer;
	private ProducerTemplate producer;

	
	public MyBean() {
		super();
	}

	public MyBean(ConsumerTemplate consumer, ProducerTemplate producer) {
		super();
		this.consumer = consumer;
		this.producer = producer;
	}

	public ConsumerTemplate getConsumer() {
		return consumer;
	}

	public void setConsumer(ConsumerTemplate consumer) {
		this.consumer = consumer;
	}

	public ProducerTemplate getProducer() {
		return producer;
	}

	public void setProducer(ProducerTemplate producer) {
		this.producer = producer;
	}

	public void someMethod() {
		System.out.println("IN BEAN..");
	}
}
