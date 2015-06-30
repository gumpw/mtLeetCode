import java.util.*;

/**
 * <p>Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets..</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 Created@2015-06-29 22:41 $
 */
public class Solution {


    /**
     * 3循环,O(n3),Time Limit Exceed... Orz
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if(nums==null||nums.length<3){
            return null;
        }
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        Integer[] numArray = new Integer[3];
        for(int from = 0; from < nums.length-2 ; ++ from  ){
            for(int from2 = from+1 ; from2 < nums.length -1 ; ++ from2 ){
                for(int from3 = from2 +1 ; from3 < nums.length ; ++ from3){
                    if(nums[from] + nums[from2] + nums[from3] == 0){
                        numArray[0] = nums[from] ;
                        numArray[1] = nums[from2] ;
                        numArray[2] = nums[from3];
                        Arrays.sort(numArray);
                        List<Integer> sgList = new ArrayList<Integer>(Arrays.asList(numArray));
                        if(!resList.contains(sgList))
                            resList.add(sgList);
                    }
                }
            }
        }
        return resList;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        //初始化
        Map<Integer,Integer> occurance = new HashMap<Integer,Integer>();
        Map<Integer,List<Integer>> occurMapping = new HashMap<Integer,List<Integer>>();
        occurMapping.put(1,new ArrayList<Integer>());
        occurMapping.put(2,new ArrayList<Integer>());
        occurMapping.put(3,new ArrayList<Integer>());
        for(int n : nums){
            if(occurance.get(n)==null){
                occurance.put(n,1);
            }else{
                occurance.put(n,1+occurance.get(n));
            }
        }
        for(int key : occurance.keySet()){
            if(occurance.get(key)==1){
                occurMapping.get(1).add(key);
            }else if(key==0 && occurance.get(key)>=3){
                occurMapping.get(3).add(key);
            }else{
                occurMapping.get(2).add(key);
            }
        }




        return resList;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new Solution().threeSum(nums));
    }

}