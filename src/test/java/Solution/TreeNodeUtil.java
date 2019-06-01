package Solution;

import java.util.LinkedList;
import java.util.Queue;

import Solution.Solution1.TreeNode;

public class TreeNodeUtil {
	public TreeNode treeGen(Integer [] tree) {
		TreeNode root = new TreeNode(tree[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		insert(queue, tree, 1);
		return root;
	}

	private void insert(Queue<TreeNode> current, Integer[] tree, int start) {
		if (start >= tree.length) {
			return;
		}
		Queue<TreeNode> next = new LinkedList<>();
		int currentLen = current.size() ;
		for (int i = 0; i < currentLen && start < tree.length; i ++) {
			TreeNode root = current.poll();
			if (tree[start] != null) {
				root.left = new TreeNode(tree[start]);
				next.add(root.left);
			}
			start ++;
			if (start >= tree.length) {
				break;
			}
			
			if (tree[start] != null) {
				root.right = new TreeNode(tree[start]);
				next.add(root.right);
			}
			start ++;
		}
		
		if (!next.isEmpty()) {
			insert(next, tree, start);
		}
	}
}
