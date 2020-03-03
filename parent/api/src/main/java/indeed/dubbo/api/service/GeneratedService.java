package indeed.dubbo.api.service;

import indeed.dubbo.api.dto.ResultDto;

import java.util.Optional;

/**
 * @description
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2020-01-21
 * @version
 */
public interface GeneratedService {

    /**
     * 获取唯一ID
     * @param salt 盐
     * @return
     */
    Optional<ResultDto<Long>> getId(String salt);

}
