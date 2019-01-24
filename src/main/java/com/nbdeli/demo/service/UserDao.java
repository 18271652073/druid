package com.nbdeli.demo.service;

import com.nbdeli.demo.dom.usertest.entity.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author DuKaixiang
 * @date 2018/12/5.
 */
@Repository
public interface UserDao extends JpaRepository<UserDo, Integer> {
    @Query(value = "select u.uid,u.rid as urid,r.rid as rrid,r.rname from user_role u left join role r on r.rid=u.rid where r.rid=? ", nativeQuery = true)
    public List<UserDetail> getAllRecord(@Param("rid") Integer rid);
}
