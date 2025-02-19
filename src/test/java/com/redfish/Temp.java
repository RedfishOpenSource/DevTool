package com.redfish;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author zly
 * @date 2025/2/19
 * @description TODO
 * @Copyright: 儒松科技
 */
public class Temp {

    @Test
    public void demo() throws UnsupportedEncodingException {
        String temp = URLEncoder.encode("D:\\develop\\GitNote\\RedfishOpenSource\\DevTool\\src\\main\\java\\com\\redfish\\cc\\demo.groovy","UTF-8");
        System.out.println(temp);
    }

}
