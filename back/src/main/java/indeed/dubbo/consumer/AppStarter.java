package indeed.dubbo.consumer;

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
//@SpringBootApplication
public class AppStarter {

    public static void main( String[] args ) {
//        SpringApplication.run(AppStarter.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-indeed.dubbo.consumer.xml");
        context.start();
        GeneratedService demoService =context.getBean(GeneratedService.class);
        ResultDto<Long> hello = demoService.getId("test");
        System.out.println(hello.getData());
//        Main.main(args);

    }
}
