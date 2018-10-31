/**
 * @(#)HttpProxyUtils.java, 2018/10/26.
 * <p/>
 * Copyright 2018 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gdufe.common.util.http;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.gdufe.common.util.http.domain.ProxyInfo;

/**
 * @author: laichengfeng (laichengfeng @ corp.netease.com)
 * @description: 代理Http工具类， 依赖于http://3c.163.com/spider-ipPool/list.do, 默认走代理 （可继承此类重写）
 * @Date: 2018/10/26 14:35
 */
public class HttpProxyUtils{

    /**
     * 接入代理池
     * 代理池格式：
     * {
     *      "msg": "SUCC",
     *      "result": [
     *           {
     *           "id": 734,
     *           "hostname": "139.217.24.50",
     *           "port": 3128,
     *           "address": "中国    北京市    北京市",
     *           "anonType": "高匿",
     *           "type": "HTTPS"
     *           },...
     *      ]
     * }
     * // TODO 后期可以考虑接入账号密码
     */
    private static String proxy_pool_url = "http://3c.163.com/spider-ipPool/list.do";

    /**
     * 全局index
     */
    private static Integer whold_index = 0;

    /**
     * 用于校验
     */
    private static int last_id = 0;

    public static String get(String url, Map<String, Object> params, Map<String, Object> headers, String charset) throws HttpException {
        return HttpUtils.get(url, params, headers, getProxy(), charset);
    }

    public static String post(String url, Map<String, Object> params, Map<String, Object> headers, String charset) throws HttpException {
        return HttpUtils.post(url, params, headers, getProxy(), charset);
    }

    public static HttpHost getProxy() throws HttpException {
        String proxyPool = HttpUtils.get(proxy_pool_url, null);
        List<ProxyInfo> proxyInfoList = listProxy(proxyPool);
        HttpHost proxy = null;
        synchronized (whold_index) {
            int size = proxyInfoList.size();
            whold_index = (whold_index + 1) % size;
            // 取的ip与上一个ip一样，取下一个，重试3次
            for(int i = 0; i < 3; i++) {
                if(proxyInfoList.get(whold_index).getId() == last_id) {
                    whold_index = (whold_index + 1) % size;
                } else {
                    break;
                }
            }
            ProxyInfo proxyInfo = proxyInfoList.get(whold_index);
            // TODO 暂不支持Https
//            proxy = new HttpHost(proxyInfo.getHostname(), proxyInfo.getPort(), proxyInfo.getType());
            proxy = new HttpHost(proxyInfo.getHostname(), proxyInfo.getPort());
        }
        return proxy;
    }

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
        String ss = HttpUtils.get("http://3c.163.com/spider-ipPool/list.do", null);
        List<ProxyInfo> list = listProxy(ss);
        System.out.println(list);
    }
}