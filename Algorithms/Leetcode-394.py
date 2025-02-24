"""
Leetcode-394
字符串解码
    https://leetcode-cn.com/problems/decode-string/
"""
class Solution(object):

    def __init__(self):
        self.stack = []

    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """ 
        num = 0
        res = ""
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            # 遇到[ 就将数字和[入栈
            elif c == "[":
                self.stack.append(num) 
                num = 0
                self.stack.append("[")
            elif c == "]":
                str = ""
                while self.stack[-1] != "[":
                    str = self.stack.pop() + str
                self.stack.pop()
                num = self.stack.pop()
                if self.stack:
                    self.stack.append(num * str)
                else:
                    res = res + num * str
                num = 0
            else:
                if self.stack:
                    self.stack.append(c)
                else:
                    res = res + c
        return res 

if __name__ == '__main__':
    solution = Solution()
    print(solution.decodeString("3[a]2[bc]cc"))
    print(solution.decodeString("3[a2[c]]"))
    print(solution.decodeString("2[abc]3[cd]"))
    print(solution.decodeString("3[a2[b]c]"))