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
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        int offset = 0, ending = nums.length - 1;
        while( offset < ending ){
            int num0 = nums[offset], pos1 = offset + 1, pos2 = ending;
            while(pos1<pos2){
                int num1 = nums[pos1], num2 = nums[pos2], sum = num0 + num1 + num2;
                if(sum==0) {
                    List<Integer> integerList = Arrays.asList(num0,nums[pos1],nums[pos2]);
                    Collections.sort(integerList);
                    resList.add(integerList);
                }
                if (sum <= 0) while (nums[pos1] == num1 && pos1 < pos2) pos1++;
                if (sum >= 0) while (nums[pos2] == num2 && pos1 < pos2) pos2--;
            }
            offset ++ ;
        }
        return resList;
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> triples = new ArrayList();
//        Arrays.sort(nums);
//        int i = 0, last = nums.length - 1;
//        while (i < last) {
//            int a = nums[i], j = i+1, k = last;
//            while (j < k) {
//                int b = nums[j], c = nums[k], sum = a+b+c;
//                if (sum == 0) triples.add(Arrays.asList(a, b, c));
//                if (sum <= 0) while (nums[j] == b && j < k) j++;
//                if (sum >= 0) while (nums[k] == c && j < k) k--;
//            }
//            while (nums[i] == a && i < last) i++;
//        }
//        return triples;
//    }


    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};//
        System.out.println(new Solution().threeSum(nums));
        System.out.println(System.currentTimeMillis()-millis);
    }

}