"""
删除排序链表中的重复元素
"""

class ListNode():
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return str(self.val) + '->' + str(self.next)



class Solution():
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        p = head
        while p.next is not None:
            if p.val == p.next.val:
                p.next = p.next.next
            else:
                p = p.next
        return head

    def deleteDuplicates2(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        head.next = self.deleteDuplicates2(head.next)
        if head.val == head.next.val:
            return head.next
        return head



if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(3)))))
    # print(solution.deleteDuplicates(head))
    print(solution.deleteDuplicates2(head))