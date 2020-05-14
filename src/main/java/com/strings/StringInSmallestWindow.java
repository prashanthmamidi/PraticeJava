package com.strings;

import java.util.HashMap;
import java.util.Map;

public class StringInSmallestWindow {

    //https://github.com/mission-peace/interview/tree/master/src/com/interview/string

    public static String pickSubstring(String samp_str ,String pat_str)
    {
        int ln1  = samp_str.length();
        int ln2  = pat_str.length();
        if(ln1 < ln2)
        {
            System.out.println("No such window can exist");
            return "";
        }
        int gvn_strg [] = new int[256];
        int pat_stgr [] = new int[256];
        for(int i=0;i<ln2;i++)
            pat_stgr[pat_str.charAt(i)]++;
        int ctr = 0,start = 0,start_index = -1,min_length = Integer.MAX_VALUE;
        for(int j=0;j<ln1;j++)
        {
            gvn_strg[samp_str.charAt(j)]++;
            if(pat_stgr[samp_str.charAt(j)] != 0 && gvn_strg[samp_str.charAt(j)] <= pat_stgr[samp_str.charAt(j)])
                ctr++;
            if(ctr == ln2)
            {
                while(gvn_strg[samp_str.charAt(start)] > pat_stgr[samp_str.charAt(start)] || pat_stgr[samp_str.charAt(start)] == 0)
                {
                    if(gvn_strg[samp_str.charAt(start)] > pat_stgr[samp_str.charAt(start)] || pat_stgr[samp_str.charAt(start)] == 0)
                        gvn_strg[samp_str.charAt(start)]--;
                    start++;
                }
                int length_window = j - start + 1;
                if(min_length > length_window)
                {
                    min_length = length_window;
                    start_index = start;
                }
            }
        }
        if(start_index == -1)
        {
            System.out.println("No such window exists");
            return "";
        }
        return samp_str.substring(start_index,start_index + min_length);
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer val = countMap.get(ch);
            if (val == null) {
                val = 0;
            }
            countMap.put(ch, val + 1);
        }
        int start = 0;
        int currLen = t.length();
        int minWindow = Integer.MAX_VALUE;
        int minStart = 0;
        int i = 0;
        while (i < s.length()) {
            Integer val = countMap.get(s.charAt(i));
            if (val == null) {
                i++;
                continue;
            }
            if (val > 0) {
                currLen--;
            }
            val--;
            countMap.put(s.charAt(i), val);
            while (currLen == 0) {
                if (minWindow > i - start + 1) {
                    minWindow = i - start + 1;
                    minStart = start;
                }
                Integer val1 = countMap.get(s.charAt(start));
                if (val1 != null) {
                    if (val1 == 0) {
                        break;
                    } else {
                        val1++;
                        countMap.put(s.charAt(start), val1);
                    }
                }
                start++;
            }
            i++;
        }

        return minWindow != Integer.MAX_VALUE ? s.substring(minStart, minStart + minWindow) : "";
    }

    public static void main(String args[])
    {
        String str = "welcome to w3resource";
        String pat = "tower";
        System.out.println("The given string is: "+str);
        System.out.println("Characters to find in the main string are: "+pat);

        System.out.print("The smallest window which contains the finding characters is : " + pickSubstring(str, pat));
//        System.out.print("The smallest window which contains the finding characters is : " + pickSubstring("this is a test string", "tist"));
        System.out.print("The smallest window which contains the finding characters is : " + minWindow("this is a test string", "tist"));
    }
}
