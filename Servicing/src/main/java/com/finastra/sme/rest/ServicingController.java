package com.finastra.sme.rest;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/servicing")
public class ServicingController {
	
	@Get("/")
	public String getOnboardingLoan() {
		return "get onboarding loan details";
	}

}
