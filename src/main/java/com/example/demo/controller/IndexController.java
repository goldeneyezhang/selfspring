package com.example.demo.controller;

import com.example.demo.mylog.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yibozhang@ctrip.com
 * @create: 2021-04-09 13:54
 * @description
 **/
@RestController
@RequestMapping("/")
@Api(tags = "用户信息管理")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "index")
    @ApiOperation("分页查询所有数据")
    @Log("日志注解")
    String index(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "index";
    }
    @Log("日志注解，配合WebAspect记录请求前、请求后、请求过程")
    @GetMapping(value = "log")
    @ResponseBody
    public String log(String name){
        return "log";
    }
}
