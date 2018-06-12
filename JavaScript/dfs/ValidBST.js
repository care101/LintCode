let lastNode;
let isValid;

const isValidBST = function (root) {
  lastNode = null;
  isValid = true;

  inorderTraverse(root);
  return isValid;
}

const inorderTraverse = function (root) {
  if (root === null) {
    return;
  }

  inorderTraverse(root.left);

  if (lastNode !== null && lastNode.val <= root.val) {
    isValid = false;
    return;
  }
  lastNode = root;

  inorderTraverse(root.right);
} 