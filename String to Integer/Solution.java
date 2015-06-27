import java.math.BigDecimal;

/**
 * <p>.</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 Created@2015-06-27 23:22 $
 */
public class Solution {
    public int myAtoi(String str) {
        if(str==null||"".equals(str.trim())){
            return 0;
        }
        BigDecimal returnVal = null;
        try{
            returnVal = convert(str);
        }catch(Exception e){
            return 0;
        }
        return returnVal.compareTo(new BigDecimal(Integer.MAX_VALUE))>0||returnVal.compareTo(new BigDecimal(Integer.MIN_VALUE))<0 ?
                (returnVal.compareTo(new BigDecimal(Integer.MAX_VALUE))>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE)
                : returnVal.intValue();
    }

    private BigDecimal convert(String str){
        char[] charArray= str.trim().toCharArray();
        StringBuilder accum = new StringBuilder();
        for(int ch = 0; ch<charArray.length;ch++){
            if(Character.isDigit(charArray[ch])||(ch==0&&(charArray[ch]=='+'||charArray[ch]=='-'))){
                accum.append(charArray[ch]);
            }else{
                break;
            }
        }
        return new BigDecimal(accum.toString());
    }

    public static void main(String[] args) {
        String[] testCases = new String[]{"-1","a","-12d","33","-21474836480","2147483647","214748364799","922337203685477589080989080909","+jfksdjfksd","32jk-j324"};

        for(String testCase : testCases)
        System.out.println(
        new Solution().myAtoi(testCase));
    }
}
