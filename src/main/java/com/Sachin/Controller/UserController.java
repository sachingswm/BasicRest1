package com.Sachin.Controller;

import com.Sachin.Entity.User;
import com.Sachin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/updateUser")
    public HashMap<String,String> updateUser(@RequestBody HashMap<String,String> req)
    {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            userService.updateUser(req.get("name"), Integer.parseInt(req.get("id")));

            map.put("message", "SUCCESS");
            map.put("response_code", "1");
        }
        catch(Exception e){
            map.put("message", "Failed");
            map.put("exception",e.toString());
            map.put("response_code", "0");
        }
        return map;
    }


    @GetMapping("/getUsers")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

    @PostMapping("/setUser")
    public User addUser(@RequestBody User user)
    {
        //Request Body JSON -> Java Object
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public User deleteUser(@PathVariable("id") int id)
    {
        return userService.deleteUser(id);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id)
    {
        return userService.getUser(id);
    }
}
