import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>罗马数字和阿拉伯数字互转.</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 @2015/6/29 12:58 $
 */
public class Solution {

    private static final Map<Integer,Character> intRomanMapping = new HashMap<Integer,Character>();
    private static final Map<Character,Integer> romanIntMapping = new HashMap<Character,Integer>();
    private static final char[] romanArr = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    private static final int[] numArr = { 1, 5, 10, 50, 100, 500, 1000 };
    static{
        for(int i=0;i<romanArr.length;i++){
            intRomanMapping.put(numArr[i],romanArr[i]);
            romanIntMapping.put(romanArr[i],numArr[i]);
        }
    }

    public String intToRoman(int num) {
        int base = 1;
        while(num/base>9){
            base *= 10;
        }
        StringBuffer accum = new StringBuffer();
        while(base>0) {
            int pp = num/base;
            num -= pp*base;
            accum.append(toRoman(pp,base));
            base /= 10;
        }
        return accum.toString();
    }

    public int romanToInt(String s) {
        if(s==null){
            return 0;
        }
//        List<String> splitList = romanSplit(s);
        int res = romanCalc(s);
//        for(String split : splitList){
//           if(split.length()==1){
//               res += romanIntMapping.get(split.charAt(0));
//           }else{
//               res += (-romanIntMapping.get(split.charAt(0))+romanIntMapping.get(split.charAt(1)));
//           }
//
//        }

        return res;
    }

    private static List<String> romanSplit(String s){
        List<String> strList = new ArrayList<String>();
        for(int pos = 0; pos<s.length() ; pos ++ ){
            if(pos!=s.length()-1) {
                int minus = romanIntMapping.get(s.charAt(pos + 1)) - romanIntMapping.get(s.charAt(pos));
                if (minus > 0) {
                    strList.add(s.substring(pos, pos + 2));
                    pos++;
                    continue;
                }
            }

            strList.add(s.charAt(pos)+"");


        }
        return strList;
    }


    private static int romanCalc(String s){
        int res = 0;
        for(int pos = 0; pos<s.length() ; pos ++ ){
            if(pos!=s.length()-1) {
                int minus = romanIntMapping.get(s.charAt(pos + 1)) - romanIntMapping.get(s.charAt(pos));
                if (minus > 0) {
                    res += minus;
                    pos++;
                    continue;
                }
            }

            res += romanIntMapping.get(s.charAt(pos));


        }
        return res;
    }


    private static String toRoman(int num,int base){
        switch (num){
            case 1:
            case 2:
            case 3:
                return multiChar(intRomanMapping.get(base),num);
            case 4:
                return intRomanMapping.get(base)+""+intRomanMapping.get(base*5);
            case 5:
            case 6:
            case 7:
            case 8:
                return intRomanMapping.get(base*5) + multiChar(intRomanMapping.get(base),num-5);
            case 9:
                return intRomanMapping.get(base)+""+intRomanMapping.get(base*10);
        }
        return "";
    }

    public static String multiChar(Character character , int nums){
        StringBuilder accum = new StringBuilder();
        for(int i=0;i<nums;i++){
            accum.append(character);
        }
        return accum.toString();
    }


    public static void main(String[] args) {
//       String result = intToRoman(3999);

//        System.out.println("MMMCMXCIX".substring(3,3+2));
        System.out.println(new Solution().romanToInt("MMMDLXXXVI"));
//        System.out.println(result);
    }



}
