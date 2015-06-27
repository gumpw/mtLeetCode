import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 @2015/6/24 15:40 $
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString(){
        return Solution.getNum(this)+"";
    }
}

public class Solution {

    public ListNode method1(ListNode listNode1, ListNode listNode2) {
        long sumNum = getNum(listNode1) + getNum(listNode2);

        System.out.println(listNode1+"+"+listNode2+"="+sumNum);

        return numToNode(sumNum);
    }

    /**
     * 转为long值，计算后转回ListNode
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode pointer = listNode1.next;
        ListNode pointer2 = listNode2.next;

        int first =  listNode1.val+listNode2.val;
        boolean upPos = first>9;
        first %=10;
        ListNode returnPointer = new ListNode(first);
        ListNode pointer3 = returnPointer;
        while(pointer!=null||pointer2!=null){
            int val =  pointer==null? 0 : pointer.val;
            int val2 = pointer2 == null ? 0 :pointer2.val;
            int sumVal = upPos ? val+val2+1 : val+val2;

            upPos=sumVal>9;
            sumVal %= 10;

            pointer3.next  = new ListNode(sumVal);

            pointer3 = pointer3.next;
            pointer = pointer==null ?null  :pointer.next;
            pointer2 = pointer2 == null ? null : pointer2.next;
        }

        if(upPos){
            pointer3.next = new ListNode(1);
        }

        return returnPointer;
    }

    public static ListNode numToNode(Long num){
        char[] chars = (num+"").toCharArray();
        ListNode listNode = new ListNode(Character.digit(chars[chars.length-1],10));
        ListNode pointer = listNode;
        for(int pos=chars.length-2;pos>=0;pos--){
             pointer.next = new ListNode(Character.digit(chars[pos],10));
             pointer = pointer.next;
        }
        return listNode;
    }

    public static long getNum(ListNode listNode){
       if(listNode==null){
           return 0;
       }

       List<Integer> numList = new ArrayList<Integer>();
       while(listNode.next!=null){
            numList.add(listNode.val);
           listNode = listNode.next;
       }
       numList.add(listNode.val);
       Integer[] numArray = new Integer[numList.size()];
        numList.toArray(numArray);
       long returnVal = 0;
       for(int pos=numArray.length-1;pos>=0;pos--){
           returnVal += numArray[pos]*Math.pow(10,pos);
       }
       return returnVal;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(7);
//        listNode2.next.next.next = new ListNode(6);
//        listNode2.next.next.next.next = new ListNode(4);
//        System.out.println(getNum(listNode));
        System.out.println(new Solution().addTwoNumbers(listNode,listNode2));
    }


}
