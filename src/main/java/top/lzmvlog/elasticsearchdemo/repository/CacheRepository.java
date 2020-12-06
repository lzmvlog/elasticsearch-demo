package top.lzmvlog.elasticsearchdemo.repository;

import org.springframework.data.domain.Slice;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;
import top.lzmvlog.elasticsearchdemo.model.Student;

import java.util.List;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月02日 15:59
 * @Description:
 */
//@Repository
@NoRepositoryBean
public interface CacheRepository<S, I extends Number> extends ElasticsearchRepository<S, I> {

    /**
     * 接口类注解：
     * @NoRepositoryBean
     * 确保将注释添加到所有存储库接口，Spring Data不应在运行时为其创建实例。
     *
     * Resulting:
     * springboot不会为其自动创建 bean
     *
     * Parameter 0 of constructor in top.lzmvlog.elasticsearchdemo.controller.StudentController required a bean of type
     * 'top.lzmvlog.elasticsearchdemo.repository.CacheRepository' that could not be found.
     */

    /**
     * 模糊查询所有学生名称
     *
     * @param name 名称
     * @return
     */
    List<Student> findAllByNameLike(String name);


    /**
     * 查询年龄大学生信息
     *
     * @param age 年龄
     * @return
     */
    Slice<Student> findTopByAgeGreaterThan(Integer age);

    /**
     * 查询
     * 1、从方法名查询创建
     *  关键字：AND
     *          OR
     *          Between
     *          LessThan 小于
     *          GreaterThan 大于
     *          Like 模糊
     *          IgnoreCase 不区分大小写
     *          OrderBy 排序
     *          Asc 正序
     *          Desc 倒叙
     *
     * 2、属性表达式
     * 例：
     * List<Student> findByUserName(String userName);
     * Resulting：
     * UserName可能会被拆分成 user 、name 两个字段,一定概率!!!
     *
     * 下划线字符视为保留字符，所以我们强烈建议您遵循标准的Java命名约定（即，在属性名称中不使用下划线，而使用驼峰大小写）。
     * 即：List<Student> findBy_UserName(String userName);
     *
     * 3、特殊参数处理
     *      Pageable，Slice和Sort
     *  注：
     *  Pageable 可以用于返回分页信息
     *  Slice 可以用于返回一个集合对象 Slice<Student> 并通过 hasNext() 方法判断是否具有下一个数据 从而进行下一次查询
     *  Sort 排序
     *
     *  Sort sort = Sort.by("id").ascending().and(Sort.by("age").descending());
     *
     *  TypedSort<Student> student = Sort.sort(Student.class);
     *  Sort sort = student.by(Student::getId).ascending().and(student.by(Student::getAge).descending());
     *  TypedSort.by(…) 通过（通常）使用CGlib使用运行时代理，这在使用Graal VM Native等工具时可能会干扰本机映像编译。
     *
     *
     */
}

