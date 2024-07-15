package com.example.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersionController {
	
	@GetMapping("/v1/persion")
	public Persion1 getFirstPersion() {
		return new Persion1("Pradeep Patidar");
	}

	
	@GetMapping("/v2/persion")
	public Persion2 getSecondPersion() {
		return new Persion2(new Name("pradeep", "patidar"));
	}
}
