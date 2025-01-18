package com.learning.swaggeropenapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Doc").version("1.0.0").description("API Doc"));
    }

    /**
     * Defines a custom operation customizer bean.
     * <p>
     * This method customizes Swagger operations by adding a required header parameter named "header-param"
     * to the operation's parameters.
     *
     * @return An instance of OperationCustomizer for Swagger customization.
     */
    @Bean
    public org.springdoc.core.customizers.OperationCustomizer customize() {
        return (operation, handlerMethod) -> operation.addParametersItem(
                new Parameter()
                        .in("header")
                        .required(true)
                        .description("header-param")
                        .name("header-param"));
    }
}
