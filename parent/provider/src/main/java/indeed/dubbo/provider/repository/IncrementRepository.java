package indeed.dubbo.provider.repository;

import indeed.dubbo.provider.entity.IncrementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2020-02-21
 * @version 
 */
@Repository
public interface IncrementRepository extends JpaRepository<IncrementEntity, String> {

    /**
     * 获取序列号
     * @param name
     * @return
     */
    @Query("select ssn from IncrementEntity where name = ?1")
    Long getIncrementEntityByName(String name);
}
