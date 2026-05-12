# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Dummy node to handle head deletion
        dummy = ListNode(0, head)
        prev = dummy
        
        while head:
            # If current node is the start of a duplicate sequence
            if head.next and head.val == head.next.val:
                # Skip all nodes with the same value
                while head.next and head.val == head.next.val:
                    head = head.next
                # Link prev to the node after the duplicates
                prev.next = head.next
            else:
                # No duplicate, move prev forward
                prev = prev.next
            
            # Move head forward
            head = head.next
            
        return dummy.next