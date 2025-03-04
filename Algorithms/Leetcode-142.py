
"""
  环状链表2
  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
"""

class ListNode():
    def __init__(self, x, next=None):
        self.val = x
        self.next = next

    def __str__(self):
        return str(self.val) + '->' + str(self.next)


class Solution():
    
    def bcycle(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return False

        slow = head
        fast = head.next

        loopExists = False
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                loopExists = True
                break
    
        if loopExists:
            while head != fast:
                head = head.next
                fast = fast.next
            return head
        return None

if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(solution.bcycle(head))
