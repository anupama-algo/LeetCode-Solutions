class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head) return nullptr;
        ListNode* current = head;
        while (current != nullptr && current->next != nullptr) {
            if (current->val == current->next->val) {
                ListNode* nextNode = current->next;
                current->next = current->next->next;
                delete nextNode; 
            } else {
                current = current->next;
            }
        }
        return head;
    }
};