package com.wkk.wkkbjsb.business.algorithm;

import java.util.Arrays;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.algorithm
 * @Description : 选择排序
 * @Create on : 2021/7/14 10:47
 * @email : lgy961228@gamil.com
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] a = new int[]{5, 9, 12, 3, 7, 8, 6};

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {

                if (a[i] > a[j]) {
                    int number = a[j];
                    a[j] = a[i];
                    a[i] = number;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
