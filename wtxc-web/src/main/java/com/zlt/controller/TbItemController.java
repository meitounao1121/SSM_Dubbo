package com.zlt.controller;

import com.qiniu.storage.model.DefaultPutRet;
import com.zlt.pojo.TbItem;
import com.zlt.service.TbItemService;
import com.zlt.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class TbItemController {

    @Autowired
    TbItemService tbItemService;

    @Value("${URL}")
    private String URL;

    @RequestMapping(value = "item-list-page",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult<TbItem> page(@RequestParam(required = true)int page, @RequestParam(required = true)int rows){

        return tbItemService.getTbItemList( page,rows );

    }

    @RequestMapping("/")
    public String age(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String age(@PathVariable("page") String page){

        return page;
    }

    @RequestMapping(value = "/pic/upload",method = RequestMethod.POST)
    @ResponseBody
    public String QiNiuUpload(MultipartFile uploadFile) throws IOException {
        System.out.println(URL);
        String FileName = uploadFile.getOriginalFilename();
        String saveName = IDUtils.genImageName()+FileName.substring(FileName.lastIndexOf("."));
        StringBuffer sb = new StringBuffer();
        UploadResult uploadResult = new UploadResult();

        try {
            InputStream is = uploadFile.getInputStream();
            DefaultPutRet dpr = QiNiuUtil.uploadStream(is,saveName);
            uploadResult.setError(0);
            uploadResult.setUrl( sb.append(URL).append("/").append(dpr.key).toString());
        }catch (Exception e){
            uploadResult.setError(1);
            uploadResult.setMessage("上传失败");
        }finally {
            return JsonUtils.objectToJson(uploadResult);
        }
    }
}
