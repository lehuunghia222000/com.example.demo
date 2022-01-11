package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "app.swagger.enabled", havingValue = "true")
public class SwaggerConfig {
  @Bean
  Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  @Primary
  @Component
  public class CustomSwaggerResourcesProvider implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
      SwaggerResource wsResource = new SwaggerResource();
      wsResource.setName("Student Application");
      wsResource.setSwaggerVersion("3.0");
      wsResource.setLocation("/swagger.yaml");
          return Collections.singletonList(wsResource);
    }
  }

}
