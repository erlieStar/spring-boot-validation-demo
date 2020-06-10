package com.javashitang.pojo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: lilimin
 * @Date: 2019/10/20 20:43
 */
public class StudentTest {

    public void showBlank() {
        assertEquals(true, StringUtils.isBlank(null));
        assertEquals(true, StringUtils.isBlank(""));
        // 空格
        assertEquals(true, StringUtils.isBlank(" "));
        // 回车
        assertEquals(true, StringUtils.isBlank("    "));
    }

    @Test
    public void str() {
        String str = "  ".trim();
        System.out.println(str.length());
    }
}