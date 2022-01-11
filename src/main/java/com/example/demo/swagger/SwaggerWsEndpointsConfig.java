package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerWsEndpointsConfig
{
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            SwaggerResource wsResource = new SwaggerResource();
            wsResource.setName("ws endpoints");
            wsResource.setSwaggerVersion("3.0");
            wsResource.setLocation("/static/swagger.yml");

            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.add(wsResource);
            return resources;
        };
    }
}
