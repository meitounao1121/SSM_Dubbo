package com.zlt.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.IOException;
import java.io.InputStream;

public class QiNiuUtil {
    private static final String AK = "YzYi1mrJQxpun9A5q7akX9I9cBKpGFVlzyY5lIDF";
    private static final String SK = "PhWWetDqBGCnYCPAyvuD6ojAWbZqXGcKvWLCsAab";
    private static final String bucket = "wlldemo1";
    private static final Zone zone = Zone.autoZone();
    private static final Configuration c = new Configuration(zone);
    private static final UploadManager uploadManager = new UploadManager(c);

    private static String getToken(){
        Auth auth = Auth.create(AK,SK);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
    public static DefaultPutRet uploadStream(InputStream is, String fileName)throws IOException {
        byte b[]=new byte[is.available()];
        is.read(b);
        DefaultPutRet putRet=null;
        try {
            Response response = uploadManager.put(b,fileName,getToken());
            //解析上传成功的结果
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(response.bodyString());
        } catch (QiniuException ex) {
            Response r = ex.response;
        }
        return putRet;
    }
}
