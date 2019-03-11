package com.nbdeli.demo.controller;

import com.nbdeli.demo.config.Color;
import com.nbdeli.demo.config.PoolCache;
import com.nbdeli.demo.config.ScanPool;
import com.nbdeli.demo.dom.usertest.entity.UserDo;
import com.nbdeli.demo.service.TestServcie;
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
    @Autowired
    private TestServcie testServcie;

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    public String selectUser(@RequestParam(value = "id") Integer id) {
//        User user=userService.getUser(id);
        UserDo user = userDao.findOne(1);
        List<UserDetail> record = userDao.getAllRecord(1);
        for (UserDetail o : record) {
            System.out.println(o.toString() + ".......");
//            System.out.println(o.getRrid()+":"+o.getUrid()+":"+o.getUid()+":"+o.getRname());
        }
        System.out.println(Color.GREEN.getIndex() + ".." + Color.GREEN.getName());
        System.out.println(Color.ALL.toString());
        System.out.println(Color.ALL);
        System.out.println(user.toString());
        return "selectUser";
    }

    @RequestMapping(value = "/loginPage")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("uuid", UUID.randomUUID());
            ScanPool pool = new ScanPool();
            pool.setCreateTime(System.currentTimeMillis());
            Map<String, ScanPool> map = new HashMap<String, ScanPool>(1);
            map.put("uuid", pool);
            PoolCache.cacheMap.put("uuid", pool);
            pool = null;
        } catch (Exception e) {
            log.error("pc生成二维码登录", e);
        }
        return "login";
    }

//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public String test() throws IOException {
//        String msg = "error!";
////        int lastLine=testServcie.getLastLine();//获取上次的行数
//        int lastLine = 0;
//        File file = new File("E:\\count.txt");
//        List<String> lines = FileUtils.readLines(file);
//        String applicationStr = lines.get(lastLine + 2);
//        String timeStr = lines.get(lastLine + 1);
//        applicationStr = applicationStr.substring(12);
//        timeStr = timeStr.substring(5);
//        int i = lastLine + 3;
//        while (i < lines.size()) {
//            String record = lines.get(i);
//            String[] group = record.split(",");
//            if (group.length == 4) {
//                Gitstatistics gitStatistics = new Gitstatistics();
//                String[] attribute = group[0].split(":");
//                gitStatistics.setName(attribute[1]);
//                String[] attribute1 = group[1].split(":");
//                gitStatistics.setAdded(0);
//                if (attribute1.length == 2) {
//                    gitStatistics.setAdded(Integer.valueOf(attribute1[1]));
//                }
//                String[] attribute2 = group[2].split(":");
//                gitStatistics.setRemoved(0);
//                if (attribute2.length == 2) {
//                    gitStatistics.setRemoved(Integer.valueOf(attribute2[1]));
//                }
//                String[] attribute3 = group[3].split(":");
//                gitStatistics.setRemoved(0);
//                if (attribute3.length == 2) {
//                    gitStatistics.setUpdated(Integer.valueOf(attribute3[1]));
//                }
//                gitStatistics.setApplication(applicationStr);
//                gitStatistics.setTime(DateUtils.str2Date(timeStr, "yyyy-MM-dd HH:mm:ss"));
//                gitStatistics.setStatus("A");
//                gitStatistics.setAddno("dkx");
//                Date now = new Date();
//                gitStatistics.setAddtime(now);
//                gitStatistics.setUpdateno("dkx");
//                gitStatistics.setUpdatetime(now);
//                System.out.println(gitStatistics);
//                testServcie.insertGitStatistics(gitStatistics);
//            }
//            i++;
//        }
//        return msg;
//    }

//    public static void main(String[] args) throws IOException {
//       int lastLine = 0;
//        File file = new File("E:\\count.txt");
//        List<String> lines = FileUtils.readLines(file);
//        String applicationStr = lines.get(lastLine + 2);
//        String timeStr = lines.get(lastLine + 1);
//        applicationStr = applicationStr.substring(12);
//        timeStr = timeStr.substring(5);
//        int i = lastLine + 3;
//        while (i < lines.size()) {
//            String record = lines.get(i);
//            String[] group = record.split(",");
//            if (group.length == 4) {
//                Gitstatistics gitStatistics = new Gitstatistics();
//                String[] attribute = group[0].split(":");
//                gitStatistics.setName(attribute[1]);
//                String[] attribute1 = group[1].split(":");
//                gitStatistics.setAdded(0);
//                if (attribute1.length == 2) {
//                    gitStatistics.setAdded(Integer.valueOf(attribute1[1]));
//                }
//                String[] attribute2 = group[2].split(":");
//                gitStatistics.setRemoved(0);
//                if (attribute2.length == 2) {
//                    gitStatistics.setRemoved(Integer.valueOf(attribute2[1]));
//                }
//                String[] attribute3 = group[3].split(":");
//                gitStatistics.setRemoved(0);
//                if (attribute3.length == 2) {
//                    gitStatistics.setUpdated(Integer.valueOf(attribute3[1]));
//                }
//                gitStatistics.setApplication(applicationStr);
//                gitStatistics.setTime(DateUtils.str2Date(timeStr, "yyyy-MM-dd HH:mm:ss"));
//                gitStatistics.setStatus("A");
//                gitStatistics.setAddno("dkx");
//                Date now = new Date();
//                gitStatistics.setAddtime(now);
//                gitStatistics.setUpdateno("dkx");
//                gitStatistics.setUpdatetime(now);
//                System.out.println(gitStatistics);
////                testServcie.insertGitStatistics(gitStatistics);
//            }
//            i++;
//        }
//    }

}
