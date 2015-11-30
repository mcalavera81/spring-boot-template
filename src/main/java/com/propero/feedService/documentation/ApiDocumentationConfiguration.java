package com.propero.feedService.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by farid on 30/11/15.
 */
@Configuration
@EnableSwagger2 //Enable swagger 2.0 spec
public class ApiDocumentationConfiguration {

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api/.*"))
                .build()
                .pathMapping("/")
                .apiInfo(metadata());
    }



    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("My awesome API")
                .description("Some description")
                .version("1.0")
                .contact("my-email@domain.org")
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }

}
