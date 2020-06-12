package com.zxd.mutiThread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  Collections.unmodifiableMap(map)产生一个只读的map
 * @author Xudong Zhang
 *
 */
public class modifyMap {
	   public static void main(String[] args) throws Exception{
	        Map<String, Integer> map = new HashMap<>();
	        map.put("day1", 1);
	        map.put("day2", 2);
	        map.put("day3", 3);
	        map.put("day4", 4);
	        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
			System.out.println(unmodifiableMap.get("day2"));
	        
	    }
}
