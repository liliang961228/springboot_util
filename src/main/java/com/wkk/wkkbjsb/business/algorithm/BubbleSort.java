package com.wkk.wkkbjsb.business.algorithm;

import java.util.Arrays;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.algorithm
 * @Description : 冒泡排序
 * @Create on : 2021/7/14 09:57
 * @email : lgy961228@gamil.com
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{5, 9, 12, 3, 7, 8, 6};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int number = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = number;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
