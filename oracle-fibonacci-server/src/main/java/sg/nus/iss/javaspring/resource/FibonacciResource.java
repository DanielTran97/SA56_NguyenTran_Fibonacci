package sg.nus.iss.javaspring.resource;

import org.springframework.http.MediaType;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.jersey.params.IntParam;
import lombok.NoArgsConstructor;
import sg.nus.iss.javaspring.model.FibonacciResponse;
import sg.nus.iss.javaspring.util.FibonacciCalculator;

import javax.ws.rs.*;

@NoArgsConstructor
@Produces("application/json")
public class FibonacciResource {
	@GET
	@Timed
	@Consumes("application/json")
	public FibonacciResponse getPayLoad(@QueryParam("integer") IntParam num) {
		return FibonacciCalculator.getFibonacci(num.get());
	}
}
