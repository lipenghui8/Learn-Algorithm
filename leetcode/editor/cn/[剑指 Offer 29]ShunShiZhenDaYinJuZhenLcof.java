 
package leetcode.editor.cn;
 
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// Related Topics 数组 矩阵 模拟 👍 488 👎 0

import java.util.LinkedList;

public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //特殊情况要放到最前面判断
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        int []res=new int[matrix.length*matrix[0].length];
        int k=0;
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int eleNum=matrix.length*matrix[0].length;
        while(eleNum>=1){
            for(int i=left;i<=right&&eleNum>=1;i++){
                res[k++]=matrix[top][i];
                eleNum--;
            }
            top++;
            for(int i=top;i<=bottom&&eleNum>=1;i++){
                res[k++]=matrix[i][right];
                eleNum--;
            }
            right--;
            for(int i=right;i>=left&&eleNum>=1;i--){
                res[k++]=matrix[bottom][i];
                eleNum--;
            }
            bottom--;
            for(int i=bottom;i>=top&&eleNum>=1;i--){
                res[k++]=matrix[i][left];
                eleNum--;
            }
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}