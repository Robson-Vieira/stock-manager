package com.StockManager.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Stock Manager",
                version = "1.0",
                description = "O Stock Manager tem o objetivo de te auxiliar a gerenciar seu estoque da melhor maneira possível"

        )
)
public class SwaggerConfig {
}
