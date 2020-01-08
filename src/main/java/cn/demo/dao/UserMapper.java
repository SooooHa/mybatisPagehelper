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

    /**
     * 以username为主键的查询
     * @return
     */
    @MapKey("username")
    Map<String, User> getUserInfoMap();


    /**
     * 动态sql语句查询
     * @param ids
     * @return
     */
    List<User> dynamicForeach (Integer[] ids);


    /**
     * 模糊查询
     * @param gender
     * @return
     */
    List<User> fuzzyQueryBySex (String gender);

    /**
     * 两个表连接查询
     * @return
     */
    List<Map<String,Object>> selectTwoTable();





}
