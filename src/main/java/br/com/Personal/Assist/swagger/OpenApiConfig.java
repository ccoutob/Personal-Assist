package br.com.Personal.Assist.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

//Utilize "http://localhost:8080/swagger-ui/index.html" para acessar nossa documentação com swagger

@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "Personal Assist", email = "personal@fiap.com.br"),
                title = "FIAP Personal Assist",
                description = "Sistema de recomendação com autenticação e documentação do sistema",
                version = "1.0"),
        servers = @Server(url = "http://localhost:8080"),
        security = @SecurityRequirement(name = "personalJwt")
)
@SecurityScheme(
        name = "personalJwt",
        description = "Segurança JWT",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
