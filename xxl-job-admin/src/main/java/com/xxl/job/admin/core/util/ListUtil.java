package com.xxl.job.admin.core.util;

import java.util.*;

public class ListUtil {
    public static Map <String,List<String>> getDiffrent(String[] newList1, String[] oldList2) {

        Map<String,List<String>> retMap = new HashMap<>();
        if (newList1 == null || newList1.length == 0||oldList2 == null || oldList2.length == 0){

            retMap.put("addChildIds",newList1 == null ? null : Arrays.asList(newList1));
            retMap.put("subChildIds",oldList2 == null ? null : Arrays.asList(oldList2));
            return retMap;
        }
        List<String> addChildIds = new ArrayList <String>();
        List<String> subChildIds = new ArrayList <String>();
        Map<String, Integer> map = new HashMap<String, Integer>(newList1.length + oldList2.length);

        for (String string : newList1){
            map.put(string, 1);
        }
        for (String string : oldList2){
            Integer count = map.get(string);
            if (count != null) {
                map.put(string, --count);
                continue;
            }
            map.put(string,-1);
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                addChildIds.add(entry.getKey());
            }

            if (entry.getValue() == -1){
                subChildIds.add(entry.getKey());
            }
        }
        retMap.put("addChildIds",addChildIds);
        retMap.put("subChildIds",subChildIds);
        return retMap;
    }
}
