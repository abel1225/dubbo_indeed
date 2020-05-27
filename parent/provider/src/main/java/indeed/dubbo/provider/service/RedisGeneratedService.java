package indeed.dubbo.provider.service;

import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import indeed.dubbo.provider.component.RedisUtil;
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
@com.alibaba.dubbo.config.annotation.Service(version = "2.0", timeout = 3000, interfaceClass=GeneratedService.class, retries=0)
public class RedisGeneratedService implements GeneratedService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public ResultDto<Long> getId(String salt) {
        long incr=redisUtil.incr("INCR", 1L);
        System.out.println(incr);
        return new ResultDto<Long>().setData(incr);
    }

}
