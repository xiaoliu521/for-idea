"""
    合并两个有序数组
"""

class Solution:


    # 双指针 
    def merge(self, nums1, m, nums2, n):
        k = m + n

        nums1Index = m - 1
        nums2Index = n - 1

        for i in range(k - 1, -1, -1):
            if(nums2Index < 0):
                nums1[i] = nums1[nums1Index]
                nums1Index -= 1
                break
            elif (nums1Index < 0):
                nums1[i] = nums2[nums2Index]
                nums2Index -= 1
            elif nums2[nums2Index] > nums1[nums1Index]:
                nums1[i] = nums2[nums2Index]
                nums2Index -= 1
            else:
                nums1[i] = nums1[nums1Index]
                nums1Index -= 1
        return nums1


if __name__ == '__main__':
    solution = Solution()
    print(solution.merge([1,2,3,0,0,0], 3, [2,5,6], 3))