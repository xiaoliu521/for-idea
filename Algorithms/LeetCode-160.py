

class ListNode(object):
    def __init__(self, x, next=None):
        self.val = x    
        self.next = next
    
    def __str__(self):
        return str(self.val) + '->' + str(self.next)

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        
        if headA is None or headB is None:
            return None 
        PA = headA
        PB = headB

        while PA != PB:
            if PA is None:
                PA = headB
            if PB is None:
                PB = headA
            PA = PA.next
            PB = PB.next

        return PA

    def getIntersectionNode2(self, headA, headB):
        if headA is None or headB is None:
            return None
        
        L1 = 0
        L2 = 0
        head1 = headA
        head2 = headB
        while head1 != null:
            L1 += 1
            head1 = head1.next
        while head2 != null:
            L2 += 1
            head2 = head2.next
        
        if L1 < L2:
            head1 = headB
            head2 = headA
            diff = L2 - L1
        else:
            head1 = headA
            head2 = headB
            diff = L1 - L2
        for i in range(diff):
            head1 = head1.next 
        while head1 != head2:
            head1 = head1.next
            head2 = head2.next

        return head1


if __name__ == "__main__":
    headA = ListNode(4)
    headB = ListNode(1)
    headA.next = ListNode(5)
    headB.next = ListNode(0)
    headA.next.next = ListNode(1)
    headB.next.next = headA.next
    sol = Solution()
    print(sol.getIntersectionNode2(headA, headB))
        