package indeed.dubbo.provider.service;

import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import indeed.dubbo.provider.component.Snowflake;
import org.springframework.stereotype.Component;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2020-01-21
 */
@Component
@com.alibaba.dubbo.config.annotation.Service(version = "3.0", timeout = 3000, interfaceClass=GeneratedService.class, retries=0)
public class SnowFlakesGeneratedService implements GeneratedService {

    @Override
    public ResultDto<Long> getId(String salt) {
        return new ResultDto<Long>().setData(new Snowflake(1L,1L).nextId());
    }

}
