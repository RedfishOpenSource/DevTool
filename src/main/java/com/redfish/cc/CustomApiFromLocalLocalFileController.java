package com.redfish.cc;

import cn.hutool.core.io.FileUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.fastjson.JSONObject;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

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

    @PostMapping(value = "/thirdpartinf/wbb_interface")
    public JSONObject temp(@RequestParam(required = false) String TradeCode,
                         @RequestParam(required = false) String UserName,
                         @RequestParam(required = false) String IsOtherDept,
                         @RequestParam(required = false) String DepartID,
                               HttpServletRequest request) {

        if (Objects.equals(TradeCode, "getDevList")){
            String resultStr = "{\n" +
                    "\t\"CoreID\": \"a2840c28-ddce-11ec-99e6-000c29a0f79e\",\n" +
                    "\t\"IP\": \"10.20.50.205\",\n" +
                    "\t\"success\": 1,\n" +
                    "\t\"result\": [\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"58\",\n" +
                    "\t\t\t\"IP\": \"10.20.50.215\",\n" +
                    "\t\t\t\"Mac\": \"00:0C:29:AE:92:E7\",\n" +
                    "\t\t\t\"DevName\": \"WINXP_BM_01\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:(FM)43BFC7CC797EB0E431289FCAA0692C78\",\n" +
                    "\t\t\t\"CPU\": \"12th Gen Intel(R) Core(TM) i5-12500H\",\n" +
                    "\t\t\t\"Online\": \"0\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"62\",\n" +
                    "\t\t\t\"IP\": \"10.20.50.128\",\n" +
                    "\t\t\t\"Mac\": \"00:0C:29:11:B5:E5\",\n" +
                    "\t\t\t\"DevName\": \"SIXGOD-WIN7\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:(FM)98B99068255ECFC06599385B6F0A98A8\",\n" +
                    "\t\t\t\"CPU\": \"Intel(R) Core(TM) i5-9400 CPU @ 2.90GHz\",\n" +
                    "\t\t\t\"Online\": \"1\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"65\",\n" +
                    "\t\t\t\"IP\": \"10.20.50.226\",\n" +
                    "\t\t\t\"Mac\": \"00:0C:29:53:8E:6E\",\n" +
                    "\t\t\t\"DevName\": \"VHYN6IODHYJX0H9\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:(FM)ABE2E8EFEFE23AC42CE11CD1437657F8\",\n" +
                    "\t\t\t\"CPU\": \"Intel(R) Core(TM) i5-9400F CPU @ 2.90GHz\",\n" +
                    "\t\t\t\"Online\": \"0\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"66\",\n" +
                    "\t\t\t\"IP\": \"192.168.20.135\",\n" +
                    "\t\t\t\"Mac\": \"00:0C:29:D4:04:84\",\n" +
                    "\t\t\t\"DevName\": \"WIN-HUBQOM5NSUB\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:(FM)4F542946E06468ECF1BCE9A0EA6E21D0\",\n" +
                    "\t\t\t\"CPU\": \"Intel(R) Core(TM) i5-9400 CPU @ 2.90GHz\",\n" +
                    "\t\t\t\"Online\": \"1\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"81\",\n" +
                    "\t\t\t\"IP\": \"10.20.50.106\",\n" +
                    "\t\t\t\"Mac\": \"D0:50:99:65:9E:33\",\n" +
                    "\t\t\t\"DevName\": \"COMPUTER-J\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:GLOWAY STK240GS3-S7K270702J25222134217727\",\n" +
                    "\t\t\t\"CPU\": \"Intel(R) Core(TM) i5-4590 CPU @ 3.30GHz\",\n" +
                    "\t\t\t\"Online\": \"0\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"83\",\n" +
                    "\t\t\t\"IP\": \"10.20.50.96\",\n" +
                    "\t\t\t\"Mac\": \"D0:C6:37:18:18:7F\",\n" +
                    "\t\t\t\"DevName\": \"XIAOXING\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:(FM)1B0EC29E92EAD5BDB2E843824610A091\",\n" +
                    "\t\t\t\"CPU\": \"AMD Ryzen 5 3500U with Radeon Vega Mobile Gfx\",\n" +
                    "\t\t\t\"Online\": \"0\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"DeviceID\": \"10093\",\n" +
                    "\t\t\t\"IP\": \"10.20.50.53\",\n" +
                    "\t\t\t\"Mac\": \"04:D9:F5:D7:16:4D\",\n" +
                    "\t\t\t\"DevName\": \"XUKAI\",\n" +
                    "\t\t\t\"UserName\": \"\",\n" +
                    "\t\t\t\"DepartID\": \"0\",\n" +
                    "\t\t\t\"Hard\": \"HARD:(R)CEC488B504C383062F16D280FE589682\",\n" +
                    "\t\t\t\"CPU\": \"Intel(R) Core(TM) i5-9400F CPU @ 2.90GHz\",\n" +
                    "\t\t\t\"Online\": \"0\"\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}\n";
            JSONObject result = JSONObject.parseObject(resultStr);
            return result;
        }


        if (Objects.equals(TradeCode, "getRemote")){
            String resultStr = "{\n" +
                    "\t\"CoreID\": \"a2840c28-ddce-11ec-99e6-000c29a0f79e\",\n" +
                    "\t\"IP\": \"10.20.50.205\",\n" +
                    "\t\"success\": 1,\n" +
                    "\t\"url\": \"/tp/mod/networkinfo/remote_alert_page.html?dowhat=start&FuncType=2&Command=3&devID=10097&deviceIP=10.20.50.118&key=dG9rZW46J3lCd3NlZ2ViY1M2S0Zka0lGcjZxMGVCS0l0VzkzOTAwJyxsb2dpbjonYWRtaW4nLHN5c2ZsYWc6JzEnLGdMYW5nOid6aCcsc2tpblZhbHVlU2VsZWN0ZWQ6Jycsb3JpZ2luOic3Y2NiYjAzY2I3OTU3MzQ0MTVhMGI2OTI0YThkN2FlZCc:\"\n" +
                    "}\n";
            JSONObject result = JSONObject.parseObject(resultStr);
            return result;
        }



        return null;
    }


}
