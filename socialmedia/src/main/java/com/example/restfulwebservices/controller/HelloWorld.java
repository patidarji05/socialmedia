package com.example.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	private MessageSource messageSource;

	public HelloWorld(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/hello-wold-i18n")
	public String helloWorldInternationalized() {

		Locale locale = LocaleContextHolder.getLocale();
	return 	messageSource.getMessage("good.morning.message" , null, "Defult message", locale);
	//	return "Hello Pradeep";
	}

}
