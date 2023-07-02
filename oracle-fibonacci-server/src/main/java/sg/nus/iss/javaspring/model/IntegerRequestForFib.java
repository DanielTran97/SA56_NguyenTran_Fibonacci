package sg.nus.iss.javaspring.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Utilizing lombok to skip typing the necessary constructors as well as getter/setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntegerRequestForFib {
	@NotNull
	@Min(1)
	@Max(100)
	private Integer integer;
	
}
