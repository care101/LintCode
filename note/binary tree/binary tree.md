## 二叉树基础知识

### definition
二叉树是每个节点最多只有两个分支的树结构，其分支被称为左子树和右子树，并且分支具有顺序，不能颠倒。
![binary tree](../pic/binary-tree.png)

- 二叉树的第 i 层最多有 2^(i-1) 个节点。（此时根节点为第一层）
- 深度为 k 的二叉树最多有 2^(k+1) - 1 个节点。（此时根节点所在的深度为0）
- 二叉树可以为空，但普通树不可以。

#### 满二叉树
深度为 k 的二叉树有 2^(k+1) - 1 个节点（此时根节点所在的深度为0）的二叉树。
![full binary tree](../pic/complete-full-binary-tree.jpg)

#### 完全二叉树
深度为 k 有 n 个节点的二叉树，当且仅当其中的每一节点，都可以和同样深度 k 的满二叉树，序号为 1 到 n 的节点一对一对应的二叉树。

翻译一下是：叶节点只能出现在最下层和次下层，并且最下面一层的结点都集中在该层最左边的若干位置的二叉树。
![complete binary tree](../pic/complete-full-binary-tree.jpg)

#### 二叉树的表示方法(Java)
```
class TreeNode {
  public int val;
  public TreeNode left, right;
  public TreeNode(int val) {
    this.val = val;
    this.left = this.right = null;
  }
}
```

#### 二叉树的高度
- 高度(height)：二叉树的高度是指 root 节点到最长叶子结点的**边数**。
- 深度(depth)：二叉树的深度是指 root 节点到最长叶子结点的**节点数**。

例如：
![example](../pic/max-depth1.png)

这棵树最远的叶子结点是 8 或者 9，因此该树的高度是 3，而深度是4。

要求二叉树的高度，可以递归求左子树的高度，右子树的高度，取两者高度的最大值，再加上 root 到左右子树的边数，即 1，就是整棵树的高度。递归的出口条件是，当 `node==null` 时，即说明以这个节点为 root 节点的树高度为 0，所以当 `node==null` 时返回 0。

![example](../pic/max-depth2.png)

```
int height(TreeNode node) {
  if (node == null) {
    return 0;
  }
  return Math.max(height(node.left), height(node.right)) + 1;
}
```

非递归的写法可以用层序遍历来实现。

#### 平衡二叉树
平衡二叉树是指一颗二叉树的所有左右子树高度之差小于等于1。一颗空树是高度平衡的。

```
boolean isBalanced(TreeNode root) {
  if (root == null) {
    return true;
  }
  int l = height(root.left);
  int r = height(root.right);
  if (Math.abs(l-r) > 1) {
    return false;
  }
  if (!isBalanced(root.left) || !isBalanced(root.right)) {
    return false;
  }
  return true;
}
```