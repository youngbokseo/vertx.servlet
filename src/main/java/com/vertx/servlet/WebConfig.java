package com.ntels.cep;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebConfig {


	@Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
       RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();

       //requestMappingHandlerMapping.setInterceptors(getInterceptors());
     
       return requestMappingHandlerMapping;
    }

	@Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
		requestMappingHandlerAdapter.setMessageConverters(httpMessageConverters(requestMappingHandlerAdapter.getMessageConverters()));
       return requestMappingHandlerAdapter;
    }

	public List<HttpMessageConverter<?>> httpMessageConverters(List<HttpMessageConverter<?>> converters){
		if(converters == null) converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		return converters;
	}
		
}
