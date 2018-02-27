package com.redhat.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

	@Override
    public void configure() {
		this.getContext().setStreamCaching(true);
		
		restConfiguration().component("undertow").port("8080").bindingMode(RestBindingMode.json).apiContextPath("api-doc").enableCORS(true);
		
        rest()
            .get("/balance")
                .description("Remaining balance of the user")
                .param()
                    .name("sender")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(true)
                    .description("Identification number")
                .endParam()
                .to("direct:balance")
            .post("/payment")
                .description("Place payment request")
                .param()
                    .name("sender")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(true)
                    .description("Identification number")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(false)
                    .description("Payment details")
                .endParam()
                .to("direct:payment");
    }
}
