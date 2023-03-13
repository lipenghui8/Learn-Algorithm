//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 906 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int []getNext(String s){
        int[]next=new int[s.length()];
        int j=0;
        next[0]=j;
        for(int i=1;i<s.length();i++){
            while (j>0&&s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    public boolean repeatedSubstringPattern(String s) {
        int[]next=getNext(s);
        int len=s.length();
        if(next[len-1]!=0&&len%(len-next[len-1])==0){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
