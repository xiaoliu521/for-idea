
class ListNode(object):

    def __init__(self, x, next=None):
        self.val = x
        self.next = next
    
    def __str__(self):
         return str(self.val) + '->' + str(self.next)


class Solution(object):

    def reverseList(self, head : ListNode):
        if head is None or head.next is None:
            return head 

        prev = None 
        curr = head 

        while curr != None:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        
        return prev

if __name__ == '__main__':
    solution = Solution()
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(solution.reverseList(head))