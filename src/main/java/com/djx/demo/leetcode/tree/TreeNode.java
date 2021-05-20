package com.djx.demo.leetcode.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dong jing xi
 * @date 2021/3/27 16:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode<T> {

    private T value;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

}
