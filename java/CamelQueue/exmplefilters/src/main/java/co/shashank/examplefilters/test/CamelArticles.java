package co.shashank.examplefilters.test;

import org.apache.camel.Exchange;
import org.apache.abdera.model.Entry;



public class CamelArticles {
	public boolean filter(Exchange exchange) {
        Entry entry = exchange.getIn().getBody(Entry.class);
        String title = entry.getTitle();
       // System.out.println("ENTRIES " + entry.getAttributes().get(1).getLocalPart());
        System.out.println("Title :: " + title);
        boolean camelArticles = title.toLowerCase().startsWith("camel");
        if (camelArticles) {
            System.out.println("allow " + title);
        }
        return camelArticles;
    }
}
