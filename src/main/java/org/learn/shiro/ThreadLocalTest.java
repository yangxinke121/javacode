package org.learn.shiro;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: yxk
 * @date: 2019-04-04 13:56
 */
public class ThreadLocalTest {

    public static Map<String, String> map = new HashMap<>();

    {
        map.put("1", "1");
    }

    public static void main(String[] args) {

    }
}
