# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = [] 
        def dfsTraversal(node = root , level = 0):
	        if not node:
		        return
	        if level == len(res):
		        res.append(node.val)
	        dfsTraversal(node.right, level+1)
	        dfsTraversal(node.left,  level+1)
        
        dfsTraversal() 
        return res