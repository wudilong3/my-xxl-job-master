package com.xxl.job.admin.core.util;

import com.xxl.job.admin.core.model.XxlJobLogChild;

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

//        public static Map <String,List<String>> getDiffrent(List<XxlJobLogChild>  xxlJobLogChildList,
//                                                            List<Map>  xxlJobInfos){
//        Map temMap = new HashMap();
//        for (XxlJobLogChild xxlJobLogChild: xxlJobLogChildList){
//            temMap.put(xxlJobLogChild.getChildJobId(),xxlJobLogChild.getPrentCount());
//        }
//        List<XxlJobLogChild> addXxlJobLogChildList = new ArrayList<>();
//        Map resMap = new HashMap();
//        for (Map map1 :xxlJobInfos){
//            if (temMap.get(map1.get("id"))==null){
//                resMap.put(map1.get("id"),false);
//                XxlJobLogChild temXxl = new XxlJobLogChild();
//                temXxl.setChildJobId((Integer) map1.get("id"));
//                temXxl.setUpdateTime(new Date().getTime());
//                addXxlJobLogChildList.add(temXxl);
//            }else {
//                if (temMap.get(map1.get("id")) == map1.get("prent_count")){
//                    resMap.put(map1.get("id"),true);
//                } else {
//                    resMap.put(map1.get("id"),false);
//                }
//            }
//
//        }
//    }
}
