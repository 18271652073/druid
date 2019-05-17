package com.nbdeli.demo.service;

import com.nbdeli.demo.dom.blob.entity.SystemConstant;
import com.nbdeli.demo.dom.blob.mapper.SystemConstantMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author Dukaixiang
 * @date 2019/4/18.
 * @Version 1.0
 */
@Slf4j
@Service
public class SystemConstantService {
    @Autowired
    private SystemConstantMapper systemConstantMapper;

    public byte[] selectBlob(int id){
        return systemConstantMapper.selectByPrimaryKey(id).getConstantName();
    }

    public int insertEntity() throws IOException {
        SystemConstant systemConstant=new SystemConstant();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\2018届大学生转正名单（本科）.xlsx");
        systemConstant.setConstantName(FileCopyUtils.copyToByteArray(fileInputStream));
        systemConstant.setStatus("A");
        systemConstant.setAddNo("11");
        systemConstant.setAddTime(new Date());
        systemConstant.setUpdateNo("11");
        systemConstant.setUpdateTime(new Date());
        systemConstant.setConstantKey("1");
        systemConstant.setConstantValue("1");
        systemConstant.setConstantType("1");
        systemConstant.setTypeName("1");
        return systemConstantMapper.insert(systemConstant);
    }

    public BufferedImage getKaptcha(String sessionId) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(selectBlob(1));    //将b作为输入流；
        return ImageIO.read(in);
    }

    public byte[] getExcel() {
        return selectBlob(5);
    }
}
