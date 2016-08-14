package com.prem.mvc.web.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Date:   14/8/16 / 1:10:04 PM (SGT)
 * Author: Prem Kumar
 * <p/>
 * Comments:
 * <p/>
 * This is a VERY basic Spring Config setup for a web apps
 */

@Configuration
@PropertySource("file:${env}/env.properties")
@EnableWebMvc
@ComponentScan(basePackages = {"com.prem.mvc.web"})
public class WebMVCConfig extends WebMvcConfigurerAdapter
{

    private static final Logger logger = LoggerFactory.getLogger(WebMVCConfig.class);
    
    @Autowired
	private Environment env;

	public Environment getEnvironment() {
		return env;
	}

    @Bean
    public ViewResolver resolver()
    {
        UrlBasedViewResolver url = new UrlBasedViewResolver();
        url.setPrefix("/views/");
        url.setViewClass(JstlView.class);
        url.setSuffix(".jsp");
        return url;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        logger.debug("setting up resource handlers");
        registry.addResourceHandler("/resources/").addResourceLocations("/resources/**");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        logger.debug("configureDefaultServletHandling");
        configurer.enable();
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
    {
        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.put("org.springframework.web.servlet.PageNotFound", "p404");
        mappings.put("org.springframework.dao.DataAccessException", "dataAccessFailure");
        mappings.put("org.springframework.transaction.TransactionException", "dataAccessFailure");
        b.setExceptionMappings(mappings);
        return b;
    }
}
