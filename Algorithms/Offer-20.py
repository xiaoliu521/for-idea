class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return str(self.val) + '->' + str(self.next)


class Solution(object):

    def findKthToLast(self, head, k):
        right = head
        left = head

        for i in range(k):
            if right is None:
                return None
            right = right.next
        
        while right:
            right = right.next
            left = left.next
        return left
    

if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(solution.findKthToLast(head, 2))