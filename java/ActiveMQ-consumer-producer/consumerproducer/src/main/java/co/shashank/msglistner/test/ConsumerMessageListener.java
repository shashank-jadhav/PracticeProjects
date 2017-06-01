package co.shashank.msglistner.test;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


public class ConsumerMessageListener implements MessageListener {
	private String consumerName;

	public ConsumerMessageListener(String consumerName) {
		this.consumerName = consumerName;
	}
	
	public void onMessage(Message message) {
			
		if(message instanceof ObjectMessage)
		{
			try {
				SamplePojo om = (SamplePojo) ((ObjectMessage) message).getObject();
				CamelQueue.sendToQueue(om);
				System.out.println(consumerName + " received "
						+ (om.getName()));
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
	}

}