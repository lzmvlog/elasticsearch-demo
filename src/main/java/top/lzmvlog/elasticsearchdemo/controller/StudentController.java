package top.lzmvlog.elasticsearchdemo.controller;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lzmvlog.elasticsearchdemo.model.Student;
import top.lzmvlog.elasticsearchdemo.repository.StudentRepository;
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

    private final StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    @Autowired
//    private StudentService studentService;

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
        // 缓存 存放主健一致时 覆盖原因的值 可以用于修改
        studentRepository.save(student);
        return new R(HttpStatus.OK.value());
    }

    /**
     * 查询
     *
     * @return
     */
    @GetMapping("selectById")
    public Optional<Student> selectById(Integer id) {
        return studentRepository.findById(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("select")
    public Iterable<Student> select() {
        // 展示不支持 lambdas 表达式
        // 倒叙查找
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return studentRepository.findAll(sort);
    }

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("selectPage")
    public Page<Student> selectPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    /**
     * 根据名称模糊查询
     *
     * @return
     */
    @GetMapping("selectAllByName")
    public List<Student> selectAllByName(String name) {
        return studentRepository.findAllByNameLike(name);
    }

    /**
     * 按照年龄查询
     *
     * @param age 年龄
     * @return
     */
    @GetMapping("selectAllByAge")
    public List<Student> selectAllByAge(Integer age) {
        Slice<Student> studentSlice = studentRepository.findTopByAgeGreaterThan(age);
        return studentSlice.getContent();
    }

    /**
     * 删除全部
     *
     * @return
     */
    @GetMapping("delete")
    public R delete() {
        studentRepository.deleteAll();
        return new R(HttpStatus.OK.value());
    }

    /**
     * 删除
     *
     * @return
     */
    @GetMapping("deleteById")
    public R deleteById(Integer id) {
        studentRepository.deleteById(id);
        return new R(HttpStatus.OK.value());
    }

//    ----------------

    /**
     * 原生方法执行 term
     *
     * @return
     */
    public R searchselect(Pageable pageable) {
        // 原生操作 主要是 QueryBuilders操作
        return new R(HttpStatus.OK.value(),
                studentRepository.search(QueryBuilders.termQuery("name", "s"), pageable));
    }
}
