package cn.demo.dao;

import cn.demo.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 57251180@qq.com
 * Date: 1/6/2020
 */
@Mapper
public interface UserMapper {
    List<User> selectAll();

    User findUserById(String id);

    void updateUser(User user);

    @MapKey("id")
    Map<String,Object> mapFind();

    @MapKey("username")
    Map<String, User> getUserInfoMap();

    List<User>dynamicForeach(Integer[] ids);
}
