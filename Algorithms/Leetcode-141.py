"""
环状链表
"""
class ListNode (object):
    def __init__(self, x, next=None):
        self.val = x
        self.next = next    
    


class Solution(object):

    def hasCycle(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return False
        hashset = set()
        while head.next is not None:
            if head in hashset:
                return True
            hashset.add(head)
            head = head.next
        return False

    def hasCycle2(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return False
        
        slow = head
        fast = head.next 
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
            
        return False


if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(hash(head))
    print(solution.hasCycle(head))