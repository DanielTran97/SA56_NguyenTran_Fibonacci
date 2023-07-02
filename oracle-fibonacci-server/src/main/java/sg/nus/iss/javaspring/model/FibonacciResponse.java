package sg.nus.iss.javaspring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FibonacciResponse {
	List<Integer> Fibonacci;
	List<Integer> SortedFibonacci;
	
	//Serialize the response to a JSON Format
	
	@JsonProperty
	public List<Integer> getFibonacci() {
		return this.Fibonacci;
	}
	@JsonProperty
	public List<Integer> getSortedFibonacci() {
		return this.SortedFibonacci;
	}
	
}
