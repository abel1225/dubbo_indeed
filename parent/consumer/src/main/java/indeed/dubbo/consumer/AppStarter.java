package indeed.dubbo.consumer;

import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;
import java.util.concurrent.*;

/**
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2020-01-21
 * @version 
 */
//@SpringBootApplication
public class AppStarter {

    public static void main( String[] args ) {
//        SpringApplication.run(AppStarter.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();
        GeneratedService demoService =context.getBean(GeneratedService.class);
        long start = System.currentTimeMillis();
//        ExecutorService service = new ThreadPoolExecutor(100, 100,
//                60L, TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(), r -> new Thread(r, "测试"));
//        int count=1000;
//        int amount=1000;
//        CountDownLatch countDownLatch = new CountDownLatch(count);
//        for (int i=0; i < amount; i++) {
//            service.execute(
//                    () -> {
//                        try {
//                            ResultDto<Long> hello = demoService.getId("test");
//                            System.out.println("线程[" + Thread.currentThread().getId() + "] 获取响应的ID为: " + hello.getData());
//                        } finally {
//                            countDownLatch.countDown();
//                        }
//                    });
//        }
//        service.shutdown();
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ResultDto<Long> hello = demoService.getId("test");
        long end = System.currentTimeMillis();
        System.out.println("获取到的ID: " + hello.getData());
        System.out.println("消耗时间: " + (end - start));
//        Main.main(args);

    }
}
