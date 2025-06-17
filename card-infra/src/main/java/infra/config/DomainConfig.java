package infra.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import core.application.CardService;
import core.domain.DomainService;

@Configuration
@ComponentScan(basePackageClasses = { CardService.class }, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { DomainService.class }) })
public class DomainConfig {

}
