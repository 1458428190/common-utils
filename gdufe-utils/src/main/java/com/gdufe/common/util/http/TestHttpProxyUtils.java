package com.gdufe.common.util.http;

import org.apache.http.HttpException;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.gdufe.common.util.http.domain.ProxyInfo;

/**
 * @author: laichengfeng
 * @description:
 * @Date: 2018/10/31 10:17
 */
public class TestHttpProxyUtils extends HttpProxyUtils {

    private static String proxy_pool_url = "http://www.baidu.com";

    /**
     * 转换协议
     * @param proxyPool
     * @return
     */
    @SuppressWarnings("unchecked")
    private static List<ProxyInfo> listProxy(String proxyPool) {
        Map<String, Object> content = (Map<String, Object>) JSON.parse(proxyPool);
        return (List<ProxyInfo>) content.get("result");
    }

    public static void main(String[] args) throws HttpException {
        String s = get("www.baidu.com", null, null, "utf-8");
        System.out.println(s);
    }
}