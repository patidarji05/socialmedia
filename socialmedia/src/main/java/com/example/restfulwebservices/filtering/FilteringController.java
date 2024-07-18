package com.example.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	// static filtering   
	
	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3");
	}

	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		
		return Arrays.asList(new SomeBean("Value1", "Value2", "Value2"),
				new SomeBean("Value4", "Value5", "Value6"));
	}
	
	// dynamic filtering
	
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue filteringDynamic() {
		SomeBeanDynamic someBean = new SomeBeanDynamic("value1", "value2", "value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFiletr", filter );
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

	
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue filteringListDynamic() {
		List<SomeBeanDynamic> asList = Arrays.asList(new SomeBeanDynamic("Value1", "Value2", "Value2"),
				new SomeBeanDynamic("Value4", "Value5", "Value6"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed3","filed2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFiletr", filter );
		mappingJacksonValue.setFilters(filterProvider );
		
		return mappingJacksonValue;
	}
}
