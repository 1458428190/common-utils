package com.gdufe.common.util;

/**
 * @Author: GuanQihua
 * @Description: 分页工具类
 * @Date: 2018/8/1  12.00
 */
public class PagingUtils {
    /**
     *  根据总数统计总页数
     *  count : 数据总数
     *  maxNum : 一页显示多少
     */
    public static long getTotalPage(long count, long maxNum){
       if(count < 0 || maxNum <= 0) {
           throw new IllegalArgumentException("count < 0 or maxNum <= 0");
       }
       return (count + maxNum - 1) / maxNum;
    }

    /**
     *  根据页码,计算表中第几行 limit(start, maxNum);
     * @param page : 页码
     * @param maxNum : 一页显示多少
     * @return
     */
    public static long getStart(long page, long maxNum){
       if(page <= 0 || maxNum <= 0) {
           throw new IllegalArgumentException("page <=0 or maxNum <= 0");
       }
       return (page - 1) * maxNum;
    }

}
