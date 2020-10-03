package com.littlefatz;

//https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
public class MinimumInsertionToBalanceParentheses {

    //https://mp.weixin.qq.com/s/plxWQsTgW6LW3T7yBAXjQg
    public int minInsertions2(String s) {

        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int result = 0;//需要添加的左括号的数目 和 已经添加的右括号的数目
        int right = 0;//需要添加右括号的数目

        char[] chars = s.toCharArray();
        for (int i = 0; i < length;i++) {
            if (chars[i] == '(') {
                /**
                 * 例如这种情况：()(
                 * 当指针遍历到第三个括号：( 的时候，发现right是奇数[right=1]，那么证明需要在这个左括号的左边插入一个右括号
                 * 如果不做任何处理的话，假如遇到的情况是： ()())), 虽然从数目上来说，刚好有2个左括号和4个右括号，但是这种情况不是平衡的
                 * 所以虽然这里需要插入一个右括号，但是不能right++，因为这样就会影响到后面的右括号需求量的计算
                 */

                if (right % 2 == 1) {
                    result++;
                    right--;
                }
                right += 2;
            } else {
                right--;
                if (right == -1) {
                    result++;
                    right = 1;
                }
            }
        }

        return result + right;
    }

    public static void main(String[] args) {
        String data = "(()))(()))()())))";
        MinimumInsertionToBalanceParentheses test = new MinimumInsertionToBalanceParentheses();
        System.out.println(test.minInsertions(data));

    }


    public int minInsertions(String s) {

        int result = 0;
        int rightNeed = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                rightNeed = rightNeed + 2;
                if (rightNeed % 2 == 1) {
                    result++;
                    rightNeed--;
                }
            } else {
                rightNeed--;
                if (rightNeed == -1) {
                    result++;
                    rightNeed = 1;
                }

            }

        }

        return result + rightNeed;

    }
}
