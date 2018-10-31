/**
 * @(#)ProxyInfo.java, 2018/10/26.
 * <p/>
 * Copyright 2018 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gdufe.common.util.http.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: laichengfeng (laichengfeng @ corp.netease.com)
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