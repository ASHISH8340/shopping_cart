package com.demo.shopping.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
                .info(new Info().title("Shopping Cart")
                        .description("AmitLogic application")
                        .version("3.0").license(new License().name("Apache 2.0")
                                .url("www.amitlogic.com")))
                .externalDocs(new ExternalDocumentation().description("Shopping Cart Documentation")
                        .url("https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-controller-layer-91bb4099c2a5"));
    }

}

//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("SpringShop API")
//                        .description("Spring shop sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("SpringShop Wiki Documentation")
//                        .url("https://springshop.wiki.github.org/docs"));
//    }
