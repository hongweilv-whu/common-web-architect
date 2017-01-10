package com.whu.hong;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Description:
 * Created by lvhw on 2017/1/10 13:11.
 */
public class HttpClientCall {
    private static final String biUrl = "http://10.113.32.45:8002/bi/card/getSalesBriefStatisticInfo";

    public static void main(String[] args) {
        RptCardRestArg arg = new RptCardRestArg();
        arg.setBeginTime("2017-01-01");
        arg.setEndTime("2017-01-31");
        arg.setDataId(183);
        arg.setDataName("linxiaolan");
        arg.setDataType(1);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost method = new HttpPost(biUrl);
        //解决中文乱码问题
        StringEntity entity = new StringEntity(JSON.toJSONString(arg), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        method.setEntity(entity);

        try {
            HttpResponse result = httpClient.execute(method);
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    System.out.println("result:--------" + str);

                    /**把json字符串转换成json对象**/
                    JSONObject jsonResult = JSONObject.parseObject(str);
                    int statusCode = jsonResult.getJSONObject("status").getIntValue("statusCode");
                    if (0 == statusCode) {
                        JSONArray jsonArray = jsonResult.getJSONArray("infos");
                        for (int i = 0, size = jsonArray.size(); i < size; i++) {
                            JSONObject jo = jsonArray.getJSONObject(i);
                            if ("BI_58733fad37aa1b7d8a8debe2".equals(jo.getString("id"))) {
                                System.out.println(jo.getString("name"));
                                System.out.println(jo.getJSONObject("statistics").getIntValue("newAdd"));
                            }
                        }

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
