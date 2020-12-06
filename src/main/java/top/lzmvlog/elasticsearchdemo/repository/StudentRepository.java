package top.lzmvlog.elasticsearchdemo.repository;

import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;
import top.lzmvlog.elasticsearchdemo.model.Student;

import java.util.List;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月06日 23:12
 * @Description:
 */
@Repository
public interface StudentRepository extends CacheRepository<Student, Integer> {

    /**
     * 模糊查询所有学生名称
     *
     * @param name 名称
     * @return
     */
    @Override
    List<Student> findAllByNameLike(String name);

    /**
     * 查询年龄大学生信息
     *
     * @param age 年龄
     * @return
     */
    @Override
    Slice<Student> findTopByAgeGreaterThan(Integer age);
}
