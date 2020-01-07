package cn.demo;

import cn.demo.bean.User;
import cn.demo.dao.UserMapper;
import cn.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 57251180@qq.com
 * Date: 1/6/2020
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    UserMapper userMapper;


    @Autowired
    UserService userService;

    @Test
    public void pageTest(){
        List<User> users = userService.pageAll(2,3);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findByIdTest(){
        User user = userService.findUserById("3");
        System.out.println(user);
    }

    @Test
    public void updateById(){
        User user = userMapper.findUserById("1");
        user.setSex("male");
        userMapper.updateUser(user);
    }

    @Test
    public void selectMap(){
        Map<String, Object> map = userMapper.mapFind();
        System.out.println(map);
    }


 @Test
    public void selectMap2(){
     Map<String, User> userInfoMap = userMapper.getUserInfoMap();
     System.out.println(userInfoMap);
    }

    @Test
    public void dynamicForeach(){
        Integer [] ids = {2,3};
        List<User> users = userMapper.dynamicForeach(ids);
        System.out.println(users);
    }

}
