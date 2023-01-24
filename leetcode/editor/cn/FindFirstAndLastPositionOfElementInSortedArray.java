 
package leetcode.editor.cn;
 
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2107 👎 0

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int flag=0;
        int []res= {-1,-1};
        int right=nums.length;
        //搜索左端点
        while(left<right){
            int mid=left+(right-left)/2;
            if(target<nums[mid]){
                right=mid;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                flag=1;
                right=mid;
            }
        }
        if(flag==0){
            return res;
        }
        res[0]=left;
        left=0;right= nums.length;
        //搜索右端点
        while(left<right){
            int mid=left+(right-left)/2;
            if(target<nums[mid]){
                right=mid;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                flag=1;
                left=mid+1;
            }
        }
        res[1]=right-1;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}