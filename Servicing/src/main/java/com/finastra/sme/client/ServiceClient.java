package com.finastra.sme.client;




import org.reactivestreams.Publisher;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("http://localhost:8080")
public interface ServiceClient {
	
	@Get("/servicing/loan")
	String getOnboardingLoan();

}
