package co.demo3.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Specify @Configuration and/or @Component classes to be provided to the
	 * root application context.
	 * 
	 * @return the configuration classes for the root application context, or
	 *         null if creation and registration of a root context is not
	 *         desired
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Specify @Configuration and/or @Component classes to be provided to the
	 * dispatcher servlet application context.
	 * 
	 * @return the configuration classes for the dispatcher servlet application
	 *         context (may not be empty or null).
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { CommonConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
