package co.demo3.persis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:hibernate-config.xml" })
public class PersistenceConfig {

}
