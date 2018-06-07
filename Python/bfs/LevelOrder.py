class Solution:
  """
    @param root: A Tree
    @return: Level order a list of lists of integer
  """
  def levelOrder(self, root):
    self.res = []
    if not root:
      return []
    q = [root]
    while q:
      temp = []
      self.res.append([n.val for n in q])
      for node in q:
        if node.left:
          temp.append(node.left)
        if node.right:
          temp.append(node.right)
      q = temp
    return self.res
      