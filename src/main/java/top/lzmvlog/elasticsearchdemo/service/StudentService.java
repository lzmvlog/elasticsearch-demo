package top.lzmvlog.elasticsearchdemo.service;

import top.lzmvlog.elasticsearchdemo.model.Student;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月03日 09:27
 * @Description:
 */
public interface StudentService {

    /**
     * 新增
     *
     * @param student 学生信息
     * @return
     */
    Integer save(Student student);
}
