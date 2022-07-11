package com.example.testplatfrom.contronller;

import com.example.testplatfrom.common.ServiceException;
import com.example.testplatfrom.dto.UserDto;
import com.example.testplatfrom.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-11 13-57
 **/
@RestController
@RequestMapping("testPlatform")
@Slf4j
public class TestPlatformController {
    @Autowired
    private UserService userService;

    @Value("${TestPlatform.key}")
    private String TestPlatformkey;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody UserDto UserDto){
        String result=userService.login(UserDto);
        try{
            if(UserDto.getUserName().contains("error")){
                ServiceException.throwEx("用户名中含有error");
            }
            if (UserDto.getUserName().contains("error1")){
                throw new NullPointerException();
            }

        }catch (Exception e){
            log.error(e.getMessage());
            return "系统繁忙，请稍后重试";

        }

        return "成功"+result;
    }
    @RequestMapping(value = "/byId/{userId}", method = RequestMethod.POST)
    public String get(@PathVariable("userId") Long userId){
        return "成功";
    }
}
