package com.littlefatz;


import java.util.*;

//https://leetcode-cn.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List> results = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            String word = strs[i];
            for (int j = 0; j < word.length(); j++) {
                count[word.charAt(j) - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int k : count) {
                builder.append(k);
            }
            String key = builder.toString();
            if (!results.containsKey(key)) {
                results.put(key, new ArrayList());
            }
            results.get(key).add(word);

        }

        return new ArrayList(results.values());

    }

    //参考题解
    //关键点在于把26个英文字母的出现次数，放到对应的数组位置中做统计
    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs==null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        //Arrays.sort(strs);
        for (String s:strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }

        for(String key: map.keySet()) {
            Collections.sort(map.get(key));
        }
        return new ArrayList<List<String>>(map.values());
    }
}
