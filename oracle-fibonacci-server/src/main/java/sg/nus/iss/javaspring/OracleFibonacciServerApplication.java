package sg.nus.iss.javaspring;

import java.util.EnumSet;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import sg.nus.iss.javaspring.resource.FibonacciResource;

@SpringBootApplication
public class OracleFibonacciServerApplication extends Application<Configuration>{

	public static void main(String[] args) {
		SpringApplication.run(OracleFibonacciServerApplication.class, args);
	}
	@Override
	public void initialize(Bootstrap<Configuration> bootstrap) {}
	
	@Override
	public String getName() {
		return "dropwizard";
	}

	@Override
	public void run(Configuration configuration, Environment environment) throws Exception {
		// TODO Auto-generated method stub
		final FilterRegistration.Dynamic cor = environment.servlets().addFilter("COR", CrossOriginFilter.class);
		
		cor.setInitParameter("allowedOrigins", "*");
		cor.setInitParameter("allowedHeaders", "X-Requested-With, Content-Type, Accept, Origin");
		cor.setInitParameter("allowedMethods", "OPTIONS, GET, PUT, POST, DELETE, HEAD");
		cor.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());
		cor.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		
		final FibonacciResource resource = new FibonacciResource();
		environment.jersey().register(resource);
	}

}
