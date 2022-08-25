package com.xiaofengstu.demoasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author fengzeng
 */
@EnableAsync
@SpringBootApplication
public class DemoAsyncApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoAsyncApplication.class, args);
  }

}
