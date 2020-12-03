package top.lzmvlog.elasticsearchdemo.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import top.lzmvlog.elasticsearchdemo.model.Student;

import java.util.List;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月02日 15:59
 * @Description:
 */
@Repository
public interface CacheRepository extends ElasticsearchRepository<Student, Integer> {

    /**
     * 模糊查询所有学生名称
     *
     * @param name 名称
     * @return
     */
    List<Student> findAllByNameLike(String name);

}
