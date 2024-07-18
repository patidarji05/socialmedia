package com.example.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3");
	}

	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		
		return Arrays.asList(new SomeBean("Value1", "Value2", "Value2"),
				new SomeBean("Value4", "Value5", "Value6"));
	}
}
