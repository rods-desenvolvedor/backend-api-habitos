package com.rods.todo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    public OpenAPI customOpenApi()
    {
        return new OpenAPI().info(new Info()
            .title("Habitos API")
            .version("1.0")
            .description("API para gerenciamento de habitos")
        );   
    }
    
}
