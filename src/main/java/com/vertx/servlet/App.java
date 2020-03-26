package com.vertx.servlet;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;



/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@ComponentScan("com.ntels.cep")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class App {
	public static void main(String[] args) {
		
		
		SpringApplication.run(App.class, args);
	}

	@Bean
	public Executor asyncThreadTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(8);
		threadPoolTaskExecutor.setMaxPoolSize(8);
		threadPoolTaskExecutor.setThreadNamePrefix("jeong-pro-pool");
		return threadPoolTaskExecutor;
	}

}
