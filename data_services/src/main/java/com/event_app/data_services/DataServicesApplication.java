package com.event_app.data_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataServicesApplication.class, args);
	}
	
	@Bean
	public static JaegerTracer getTracer() {
		Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
    	Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
    	Configuration config = new Configuration("Data Service").withSampler(samplerConfig).withReporter(reporterConfig);
    	return config.getTracer();
	}

}
