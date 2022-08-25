package com.xiaofengstu.demoasync.conf;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ExecutorConfig
 * @Author fengzeng
 * @Date 2022/8/8 0008 15:27
 */
@Configuration
@ConfigurationProperties(prefix = "aa")
@Data
public class ExecutorConfig {
  /**
   * 核心线程
   */
  private int coreSize;
  /**
   * 最大线程
   */
  private int maxSize;
  /**
   * 队列容量
   */
  private int queueCapacity;
  /**
   * 保持时间
   */
  private int keepAlive;
  /**
   * 名称前缀
   */
  private String prefix;


  @Bean("myExecutor")
  public Executor myExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(coreSize);
    executor.setMaxPoolSize(maxSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setKeepAliveSeconds(keepAlive);
    executor.setThreadNamePrefix(prefix);
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
    executor.initialize();
    return executor;
  }
}
