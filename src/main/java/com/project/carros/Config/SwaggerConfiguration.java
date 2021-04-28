package com.project.carros.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    
	private static final String BASE_PACKAGE = "com.project.carros";
	private static final String TITLE_API = "Automoveis Manager api information";
	private static final String DESCRITION_API = "Api de gerenciamento de informações de automoveis";
	private static final String NAME_AUTHOR = "Mario junior";
	private static final String VERSION_API = "1.0.0";
	private static final String ENDERECO_GITHUB = "https://github.com/Mario23junior";
	private static final String EMAIL_API = "mariojunior3251@gmail.com";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
			    .build()
		        .apiInfo(SelectInfo());
	}

	private ApiInfo SelectInfo() {
 		return new ApiInfoBuilder()
 				.title(TITLE_API)
 				.description(DESCRITION_API)
 				.version(VERSION_API)
 				.contact(new Contact(NAME_AUTHOR,ENDERECO_GITHUB, EMAIL_API))
 				.build();
 		
	}
} 