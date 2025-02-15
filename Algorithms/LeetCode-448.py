"""
找到所有数组中消失的数字
"""
class Solution:

    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        """
        Do not return anything, modify nums in-place instead.
        """
        return [i for i in range(1, len(nums) + 1) if i not in nums]

    def findDisappearedNumbers2(self, nums: list[int]) -> list[int]:
        n = len(nums)
        
        for num in nums:
            index = abs(num) - 1
            if nums[index] > 0:
                nums[index] *= -1
        return [i for i in range(1, n + 1) if nums[i - 1] > 0]

if __name__ == '__main__':
    solution = Solution()
    print(solution.findDisappearedNumbers2([4,3,2,7,8,2,3,1]))