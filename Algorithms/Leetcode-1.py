"""
数组-两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

2025-04-10
2998 点位
大盘还有反抽
然后下杀到3040点
通信设备 会遭遇回调 ，回调后加仓
日线级别底部
 

 明天再涨，下午两点出
"""

class Solution(object):

    # 用一个字典来存储数字和下标，时间复杂度O(n)
    def twoSum(self, nums, target): 
        meno = {}
        for i in range(len(nums)):
            if (target - nums[i]) in meno:
                return [meno[target - nums[i]], i]
            meno[nums[i]] = i
        return []

if __name__ == '__main__':
    solution = Solution()
    print(solution.twoSum([2,7,11,15], 9))
