package indeed.dubbo.provider;

import indeed.dubbo.provider.service.MysqlGeneratedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2019-10-10
 * @version 
 */
@Configuration
public class IDCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MysqlGeneratedService mysqlGeneratedService;

    @Override
    public void run(String... args) {
        System.out.println("id: " + mysqlGeneratedService.getId("test").getData());
    }
}
