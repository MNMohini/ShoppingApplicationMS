package com.niit.jdp.UserAuthenticateServices;

import com.niit.jdp.UserAuthenticateServices.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserAuthenticateServicesApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UserAuthenticateServicesApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/*");
		return filterRegistrationBean;
	}

}
