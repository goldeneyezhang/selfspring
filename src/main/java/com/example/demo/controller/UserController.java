package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yibozhang@ctrip.com
 * @create: 2021-04-09 14:48
 * @description
 **/
@Controller
public class UserController {
    @GetMapping(value="/sample")
    public String sample(Model model){
        model.addAttribute("user",getUserDTOData());
        List<UserDTO> users=new ArrayList<>();
        users.add(new UserDTO("zhangsan","男",new Date()));
        users.add(new UserDTO("wangjingjing","女",new Date()));
        users.add(new UserDTO("limeimei","女",new Date()));
        users.add(new UserDTO("lisi","男",new Date()));
        model.addAttribute("users",users);
        return "/user/sample";
    }

    /**
     * 构造一个user对象
     * */
    private UserDTO getUserDTOData(){
        UserDTO userDTO=new UserDTO();
        userDTO.setUsername("fishpro");
        userDTO.setSex("男");
        userDTO.setBirthday(new Date());
        return  userDTO;
    }
}
