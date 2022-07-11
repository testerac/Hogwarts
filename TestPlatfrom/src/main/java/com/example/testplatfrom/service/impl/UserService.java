package com.example.testplatfrom.service.impl;

import com.example.testplatfrom.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-11 14-29
 **/
@Component
public class UserService implements com.example.testplatfrom.service.UserService {
    public String login(UserDto userDto){
        return userDto.getUserName()+"-"+userDto.getPwd();
    }

}
