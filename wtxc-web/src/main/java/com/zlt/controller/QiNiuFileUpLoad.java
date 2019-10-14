package com.zlt.controller;

import com.qiniu.storage.model.DefaultPutRet;
import com.zlt.utils.IDUtils;
import com.zlt.utils.QiNiuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
public class QiNiuFileUpLoad {

    @RequestMapping(value = "qUpload",method = RequestMethod.POST)
    public String QiNiuUpload(MultipartFile file) throws IOException {
        String FileName = file.getOriginalFilename();
        String saveName = IDUtils.genImageName()+FileName;

        InputStream is = file.getInputStream();

        DefaultPutRet dpr = QiNiuUtil.uploadStream(is,saveName);
        return dpr.key.isEmpty()?"fail":"ok";
    }
}
