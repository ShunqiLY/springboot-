package com.qf.SpringBoot_backend.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.qf.SpringBoot_backend.utils.Result;
import com.sun.net.httpserver.HttpsServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/files")
@Api("文件控制器层")
public class FileController {
    private static final String IP = "http://localhost";
    @Value("${server.port}")
    private String port;

    @PostMapping
    @ApiOperation("单文件上传")
    public Result<?> upload(MultipartFile file){
        String filename = file.getOriginalFilename();//获取原文件名称
        String flag = IdUtil.fastSimpleUUID();//生成唯一的标识，避免上传文件重名
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files"
                +flag+"_"+filename;        //获取当前所在的根目录
        try {
            FileUtil.writeBytes(file.getBytes(),rootFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = IP + ":" + port + "/files" +flag;//云端http路径
        System.out.println("云端文件上传路径"+url);
        return Result.success(url);
    }

    @GetMapping
    @ApiOperation("文件下载")
    public void download(String flag,HttpServerResponse response) {
        OutputStream os;//输出对象
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files";
        //FileUtil.listFileNames(baseFilePath);表示获取该目录下所有的文件的名称
        List<String> fileNames = FileUtil.listFileNames(basePath);

        String filename = fileNames.stream()
                .filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(filename)) {
                response.addHeader("Content-Disposition", "attachment:filename"
                        + URLEncoder.encode(filename, StandardCharsets.UTF_8));
                response.setContentType("application/octet-stream");//唤起浏览器下载
                byte[] bytes = FileUtil.readBytes(basePath + filename);
                os = response.getOut();//通过输出流返回文件
                os.write(bytes);

            }

        } catch (Exception e) {
            System.out.println("文件下载失败!!!!!!!!!!!!");
        }
    }

    @PostMapping("/editor/upload")
    @ApiOperation("富文本上传")
    public JSON editorUpload(MultipartFile file){
        String filename = file.getOriginalFilename();//获取原文件名称
        String flag = IdUtil.fastSimpleUUID();//生成唯一的标识，避免上传文件重名
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files"
                +flag+"_"+filename;        //获取当前所在的根目录
        try {
            FileUtil.writeBytes(file.getBytes(),rootFilePath);//1.文件字节流2.输出位置
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = IP + ":" + port + "/files" +flag;//云端http路径

        //自定义JSON字符串
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("error",0);
        JSONArray array = new JSONArray();
        JSONObject data = new JSONObject();
        array.add(data);
        data.set("url",url);
        jsonObject.set("data",array);

        //{error:0,data[{url}]}
        return jsonObject;
    }


}
