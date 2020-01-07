package cn.demo.service;

import cn.demo.bean.User;
import cn.demo.dao.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 57251180@qq.com
 * Date: 1/6/2020
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;



    public List<User> pageAll(int page,int size){
        PageHelper.startPage(page, size);
        return userMapper.selectAll();
    }

    public void updateById(String id, User user) {
        User user1 = this.findUserById(id);
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setSex(user.getSex());
        user1.setUsername(user.getUsername());


    }

    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    private void updateUser(User user){
        userMapper.updateUser(user);
    }
}
