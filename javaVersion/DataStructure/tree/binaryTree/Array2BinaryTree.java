package DataStructure.tree.binaryTree;

import DataStructure.tree.Tree;
import DataStructure.tree.binaryTree.binaryTreeRealize.BinaryTreeImpl;

/**
 * @author liujun
 * @date 2020-02-18 16:09
 * @description 二叉树的实现（二叉树反序列化）
 * 单序创建：
 * 1、将按层次遍历的方式输入的数组  构造成一个二叉树
 * 2、将按先序遍历的方式输入的数组  构造成一个二叉树
 * 3、将按中序遍历的方式输入的数组  构造成一个二叉树
 * 4、将按后序遍历的方式输入的数组  构造成一个二叉树
 * 5、将一个完全二叉树的数组 构造成一个二叉树
 * 多序创建：
 * 6、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
 * 7、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
 */
public interface Array2BinaryTree extends Tree {

    //1、将按层次遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createBinaryTreeLevel(int[] array);

    //2、将按先序遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createPreOrder(int[] array);

    //3、将按中序遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createInOrder(int[] array);

    //4、将按后序遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createPostOrder(int[] array);

    //5、将一个完全二叉树的数组 构造成一个二叉树
    public BinaryTreeImpl createfulltree(int[] array);

    //6、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
    public BinaryTreeImpl createTreePre_InOrder(int[] PreOrderarray, int[] InOrderarray);

    //7、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
    public BinaryTreeImpl createTreePost_InOrder(int[] PostOrderarray, int[] InOrderarray);

    default boolean check(int[] array) {
        return array != null && array.length != 0;
    }
}
