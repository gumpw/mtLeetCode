import java.util.*;

/**
 * <p>Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2.</p>

    <p>肯定是先排序,后查找</p>Fixme:思路有问题
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
        bubbleUp(nums, pos);
        for(int offset=0;offset<nums.length;offset++){
            int firstNum = nums[offset];
            for(int offset2=offset+1;offset2<nums.length;offset2++){
               int calc = firstNum+nums[offset2];
               if(calc==target){
                   int[] arr = new int[]{pos[offset2], pos[offset]};
                   Arrays.sort(arr);
                   return arr;
               }else if(calc>target){
                   //跳出内层循环
                   break;
               }
            }
        }
        return  null;
    }

    /**
     * Method1:快速排序
     *
     * @param nums
     * @param pos
     */
    private void fastSort(int[] nums,int[] pos){
        

    }

    /**
     * Method2:不排序，用多层存储多位置
     * 时间复杂度:O(n)
     * @param nums
     * @param target
     */
    private int[] noneSort(int[] nums, int target){
        Map<Integer,List<Integer>> hashMap = new HashMap<Integer, List<Integer>>(nums.length*3/2);
        for(int pos=0;pos<nums.length;pos++){
            List<Integer> dataList = hashMap.get(nums[pos]);
            if(dataList==null){
                dataList = new ArrayList<Integer>(3);
                dataList.add(pos+1);
                hashMap.put(nums[pos],dataList);
            }else{
                dataList.add(pos+1);
            }
        }

        for(int origin : nums){
            int search = target-origin;
            if(hashMap.get(search)!=null) {
                int[] retArr = null;
                if (search == origin) {
                    if(hashMap.get(search).size()==1){
                        continue;
                    }
                    retArr =new int[]{hashMap.get(search).get(0), hashMap.get(search).get(1)};
                } else {
                    retArr =new int[]{hashMap.get(origin).get(0), hashMap.get(search).get(0)};
                }
                Arrays.sort(retArr);
                return retArr;
            }
        }

        return null;
    }

    /**
     * Method3:冒泡排序
     * 时间复杂度:O(n2)
     * @param nums
     * @param pos
     */
    private void bubbleUp(int[] nums,int[] pos){
        for(int off=nums.length-1;off>=0;off--){
            for(int comp=nums.length-1;comp>=nums.length-off;comp--){
                if(nums[comp]<nums[comp-1]){
                    exchange(nums,comp,comp-1);
                    exchange(pos,comp,comp-1);
                }
            }
        }
        
    }

    private void exchange(int[] arr,int pos1,int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }


    public static void main(String[] args) {
//        int[] num = {3,4,0,7,5};
//        int[] pos = {1,2,3,4,5};
//        new Solution().bubbleUp(num,pos);
//        for(int i:num)
//        System.out.print(i + ";");
//        for(int b:pos){
//            System.out.print(b +",");
//        }

        int [] num = {0,4,3,0,3};
        int[] ret = new Solution().noneSort(num, 0);
        for(int bb : ret){
            System.out.println(bb);
        }

    }

}
