package com.example.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //validation
        if(s == null || s.length()<2) return s.length();
        //define pointers
        int r=0, l=0;
        //define table
        Map<Character, Integer> hm = new HashMap<>();
        //define maxLength
        int maxLength = 0;
        //find longest substring
        while (r < s.length()){
            // add current element to map
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0) +1);
            // check if
            while(hm.size() != (r-l +1)){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                if (hm.get(s.charAt(l)) == 0){
                    hm.remove(s.charAt(l));
                }
                l++;
            }
            // update max length
            maxLength = Math.max(maxLength, (r-l+1));
            // update pointers
            r++;
        }
        //return length
        return maxLength;
    }
}
