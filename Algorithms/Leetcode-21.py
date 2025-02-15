"""
合并两个有序链表
"""
class ListNode():
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
    def __str__(self):
        return str(self.val) + '->' + str(self.next)



class Solution:

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        
        resultNode = ListNode(0)
        p = resultNode
        
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                p.next = l1
                l1 = l1.next
            else:
                p.next = l2
                l2 = l2.next
            p = p.next

        if l1 is not None:
            p.next = l1
        if l2 is not None:
            p.next = l2

        return resultNode.next


    def mergeTwoLists2(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists2(l1.next, l2)
            return l1
            
        l2.next = self.mergeTwoLists2(l1, l2.next)
        return l2



if __name__ == '__main__':
    solution = Solution()
    l1 = ListNode(1, ListNode(2, ListNode(4)))
    l2 = ListNode(1, ListNode(4, ListNode(5)))
    # print(solution.mergeTwoLists(l1, l2))
    print(solution.mergeTwoLists2(l1, l2))