package com.example.xyblog.Utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class ApiUtils {
    public static JSONObject jsonData(String qqAccount) throws IOException {
        // 返回带有qq账号的json对象
        URL url = new URL("https://api.usuuu.com/qq/" + qqAccount);

        StringBuffer document = new StringBuffer();
        //创建链接
        URLConnection conn = url.openConnection();
        //读取返回结果集
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String line = null;
        while ((line = reader.readLine()) != null) {
            document.append(line);
        }
        reader.close();
        return (JSONObject) ((JSONObject) JSONObject.parse(document.toString())).get("data");
    }


}
