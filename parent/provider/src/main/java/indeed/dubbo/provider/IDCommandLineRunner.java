package indeed.dubbo.provider;

import indeed.dubbo.provider.service.MysqlGeneratedService;
import indeed.dubbo.provider.service.RedisGeneratedService;
import indeed.dubbo.provider.service.SnowFlakesGeneratedService;
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
    @Autowired
    private RedisGeneratedService redisGeneratedService;
    @Autowired
    private SnowFlakesGeneratedService snowFlakesGeneratedService;

    @Override
    public void run(String... args) {
        System.out.println("mysql id: " + mysqlGeneratedService.getId("test").getData());
        System.out.println("redis id: " + redisGeneratedService.getId("test").getData());
        System.out.println("snow id: " + snowFlakesGeneratedService.getId("test").getData());
    }
}
