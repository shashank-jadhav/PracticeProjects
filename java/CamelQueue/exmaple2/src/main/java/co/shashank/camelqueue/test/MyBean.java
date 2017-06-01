package co.shashank.camelqueue.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public class MyBean {
	private static Logger logger = LoggerFactory.getLogger(MyBean.class);
	public void appendCamel(Map<String, String> data ) {
		logger.info("We should slice and dice the data: " + data);
	}
}
