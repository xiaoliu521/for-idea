package org.example.alg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xianr
 * @date 2023-10-31
 * @Description TODO
 */
public class LintCode242 {

      class TreeNode {
         public int val;
         public TreeNode left, right;
         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
     }
      class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        ArrayList<ListNode> listNodes = new ArrayList<>();
        if (root == null) return listNodes;
        LinkedList<TreeNode> queue = new LinkedList<>();


        queue.offer(root);
        while (!queue.isEmpty()) {
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                tail.next = new ListNode(node.val);
                tail = tail.next;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            listNodes.add(head);
        }
        return listNodes;
    }
}
