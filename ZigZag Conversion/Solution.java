import java.util.HashMap;
import java.util.Map;

/**
 * <p>The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR".</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 Created@2015-06-27 21:00 $
 */
public class Solution {

    public String convert(String text, int nRows){
        if(nRows<2||text.length()<3){
            return text;
        }
        if(text.length()<=4){
            StringBuilder accum = new StringBuilder(text.length());
            int[] seq = {0,2,1,3};
            for(int i : seq){
                if(text.length()>i){
                    accum.append(text.charAt(i));
                }
            }
            return accum.toString();
        }

        Map<Integer,StringBuilder> dataMap = new HashMap<Integer,StringBuilder>(nRows*2);

        char[] charArray = text.toCharArray();
        //判断竖斜两种情况
        for( int pos = 0 ; pos<charArray.length ; pos++ ){
            int cols = 0;
            if((pos%(2*(nRows-1)))/2==0){
                cols = pos%(nRows-1);
            }else if((pos-nRows+1)%(2*(nRows-1))==0){
                cols = nRows -1;
            }else{
                cols = nRows - pos%(nRows-1)-1;
            }

            if(dataMap.get(cols)==null){
                dataMap.put(cols,new StringBuilder());
            }
            dataMap.get(cols).append(charArray[pos]);
        }
        for(int i=1;i<nRows;i++){
            dataMap.get(0).append(dataMap.get(i).toString());
        }
        return dataMap.get(0).toString();
    }


    public static void main(String[] args) {
//       String aa =  new Solution().convert("ABC",2);
//        System.out.println( aa);
//        System.out.println(1%(2*(3-1)));
//        Integer.MAX_VALUE
//        System.out.println("    ".trim().equals(""));
        char a = '-';
        System.out.println('-'==a);

    }
}
