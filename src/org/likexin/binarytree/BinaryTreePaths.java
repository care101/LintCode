package org.likexin.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/binary-tree-paths/#
 *
 * @author Shingo Lee
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }

        List<String> leftStrings = binaryTreePaths(root.left);
        List<String> rightStrings = binaryTreePaths(root.right);

        for (String path : leftStrings) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightStrings) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }

}
