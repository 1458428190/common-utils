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
    public static long getTotalPage( long count , int maxNum){
        if(count == 0){
            count = 1;
        }
        long totalPage = count / maxNum + (count % maxNum >= 1 ? 1 : 0);
        return totalPage;
    }

    /**
     *  根据页码,计算表中第几行 limit(start , maxNum);
     * @param page : 页码
     * @param maxNum : 一页显示多少
     * @return
     */
    public static int getStart(int page , int maxNum){
        int start = 0;
        if(page == 1) {
            start = 0;
        }
        else {
            start = (page - 1) * maxNum;
        }
        return start;
    }

}
