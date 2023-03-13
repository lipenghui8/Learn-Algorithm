//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 428 👎 0


import cn.hutool.core.text.StrBuilder;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if(s==null){
            return null;
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                str.append("  ");
            }
        }
        if(str.length()==0){
            return s;
        }
        int i=s.length()-1;
        s+=str.toString();
        int j=s.length()-1;
        char []ch=s.toCharArray();
        for(;i<j;i--,j--){
            if(ch[i]!=' '){
                ch[j]=ch[i];
            }else {
                ch[j]='0';
                ch[j-1]='2';
                ch[j-2]='%';
                j-=2;
            }
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
