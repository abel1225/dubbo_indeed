package indeed.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2020-01-21
 * @version 
 */
//@EnableDubboConfig
//@SpringBootApplication
public class AppStarter {

    public static void main( String[] args ) {
//        SpringApplication.run(AppStarter.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();
        GeneratedService demoService =context.getBean(GeneratedService.class);
        ResultDto<Long> hello = demoService.getId("test");
        System.out.println(hello.getData());
    }
}
