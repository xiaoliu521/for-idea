"""
剑指 Offer 22. 链表中倒数第k个节点
"""
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
        
    def __str__(self):
        return str(self.val) + '->' + str(self.next)

class Solution(object):
    def getKthFromEnd(self, head, k):
        if head is None:
            return None
        if k <= 0:
            return None
        fast = head
        slow = head

        while fast and k - 1 > 0:
            fast = fast.next
            k -= 1
        
        if fast is None or fast.next is None:
            return None
        
        while fast.next:
            fast = fast.next
            slow = slow.next
        return slow
    
if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(solution.getKthFromEnd(head, 12))
    