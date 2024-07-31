# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        max_width = 0
        queue = deque([(root, 0)])
        while queue:
            level_size = len(queue)
            # Set the 'leftmost_index' to the index of the first node in this level. The
            # 'rightmost_index' starts at the same point but gets updated as we iterate
            # over the level, and ends at the index of the last node at this level.
            leftmost_index = queue[0][1]
            rightmost_index = leftmost_index
            start_index = 2*leftmost_index+1
	        # take a new variable start_index to calculate 
            # the index of first node of next level
            # Process all nodes at the current level.
            for _ in range(level_size):
                node, i = queue.popleft()
	     
                if node.left:
                    queue.append((node.left, 2*i + 1-start_index))
                if node.right:
                    queue.append((node.right, 2*i + 2-start_index))
                rightmost_index = i
            max_width = max(max_width, rightmost_index - leftmost_index + 1)
        return max_width
