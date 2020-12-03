package top.lzmvlog.elasticsearchdemo.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月02日 15:46
 * @Description:
 */
@Data
@Document(indexName = "student", type = "_doc")
public class Student implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

}
