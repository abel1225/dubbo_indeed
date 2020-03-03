package indeed.dubbo.provider.service;

import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2020-01-21
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(version = "3.0", timeout = 3000, interfaceClass=GeneratedService.class, retries=0)
public class SnowFlakesGeneratedService implements GeneratedService {

    @Autowired
    private SnowflakeService snowflakeService;

    @Override
    public Optional<ResultDto<Long>> getId(String salt) {
        return Optional.of(new ResultDto<Long>().setData(snowflakeService.getInstance().nextId()));
    }

}
