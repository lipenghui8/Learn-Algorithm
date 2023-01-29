 
package leetcode.editor.cn;
 
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1290 👎 0

import java.util.LinkedList;

public class SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //采用按层遍历方法
        LinkedList<Integer> res=new LinkedList<>();
        //记录上下左右各边界的位置
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        int eleNum=matrix.length*matrix[0].length;
        while(eleNum>=1){
            for(int i=left;i<=right&&eleNum>=1;i++){
                res.add(matrix[top][i]);
                eleNum--;
            }
            top++;
            for(int i=top;i<=bottom&&eleNum>=1;i++){
                res.add(matrix[i][right]);
                eleNum--;
            }
            right--;
            for(int i=right;i>=left&&eleNum>=1;i--){
                res.add(matrix[bottom][i]);
                eleNum--;
            }
            bottom--;
            for(int i=bottom;i>=top&&eleNum>=1;i--){
                res.add(matrix[i][left]);
                eleNum--;
            }
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}