package indeed.dubbo.provider;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2020-01-21
 */

@EnableDubboConfiguration
@SpringBootApplication
//@EnableDubboConfig
//@ImportResource("dubbo-provider.xml")
public class AppStarter {

    public static void main(String[] args) throws InterruptedException {
//        Main.main(args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        // 注册当前配置 Bean
//        context.register(DubboConfig.class);
//        context.refresh();
        new EmbeddedZooKeeper(2281, false).start();
        Thread.sleep(1000);

        SpringApplication.run(AppStarter.class, args);
    }

}
