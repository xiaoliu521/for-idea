"""
 回文链表
"""

class ListNode(object):

    def __init__(self, x, next=None):
        self.val = x
        self.next = next
    
    def __str__(self):
        return str(self.val) + '->' + str(self.next)

class Solution(object):

    def isPalindrome(self, head: ListNode) -> bool: 
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        if fast:
            # 奇数节点
            slow = slow.next
            # 反转链表
            reverseList = self.reverseList(slow)
        else:
            # 偶数节点
            # 反转链表
            reverseList = self.reverseList(slow)
 

        while reverseList:
            if reverseList.val != head.val:
                return False
            head = head.next
            reverseList = reverseList.next

        return True

    
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev



if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(2, ListNode(1)))))
    # head = ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    print(solution.isPalindrome(head))