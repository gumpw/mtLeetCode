import java.util.*;

/**
 * <p>Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2.</p>

    <p>肯定是先排序,后查找</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 Created@2015-06-24 08:22 $
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] pos = new int[nums.length];
        for(int offset=0;offset<pos.length;offset++){
            pos[offset] = offset+1;
        }
        sort(nums,pos);
        int[] resultArray = new int[2];
        for(int offset=0;offset<nums.length;offset++){
            int firstNum = nums[offset];
            for(int offset2=offset+1;offset2<nums.length;offset2++){
               int secondNum = nums[offset2];
                int calc = firstNum+secondNum;
               if(calc==target){
                    resultArray[0] = pos[offset];
                    resultArray[1] = pos[offset2];
               }else if(calc>target){
                   //跳出内层循环
                   break;
               }
            }
        }
        return  resultArray;
    }

    /**
     * 对nums进行从小到大排序，pos做相应调整
     * @param nums
     * @param pos
     */
    private void sort(int[] nums,int[] pos){


    }


}
