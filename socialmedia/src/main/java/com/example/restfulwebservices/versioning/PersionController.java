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
	
	
	@GetMapping(path = "/persion", params = "version=1")
	public Persion1 getFirstPersionRequestParam() {
		return new Persion1("Pradeep Patidar");
	}
	

	@GetMapping(path = "/persion", params = "version=2")
	public Persion2 getSecondPersionRequestParam() {
		return new Persion2(new Name("pradeep", "patidar"));
	}
	
	@GetMapping(path = "/persion/header", headers = "X-API-VERSION=1")
	public Persion1 getFirstPersionRequestHeaders() {
		return new Persion1("Pradeep Patidar");
	}
	
	@GetMapping(path = "/persion/header", headers = "X-API-VERSION=2")
	public Persion2 getSecondPersionRequestHeadrs() {
		return new Persion2(new Name("pradeep", "patidar"));
	}
	
	@GetMapping(path = "/persion/accept", produces =  "application/vnd.company.app-v1+json")
	public Persion1 getFirstPersionAcceptHeaders() {
		return new Persion1("Pradeep Patidar");
	}
	
	@GetMapping(path = "/persion/accept", produces ="application/vnd.company.app-v2+json")
	public Persion2 getSecondPersionAcceptHeadrs() {
		return new Persion2(new Name("pradeep", "patidar"));
	}
}
