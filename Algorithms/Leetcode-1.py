"""
数组-两数之和
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
