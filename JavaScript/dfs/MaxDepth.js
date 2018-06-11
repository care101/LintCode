/**
 * @param root: The root of binary tree.
 * @return: An integer
 */
const maxDepth = function (root) {
  if (!root) {
    return 0;
  }
  
  let left = maxDepth(root.left);
  let right = maxDepth(root.right);
  
  return left > right ? left + 1 : right + 1;
}