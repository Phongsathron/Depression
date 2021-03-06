package com.depression.resourceserv.resourceserv.controller;

import com.depression.resourceserv.resourceserv.model.UserInfo;
import com.depression.resourceserv.resourceserv.model.UserRequestModel;
import com.depression.resourceserv.resourceserv.services.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class UserControl {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        return "Hello!";
    }

    @GetMapping("/me")
    public Object me(Principal principal){
        UserInfo userInfo = userService.getUserInfoByUsername(principal.getName());
        return userInfo;
    }

    @GetMapping("/user")
    public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
        List<UserInfo> userInfos = userService.getAllActiveUserInfo();
        if (userInfos == null || userInfos.isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return userInfos;
    }

    @PostMapping("/user")
    public UserInfo addUser(@RequestBody UserInfo userRecord) {
        System.out.println(userRecord);
        return userService.addUser(userRecord);
    }

    @PostMapping("/register")
    public UserInfo register(@RequestBody UserRequestModel userRecord){
        UserInfo newUser = new UserInfo();
        if(!EmailValidator.getInstance().isValid(userRecord.getEmail())){
            System.out.println("Email Error");
            return newUser;
        }

        String role = userRecord.getRole().toUpperCase();
        if(!(role.equals("USER") || !role.equals("DOCTOR"))){
            System.out.println("Role Error :" + role);
            return newUser;
        }

        newUser.setEmail(userRecord.getEmail());
        newUser.setUsername(userRecord.getUsername());
        newUser.setFirstname(userRecord.getFirstname());
        newUser.setLastname(userRecord.getLastname());
        newUser.setPassword(userRecord.getPassword());
        newUser.setRole(role);
        newUser.setEnabled(true);

        return userService.addUser(newUser);
    }
}
