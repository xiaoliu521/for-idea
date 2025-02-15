"""
    移动零
"""

class Solution:

    def moveZeroes(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1
        
        for i in range(j, len(nums)):
            nums[i] = 0
        print(nums)
        

if __name__ == '__main__':
    solution = Solution()
    print(solution.moveZeroes([0,1,0,3,12]))