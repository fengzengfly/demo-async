package com.xiaofengstu.demoasync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ClassName AsyncService
 * @Author fengzeng
 * @Date 2022/8/8 0008 15:52
 */
@Service("asyncService")
public class AsyncService {


  @Async("myExecutor")
  public Future<String> job1() {
    System.out.println(Thread.currentThread().getName() + " executing ");
    return new AsyncResult<>("job1 done");
  }

  @Async("myExecutor")
  public Future<String> job2() {
    System.out.println(Thread.currentThread().getName() + " executing ");
    return new AsyncResult<>("job2 done");
  }

  @Async("myExecutor")
  public Future<String> job3() {
    System.out.println(Thread.currentThread().getName() + " executing ");
    return new AsyncResult<>("job3 done");
  }
}
