package indeed.dubbo.provider.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "tbl_sequence")
public class SequenceEntity implements Serializable {

	/**
	 *
	 */
	@Id
	@Column(name = "id")
	private Long id;

    /**
     * sequence
	 */
	@Column(name = "ssn")
	private Long ssn;

}
