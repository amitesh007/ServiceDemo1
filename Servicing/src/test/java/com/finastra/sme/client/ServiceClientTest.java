package com.finastra.sme.client;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
class ServiceClientTest {
	
	
	@Inject
    EmbeddedApplication<?> application;
	
	@Inject
	@Client("/") ServiceClient client;
	
	@Test
	void testAll() {
		Assertions.fail("Not yet implemented");
	}

	@Test
	void testGetOnboardingLoan() {
		final String result = client.getOnboardingLoan();
		System.out.println("getOnboardingLoan: "+result.toString());
	}

}
