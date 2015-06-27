/**
 * <p>.</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 Created@2015-06-27 20:18 $
 */
public class Solution {
    public int reverse1(int x) {
        long abs = x;
        String strVal = new StringBuffer(Math.abs(abs)+"").reverse().toString();
        Long val = (x<0 ? -1:1)*Long.valueOf(strVal);
        return (val>Integer.MAX_VALUE|| val< Integer.MIN_VALUE) ? 0 : val.intValue();
    }

    /**
     * 这个方法要快一点
     * @param x
     * @return
     */
    public int reverse(int x){
        long res = 0;
        while(x!=0){
            res = res*10 + x%10;
            x /= 10;
        }
        return (res>Integer.MAX_VALUE|| res< Integer.MIN_VALUE) ? 0 : Long.valueOf(res).intValue();
    }

    public static void main(String[] args){
        long a = new Solution().reverse(-2147483648);
        System.out.println( a);
//        System.out.println(Math.abs(-2147483648));
    }

}
