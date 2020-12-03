package top.lzmvlog.elasticsearchdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lzmvlog.elasticsearchdemo.dao.StudentMapper;
import top.lzmvlog.elasticsearchdemo.model.Student;
import top.lzmvlog.elasticsearchdemo.service.StudentService;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月03日 20:49
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 新增
     *
     * @param student 学生信息
     * @return
     */
    @Override
    public Integer save(Student student) {
        return studentMapper.insert(student);
    }
}
