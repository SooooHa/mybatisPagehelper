package cn.demo.controller;

import cn.demo.bean.User;
import cn.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 57251180@qq.com
 * Date: 1/6/2020
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getuser")
    public String getAllPerson(Model model, @RequestParam(defaultValue = "1",value = "pageNum")  Integer pageNum,@RequestParam(defaultValue = "3",value = "pageSize")Integer pageSize){
        List<User> list = userService.pageAll(pageNum,pageSize);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }


    /**
     * 1. 用id查询
     *
     * @return
     */
    @GetMapping("/findUserById")
    public String findUserById(Model model,String id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user";
    }

    @PostMapping("/updateById")
    public String updateUserById(String id,User user){
        userService.updateById(id,user);
        return "redirect:getuser";
    }





}
