package com.landonhotel.reservations.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@Configuration
@CrossOrigin
@EnableWebFlux
public class ApiConfig implements WebFluxConfigurer
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@Bean
	public ObjectMapper objectMapper()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(
			SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

		return objectMapper;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param   objectMapper
	 * @return
	 */
	@Bean
	public ObjectWriter objectWriter(ObjectMapper objectMapper)
	{
		return objectMapper.writerWithDefaultPrettyPrinter();
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@Bean
	public WebFluxConfigurer corsConfigurer()
	{
		return new WebFluxConfigurerComposite()
		{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}
}
