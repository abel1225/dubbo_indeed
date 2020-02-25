package indeed.dubbo.provider.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2020-02-19
 * @version 
 */
@Data
@Entity
@Component
@Table(name = "tbl_increment")
public class IncrementEntity implements Serializable {

	/**
	 *
	 */
	@Id
	@Column(name = "ssn_name")
	private String name;

    /**
     * sequence
	 */
	@Column(name = "ssn")
	private Long ssn;

}
