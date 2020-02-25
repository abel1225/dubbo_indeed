package indeed.dubbo.provider.service;

import indeed.dubbo.provider.component.Snowflake;
import org.springframework.stereotype.Service;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2020-02-24
 */
@Service
public class SnowflakeService {

    private static volatile Snowflake instance;

    public Snowflake getInstance() {
        if (instance == null) {
            synchronized (Snowflake.class) {
                if (instance == null) {
//                    log.info("when instance, workId = {}, datacenterId = {}", workId, datacenterId);
//                    instance = new Snowflake(workId, datacenterId);
                    instance = new Snowflake(1, 1);
                }
            }
        }
        return instance;
    }
}
