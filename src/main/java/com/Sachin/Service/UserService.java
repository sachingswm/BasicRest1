package com.Sachin.Service;

import com.Sachin.Dao.UserDao;
import com.Sachin.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public void updateUser(String name,int id)
    {
        userDao.update(name,id);
    }

    public List<User> getUsers()
    {
       return (List<User>) userDao.findAll();
    }
    public User addUser(User user)
    {
        return userDao.save(user);
    }
    public User deleteUser(int id)
    {
        User user=userDao.findById(id).get();
        userDao.delete(user);
        return user;
    }
    public User getUser(int id)
    {
        return userDao.findById(id).get();
    }
}
