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


    /**
     * 方法1:找最短、最短找共同、最短共同与其它值找共同
     *
     *   思路清晰、慢
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
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
            if(strs[pos]==null){
                return "";
            }
            shortestLen = shortestLen > strs[pos].length() ? strs[pos].length() : shortestLen;
            lenArr[pos] = strs[pos].length();
        }
        List<Integer> indexList = new ArrayList<Integer>();
        List<Integer> otherList = new ArrayList<Integer>();
        for(int pos =0 ; pos < lenArr.length ; pos ++ ){
            if(lenArr[pos]==shortestLen){
                indexList.add(pos);
            }else{
                otherList.add(pos);
            }
        }
        //S3:找最短一组共值
        String commonStr = common(strs,indexList,null);

        //S4:共值比对其它值
        String resultStr = common(strs,otherList,commonStr);

        return resultStr;
    }


    public String longestCommonPrefix(String[] strs) {
        //S1:判空
        if(strs==null||strs.length==0 || strs[0] == null){
            return "";
        }
        //加快速度
        if(strs.length==1){
            return strs[0];
        }
        //挑第一个元素做外层
        int pos = 0;
        for(int outer = 0 ; outer< strs[0].length() ; ++ outer, pos = outer){
            char ch = strs[0].charAt(outer);
            for(String single : strs){
                if(single==null||single.length()<=outer||single.charAt(outer)!=ch){
                        return strs[0].substring(0,outer);
                }

            }
        }
        return strs[0].substring(0,pos);
    }

    private String common(final String[] strs, List<Integer> indexList,String str) {
        String commonStr = str==null? strs[indexList.get(0)] : str ;
        for(int pos : indexList){
            commonStr = common(commonStr,strs[pos]);
        }
        return commonStr;
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

    public static void main(String[] args) {
        String[] hello = {"aa"};

        System.out.println(new Solution().longestCommonPrefix(hello));

    }
}