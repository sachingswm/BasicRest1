package com.Sachin.Dao;

import com.Sachin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value="update user set name = ?1 where id=?2",nativeQuery = true)
    @Modifying
    public void update(String name,int id);

}
