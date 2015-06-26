import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]..</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 @2015/6/26 12:05 $
 */
public class Solution {


    public List<String> summaryRanges(int[] nums) {

        List<String> rangeList = new ArrayList<String>(nums.length/2+1);
        if(nums.length<2){
            if(nums.length==1) {
                rangeList.add(nums[0] + "");
            }
            return rangeList;
        }

        int from = nums[0] ;
        int before = from;

        for(int pos =1;pos<nums.length;pos++){

            if(nums[pos]-1==nums[pos-1]){
                before = nums[pos];
            }else{
                String range = (from==before) ? from+"" : from + "->" + before;
                rangeList.add(range);

                from = before = nums[pos];
            }

            if(pos== nums.length-1){
                String range = (from==before) ? from+"" : from + "->" + before;
                rangeList.add(range);
            }

        }
        return rangeList;
    }

    public static void main(String[] args) {
          int[] nums = {1,2,4,5,9};

        System.out.println(new Solution().summaryRanges(nums));
    }
}