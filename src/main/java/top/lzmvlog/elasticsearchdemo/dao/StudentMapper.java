package top.lzmvlog.elasticsearchdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lzmvlog.elasticsearchdemo.model.Student;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2020年12月03日 20:48
 * @Description:
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
