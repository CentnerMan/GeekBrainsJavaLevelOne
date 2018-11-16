package ru.lebedev.se;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    @Test
    public void test() {
        final Map<String, String> map = new HashMap<>();
        map.put("100", "Ivanoff");
        map.put("101", "Petroff");
        map.put("102", "Sidoroff");

        System.out.println(map.get("102"));
    }
}
