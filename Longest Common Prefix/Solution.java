import java.util.ArrayList;
import java.util.List;

/**
 * <p>Longest Common Prefix
 Write a function to find the longest common prefix string amongst an array of strings..</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 @2015/6/29 17:01 $
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        //S1:判空
        if(strs==null){
            return null;
        }
        if(strs.length==0){
           return "";
        }
        if(strs.length==1){
           return strs[0];
        }
        //S2:取最短一组
        int[] lenArr = new int[strs.length];
        int shortestLen = strs[0].length();
        for(int pos =0;pos<strs.length;pos++){
            shortestLen = shortestLen > strs[pos].length() ? strs[pos].length() : shortestLen;
            lenArr[pos] = strs[pos].length();
        }
        List<Integer> indexList = new ArrayList<Integer>();
        for(int pos =0 ; pos < lenArr.length ; pos ++ ){
            if(lenArr[pos]==shortestLen){
                indexList.add(pos);
            }
        }
        //S3:找最短一组共值
        String common = common()

        //S4:共值比对其它值

    }



    private String common(String str1,String str2){
        //交换位置
        if(str1.length()>str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if(str2.indexOf(str1)==0){
            return str1;
        }

        for(int lastPos=str1.length()-1;lastPos>=0;lastPos--){
              String str = str1.substring(0,lastPos);
              if(str2.indexOf(str)==0){
                  return str;
              }
        }
        return "";
    }
}