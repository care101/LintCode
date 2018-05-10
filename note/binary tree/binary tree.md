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

#### 求二叉树的深度
