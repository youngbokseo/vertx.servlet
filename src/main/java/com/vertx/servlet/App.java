package com.ntels.cep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ntels.cep.common.test.CommonQueue;
import com.ntels.cep.common.test.MonitorServer;


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
		ExecutorService executorService = Executors.newFixedThreadPool(1);
        MonitorServer ms = new MonitorServer(new CommonQueue());
		executorService.execute(ms);
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
