package com.xiaofengstu.demoasync.controller;

import com.xiaofengstu.demoasync.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName AsyncController
 * @Author fengzeng
 * @Date 2022/8/8 0008 15:51
 */
@RestController
public class AsyncController {


  @Resource(name = "asyncService")
  private AsyncService asyncService;


  @GetMapping("/async")
  public String asyncExecute() throws ExecutionException, InterruptedException {
    System.out.println("start async call");
    long l1 = System.currentTimeMillis();
    Future<String> job1 = asyncService.job1();
    Future<String> job2 = asyncService.job2();
    Future<String> job3 = asyncService.job3();
    System.out.println("main thread execute");
    System.out.println("task:" + job1.get());
    System.out.println("task:" + job2.get());
    System.out.println("task:" + job3.get());

    long l2 = System.currentTimeMillis();

    System.out.println("cost time :" + (l2 - l1));

    return "success";
  }
}
