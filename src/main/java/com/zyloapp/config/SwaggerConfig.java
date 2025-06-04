package com.zyloapp.config;

import org.springframework.context.annotation.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(info = @Info(title = "ZyloApp API", version = "1.0"))
@Configuration
public class SwaggerConfig {}
