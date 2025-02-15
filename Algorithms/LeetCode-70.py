"""
    爬楼梯
"""
class Solution(object):
    def __init__(self):
        self.memo = {}

    # 用字典存储已经计算过的结果，时间复杂度O(n)
    def climbStairsWithRecursive(self, n: int) -> int:
        if(n in self.memo):
            return self.memo[n]

        # 递归解法
        if n == 1:return 1
        if n == 2: return 2
        self.memo[n] = self.climbStairsWithRecursive(n-1) + self.climbStairsWithRecursive(n-2)
        return self.memo[n]

    # 动态规划
    def climbStairsWithDP(self, n: int) -> int:
        if n == 1: return 1
        if n == 2: return 2
        dp = [0 for _ in range(n+1)]
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n+ 1):
            dp[i] = dp[i-1] + dp[i-2]
        
        return dp[n]

    # 用两个变量实现
    def climbStairsWithDP2(self, n: int) -> int:
        if n == 1: return 1
        if n == 2: return 2
        res = 0;
        pre = 2;
        prePre = 1;
        for i in range(3, n+ 1):
            res = pre + prePre;
            prePre = pre;
            pre = res;
        return res;
    
if __name__ == '__main__':
    solution = Solution()
    print(solution.climbStairsWithDP2(5))
