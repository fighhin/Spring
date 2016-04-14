package com.somnus.resource;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.domain.Request;
import com.somnus.domain.Response;
import com.somnus.rest.core.client.RESTfulJsonClientFactory;

public class SpringTest extends AbstractTestSupport {
	
	private static final String BASE_URL = "http://120.26.68.243:8080/restful/service/";
	
	RestfulResource resource = RESTfulJsonClientFactory.createClient(RestfulResource.class, BASE_URL);
	@Test
	public void rest(){
		
		Response response = resource.getAccount(new Request("admin","123456"));
		
		System.out.println(response);
	}
	
}
