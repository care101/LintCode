/**
 * @param root: the given BST
 * @param target: the given target
 * @return: the value in the BST that is closest to the target
 */
const closestValue = function (root, target) {
  if (root === null) {
    return 0;
  }
  
  let upperNode = upperBound(root, target);
  let lowerNode = lowerBound(root, target);
  
  if (upperNode !== null && lowerNode !== null) {
    if (upperNode.val - target > target - lowerNode.val) {
      return lowerNode.val;
    } else {
      return upperNode.val;
    }
  }
  if (upperNode === null) {
    return lowerNode.val;
  }
  if (lowerNode === null) {
    return upperNode.val;
  }
  return root.val;
}

const upperBound = function (root, target) {
  if (root === null) {
    return null;
  }
  if (root.val < target) {
    return upperBound(root.right, target);
  }
  let upperNode = upperBound(root.left, target);
  if (upperNode !== null) {
    return upperNode;
  }
  return root;
}

const lowerBound = function (root, target) {
  if (root === null) {
    return null;
  }
  if (root.val > target) {
    return lowerBound(root.left, target);
  }
  let lowerNode = lowerBound(root.right, target);
  if (lowerNode !== null) {
    return lowerNode;
  }
  return root;
}