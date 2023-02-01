 
package leetcode.editor.cn;
 
//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 706 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> rset=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for (int i : nums1) {
            rset.add(i);
        }
        for (int i : nums2) {
            if(rset.contains(i)){
                res.add(i);
            }
        }
        return res.stream().mapToInt(x->x).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}