package top.lzmvlog.elasticsearchdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.lzmvlog.elasticsearchdemo.repository.CacheRepository;
import top.lzmvlog.elasticsearchdemo.model.Student;

@SpringBootTest
class ElasticsearchDemoApplicationTests {

    @Autowired
    private CacheRepository<S, Number> studentRepository;

    @Test
    void contextLoads() {
        Student student = new Student();
        student.setId(3);
        student.setName("lzmvlog");
        student.setAge(21);
        studentRepository.save(student);
    }

    @Test
    void test(){
        Iterable<Student> all = studentRepository.findAll();
        System.out.println(all);
    }

}
