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

        ExecutorService service = new ThreadPoolExecutor(100, 100,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), r -> new Thread(r, "测试"));
        long start = System.currentTimeMillis();
        int count=1000;
        int amount=1000;
        CountDownLatch mainCountDownLatch = new CountDownLatch(amount*count);
        for (int i=0; i < amount; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            for (int j=0; j < count; j++) {
                service.execute(new Worker(countDownLatch, mainCountDownLatch, demoService));
            }
            countDownLatch.countDown();
        }
        service.shutdown();
        try {
            mainCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ResultDto<Long> hello = demoService.getId("test");
        long end = System.currentTimeMillis();
//        System.out.println("获取到的ID: " + hello.getData());
        System.out.println("消耗时间: " + (end - start));
//        Main.main(args);

    }

    static class Worker implements Runnable {

        private CountDownLatch startGate;
        private CountDownLatch endGate;
        private GeneratedService demoService;

        public Worker(CountDownLatch startGate, CountDownLatch endGate, GeneratedService demoService) {
            this.startGate=startGate;
            this.endGate=endGate;
            this.demoService=demoService;
        }

        @Override
        public void run() {
            try {
                startGate.await();
                ResultDto<Long> hello = demoService.getId("test");
                System.out.println("线程[" + Thread.currentThread().getId() + "] 获取响应的ID为: " + hello.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
            }
        }
    }
}
