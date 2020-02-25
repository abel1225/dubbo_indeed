package indeed.dubbo.provider.service;

import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2020-01-21
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(version = "1.0", timeout = 3000, interfaceClass=GeneratedService.class, retries=0)
public class MysqlGeneratedService implements GeneratedService {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
    public ResultDto<Long> getId(String salt) {
        Query query = entityManager.createNativeQuery("select getSeq('"+salt+"')");
        Object singleResult=query.getSingleResult();
        if (null == singleResult) {
            throw new RuntimeException("id get failure!");
        }
        Long id = Long.valueOf(singleResult.toString());

        return new ResultDto<Long>().setData(id);
    }

}
