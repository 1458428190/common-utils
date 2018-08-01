package com.gdufe.common.util;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: GuanQihua
 * @Description: OkHttp工具类,比HttpClient好用N倍！
 * @Date: 2018/8/1  23：00
 */
public class OkHttpUtils {

    /**
     *   OkHttpClient使用了连接池，应保持一个实例存在
     *   可以定制配置连接池
     */
    private static OkHttpClient okHttpClient = new OkHttpClient();
    /**
     *  同步GET方法
     * @throws Exception
     */
    public static void syncGet(String url) throws Exception{
        Request request = new Request.Builder().url(url).build(); // 创建一个请求
        Response response = okHttpClient.newCall(request).execute(); // 返回实体
        if (response.isSuccessful()) { // 判断是否成功
            /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
             * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
             * 因为string() 方法会将整个文档加载到内存中。*/
            System.out.println(response.body().string()); // 打印数据
        }else {
            System.out.println("失败"); // 链接失败
        }
    }

    /**
     * 异步Get请求
     */
    public static void asyncGet(String url) {
        Request request = new Request.Builder().url(url).build(); // 创建一个请求
        okHttpClient.newCall(request).enqueue(new Callback() { // 回调

            public void onResponse(Call call, Response response) throws IOException {
                // 请求成功调用，该回调在子线程
                System.out.println(response.body().string());
            }

            public void onFailure(Call call, IOException e) {
                // 请求失败调用
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * 设置超时
     * @throws IOException
     */
    public static void timeOutPost(String url) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置链接超时
                .writeTimeout(10, TimeUnit.SECONDS) // 设置写数据超时
                .readTimeout(30, TimeUnit.SECONDS) // 设置读数据超时
                .build();
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        System.out.println("Response completed: " + response);
    }

}
