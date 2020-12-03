package top.lzmvlog.elasticsearchdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lzmvlog.elasticsearchdemo.dao.CacheRepository;
import top.lzmvlog.elasticsearchdemo.model.Student;
import top.lzmvlog.elasticsearchdemo.service.StudentService;
import top.lzmvlog.elasticsearchdemo.util.R;

import java.util.List;
import java.util.Optional;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月03日 13:32
 * @Description:
 */
@RestController
public class StudentController {

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private StudentService studentService;

    /**
     * 新增
     *
     * @param student
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody Student student) {
        // 持久层
//        studentService.save(student);
        // 缓存
        cacheRepository.save(student);
        return new R(HttpStatus.OK);
    }

    /**
     * 查询
     *
     * @return
     */
    @GetMapping("selectById")
    public Optional<Student> selectById(Integer id) {
        return cacheRepository.findById(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("select")
    public Iterable<Student> select() {
        return cacheRepository.findAll();
    }

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("selectPage")
    public Page<Student> selectPage(Pageable pageable) {
        return cacheRepository.findAll(pageable);
    }

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("selectAllByName")
    public List<Student> selectAllByName(String name) {
        // 搜索源构建器
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query();

//        QueryBuilder queryBuilder = new QueryStringQueryBuilder();
//        queryBuilder.queryName()

//        return cacheRepository.search(new QueryStringQueryBuilder("name").field("4"), pageable);

        return cacheRepository.findAllByNameLike(name);
    }

    /**
     * 删除全部
     *
     * @return
     */
    @GetMapping("delete")
    public R delete() {
        cacheRepository.deleteAll();
        return new R(HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @return
     */
    @GetMapping("deleteById")
    public R deleteById(Integer id) {
        cacheRepository.deleteById(id);
        return new R(HttpStatus.OK);
    }

}
