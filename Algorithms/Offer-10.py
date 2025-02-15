"""
斐波那契数列
"""
class Solution(object):

    def fib(self, n):
        if n == 0: return 0
        if n == 1: return 1 
        
        # 定义前一个
        pre = 1
        prePre = 0

        for i in range(2, n+ 1):
            res = pre + prePre
            prePre = pre
            pre = res
        return res

    def fibWithRecursive(self, n: int) -> int:
        if n == 0: return 0
        if n == 1: return 1 
        return self.fibWithRecursive(n-1) + self.fibWithRecursive(n-2)

if __name__ == '__main__':
    solution = Solution()
    print(solution.fibWithRecursive(5))