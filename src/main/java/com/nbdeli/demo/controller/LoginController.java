//package com.nbdeli.demo.controller;
//
//import com.nbdeli.demo.config.Color;
//import com.nbdeli.demo.config.PoolCache;
//import com.nbdeli.demo.config.ScanPool;
//import com.nbdeli.demo.dom.usertest.entity.UserDo;
//import com.nbdeli.demo.service.SystemConstantService;
//import com.nbdeli.demo.service.TestServcie;
//import com.nbdeli.demo.service.UserDao;
//import com.nbdeli.demo.service.UserDetail;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.axis.client.Call;
//import org.apache.axis.client.Service;
//import org.apache.axis.handlers.soap.SOAPService;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.imageio.ImageIO;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.rpc.ServiceException;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.rmi.RemoteException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * @author DuKaixiang
// * @date 2018/12/5.
// */
//@Slf4j
//@RestController
//public class LoginController extends BaseController{
//    //    @Autowired
////    private UserService userService;
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private TestServcie testServcie;
//    @Autowired
//    private SystemConstantService systemConstantService;
//
//    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
//    public String selectUser(@RequestParam(value = "id") Integer id) {
////        User user=userService.getUser(id);
//        UserDo user = userDao.findOne(1);
//        List<UserDetail> record = userDao.getAllRecord(1);
//        for (UserDetail o : record) {
//            System.out.println(o.toString() + ".......");
////            System.out.println(o.getRrid()+":"+o.getUrid()+":"+o.getUid()+":"+o.getRname());
//        }
//        System.out.println(Color.GREEN.getIndex() + ".." + Color.GREEN.getName());
//        System.out.println(Color.ALL.toString());
//        System.out.println(Color.ALL);
//        System.out.println(user.toString());
//        return "selectUser";
//    }
//
//    @RequestMapping(value = "/loginPage")
//    public String index(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            request.setAttribute("uuid", UUID.randomUUID());
//            ScanPool pool = new ScanPool();
//            pool.setCreateTime(System.currentTimeMillis());
//            Map<String, ScanPool> map = new HashMap<String, ScanPool>(1);
//            map.put("uuid", pool);
//            PoolCache.cacheMap.put("uuid", pool);
//            pool = null;
//        } catch (Exception e) {
//            log.error("pc生成二维码登录", e);
//        }
//        return "login";
//    }
//
////    @RequestMapping(value = "/test",method = RequestMethod.GET)
////    public String test() throws IOException {
////        String msg = "error!";
//////        int lastLine=testServcie.getLastLine();//获取上次的行数
////        int lastLine = 0;
////        File file = new File("E:\\count.txt");
////        List<String> lines = FileUtils.readLines(file);
////        String applicationStr = lines.get(lastLine + 2);
////        String timeStr = lines.get(lastLine + 1);
////        applicationStr = applicationStr.substring(12);
////        timeStr = timeStr.substring(5);
////        int i = lastLine + 3;
////        while (i < lines.size()) {
////            String record = lines.get(i);
////            String[] group = record.split(",");
////            if (group.length == 4) {
////                Gitstatistics gitStatistics = new Gitstatistics();
////                String[] attribute = group[0].split(":");
////                gitStatistics.setName(attribute[1]);
////                String[] attribute1 = group[1].split(":");
////                gitStatistics.setAdded(0);
////                if (attribute1.length == 2) {
////                    gitStatistics.setAdded(Integer.valueOf(attribute1[1]));
////                }
////                String[] attribute2 = group[2].split(":");
////                gitStatistics.setRemoved(0);
////                if (attribute2.length == 2) {
////                    gitStatistics.setRemoved(Integer.valueOf(attribute2[1]));
////                }
////                String[] attribute3 = group[3].split(":");
////                gitStatistics.setRemoved(0);
////                if (attribute3.length == 2) {
////                    gitStatistics.setUpdated(Integer.valueOf(attribute3[1]));
////                }
////                gitStatistics.setApplication(applicationStr);
////                gitStatistics.setTime(DateUtils.str2Date(timeStr, "yyyy-MM-dd HH:mm:ss"));
////                gitStatistics.setStatus("A");
////                gitStatistics.setAddno("dkx");
////                Date now = new Date();
////                gitStatistics.setAddtime(now);
////                gitStatistics.setUpdateno("dkx");
////                gitStatistics.setUpdatetime(now);
////                System.out.println(gitStatistics);
////                testServcie.insertGitStatistics(gitStatistics);
////            }
////            i++;
////        }
////        return msg;
////    }
//
////    public static void main(String[] args) throws IOException {
////       int lastLine = 0;
////        File file = new File("E:\\count.txt");
////        List<String> lines = FileUtils.readLines(file);
////        String applicationStr = lines.get(lastLine + 2);
////        String timeStr = lines.get(lastLine + 1);
////        applicationStr = applicationStr.substring(12);
////        timeStr = timeStr.substring(5);
////        int i = lastLine + 3;
////        while (i < lines.size()) {
////            String record = lines.get(i);
////            String[] group = record.split(",");
////            if (group.length == 4) {
////                Gitstatistics gitStatistics = new Gitstatistics();
////                String[] attribute = group[0].split(":");
////                gitStatistics.setName(attribute[1]);
////                String[] attribute1 = group[1].split(":");
////                gitStatistics.setAdded(0);
////                if (attribute1.length == 2) {
////                    gitStatistics.setAdded(Integer.valueOf(attribute1[1]));
////                }
////                String[] attribute2 = group[2].split(":");
////                gitStatistics.setRemoved(0);
////                if (attribute2.length == 2) {
////                    gitStatistics.setRemoved(Integer.valueOf(attribute2[1]));
////                }
////                String[] attribute3 = group[3].split(":");
////                gitStatistics.setRemoved(0);
////                if (attribute3.length == 2) {
////                    gitStatistics.setUpdated(Integer.valueOf(attribute3[1]));
////                }
////                gitStatistics.setApplication(applicationStr);
////                gitStatistics.setTime(DateUtils.str2Date(timeStr, "yyyy-MM-dd HH:mm:ss"));
////                gitStatistics.setStatus("A");
////                gitStatistics.setAddno("dkx");
////                Date now = new Date();
////                gitStatistics.setAddtime(now);
////                gitStatistics.setUpdateno("dkx");
////                gitStatistics.setUpdatetime(now);
////                System.out.println(gitStatistics);
//////                testServcie.insertGitStatistics(gitStatistics);
////            }
////            i++;
////        }
////    }
//
//
//    @RequestMapping(value = "/getXML", method = RequestMethod.POST)
//    public String getXML(@RequestParam(value = "xml") String xml) throws ServiceException, MalformedURLException, RemoteException {
//        SOAPService soap = new SOAPService();
//        soap.setName("transOnlineOrder");  //此处webservice的名字
//        Service service = new Service();
//        Call call = (Call) service.createCall();
//        String endpoint = "http://61.190.39.14/services/transOnlineOrder?wsdl";
//        call.setTargetEndpointAddress(new java.net.URL(endpoint));
//        call.setOperationName("transOnlineOrder");
//        call.addParameter("str", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
//        call.setSOAPService(soap);
//        call.setUseSOAPAction(true);
//        System.out.println(xml);
//        String rtnxml = (String) call.invoke(new Object[]{xml});
//        System.out.println("result:11111111111111");
//        System.out.println(rtnxml);
//        return rtnxml;
//    }
//
//    @ResponseBody
//    @GetMapping(value = "/captcha.img")
//    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String sessionId=request.getSession().getId();
//        response.setHeader("Cache-Control", "no-store, no-cache");
//        response.setContentType("image/jpeg");
//        BufferedImage image=systemConstantService.getKaptcha(sessionId);
//        ServletOutputStream out=response.getOutputStream();
//        ImageIO.write(image, "jpg", out);
//        IOUtils.closeQuietly(out);
//    }
//
//    @ResponseBody
//    @GetMapping(value = "/getExcel")
//    public void getExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            prepareDownLoadResponse(response, "application/x-xls", "账号信息.xlsx");
////            ByteArrayOutputStream ostream = null;
//            ServletOutputStream stream = null;
//            try {
////                ostream = new ByteArrayOutputStream();
////                workbook.write(ostream);
//                stream = response.getOutputStream();
//                stream.write(systemConstantService.getExcel());
//                stream.flush();
//            } catch (IOException e) {
//                log.error("账号信息条件导出出错", e);
//            } finally {
//                stream.close();
////                ostream.close();
//            }
//    }
//}
