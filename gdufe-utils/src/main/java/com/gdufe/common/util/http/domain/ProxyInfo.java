package com.gdufe.common.util.http.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: laichengfeng
 * @description: 代理信息
 * @Date: 2018/10/26 16:00
 */

@Data
@NoArgsConstructor
public class ProxyInfo {
    int id;

    String hostname;

    int port;

    String address;

    String anonType;

    String account;

    String password;

    String type;
}