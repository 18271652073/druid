package com.nbdeli.demo.controller;

import com.nbdeli.demo.config.Color;
import com.nbdeli.demo.config.PoolCache;
import com.nbdeli.demo.config.ScanPool;
import com.nbdeli.demo.dom.usertest.entity.UserDo;
import com.nbdeli.demo.service.UserDao;
import com.nbdeli.demo.service.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author DuKaixiang
 * @date 2018/12/5.
 */
@Slf4j
@RestController
public class LoginController {
//    @Autowired
//    private UserService userService;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    public String selectUser(@RequestParam(value = "id") Integer id){
//        User user=userService.getUser(id);
        UserDo user=userDao.findOne(1);
        List<UserDetail> record=userDao.getAllRecord(1);
        for (UserDetail o:record) {
            System.out.println(o.toString()+".......");
//            System.out.println(o.getRrid()+":"+o.getUrid()+":"+o.getUid()+":"+o.getRname());
        }
        System.out.println(Color.GREEN.getIndex()+".."+Color.GREEN.getName());
        System.out.println(Color.ALL.toString());
        System.out.println(Color.ALL);
        System.out.println(user.toString());
        return "selectUser";
    }

    @RequestMapping(value = "/loginPage")
    String index(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            request.setAttribute("uuid", UUID.randomUUID());
            ScanPool pool = new ScanPool();
            pool.setCreateTime(System.currentTimeMillis());
            Map<String, ScanPool> map = new HashMap<String, ScanPool>(1);
            map.put("uuid", pool);
            PoolCache.cacheMap.put("uuid", pool);
            pool=null;
        } catch (Exception e) {
            log.error("pc生成二维码登录", e);
        }
        return "login";
    }


}
