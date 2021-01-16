package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

// 线上打包加继承加父类方法 本地注释
//extends SpringBootServletInitializer
@SpringBootApplication
public class AixuexiApplication extends SpringBootServletInitializer{
	private static Logger logger = LoggerFactory.getLogger(AixuexiApplication.class);
	/**
	 * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AixuexiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AixuexiApplication.class, args);
	}

}
