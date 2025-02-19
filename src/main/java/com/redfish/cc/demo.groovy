package com.redfish.cc


import com.alibaba.cola.dto.SingleResponse

public class TestResponse extends SingleResponse<Map<String,Object>> {

    private String code;

    private String token;

    String getCode() {
        return code
    }

    void setCode(String code) {
        this.code = code
    }

    String getToken() {
        return token
    }

    void setToken(String token) {
        this.token = token
    }
}

// 使用参数：String code = data.getString("code");

Map<String,Object> resultData = new HashMap<>();
resultData.put("code","103068");
TestResponse testResponse = new TestResponse();
testResponse.setCode("200");
testResponse.setToken("fsfdfadfasdsfsfs");
testResponse.setData(resultData);
return testResponse;
