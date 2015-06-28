/**
 * <p>Palindrome Number.</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 Created@2015-06-28 09:56 $
 */
public class Solution {

    /**
     * 计算出逆序数字,溢出的情况?
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if(x<0){
            return false;
        }
        int reverse = 0 , y = x;
        while(y!=0){
            reverse = reverse*10 + y%10;
            y /= 10;
        }
        return reverse ==x;
    }

    /**
     * 改进版, faster
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int y = x;
        String xStr = x+"";
        for(int pos =0;y!=0; y /= 10,pos++){
            int reverseNum = y%10;
            int num = xStr.charAt(pos)-'0';//计算数字
            if(reverseNum!=num){
                return false;
            }
        }
        return true;
    }

    /**
     * 不使用字符串，速度比字符串要慢
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        int y = x,base =1;
        while(x/base >=10){
            base *= 10;
        }
        while(y!=0){
            int reverseNum = y%10;
            int num = x/base;
            if(reverseNum!=num){
                return false;
            }
            y /=10;
            x -= num*base;
            base /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().isPalindrome2(1001));
    }

}
