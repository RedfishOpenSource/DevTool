package com.redfish.cc;

import cn.hutool.core.io.FileUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.fastjson.JSONObject;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @author zly
 * @date 2025/2/19
 * @description TODO
 * @Copyright: 儒松科技
 */
@RestController("CustomApiFromLocalLocalFileController")
public class CustomApiFromLocalLocalFileController {

    @PostMapping(value = "/custom/api/local/file")
    public Response handleData(@RequestParam String filePath,
                                  @RequestBody(required = false) JSONObject jsonData,
                                  HttpServletRequest request) {

        String groovyCode = FileUtil.readUtf8String(filePath);
        if (ObjectUtils.isEmpty(groovyCode)) {
            Response response = new Response();
            response.setSuccess(false);
            response.setErrMessage("groovy code is empty for file path:" + filePath);
            return response;
        }

        // 执行Groovy脚本
        Binding binding = new Binding();
        binding.setProperty("data", jsonData);
        GroovyShell groovyShell = new GroovyShell(binding);
        Response response = (Response) groovyShell.evaluate(groovyCode);
        if (response == null){
            response = new Response();
            response.setSuccess(true);
        }

        return response;
    }


    @GetMapping(value = "/custom/api/local/file")
    public Response handleData(@RequestParam String filePath,
                               HttpServletRequest request) {

        String groovyCode = FileUtil.readUtf8String(filePath);
        if (ObjectUtils.isEmpty(groovyCode)) {
            Response response = new Response();
            response.setSuccess(false);
            response.setErrMessage("groovy code is empty for file path:" + filePath);
            return response;
        }

        // 执行Groovy脚本
        Binding binding = new Binding();
        binding.setProperty("data", null);
        GroovyShell groovyShell = new GroovyShell(binding);
        Response response = (Response) groovyShell.evaluate(groovyCode);
        if (response == null){
            response = new Response();
            response.setSuccess(true);
        }

        return response;
    }




}
