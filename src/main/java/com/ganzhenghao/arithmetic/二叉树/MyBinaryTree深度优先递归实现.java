package com.ganzhenghao.arithmetic.二叉树;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 我的二叉树
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/25 20:16
 */
public class MyBinaryTree深度优先递归实现 {
    /**
     * 二叉树节点
     *
     * @author Doraemon
     * @date 2021/06/25
     */
    private static class Node {
        private Object data;
        private Node leftChild;
        private Node rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));

        Node rootNode = MyBinaryTree深度优先递归实现.createBinaryTree(linkedList);
        //前序遍历
        preorderTraversal(rootNode);
    }

    /**
     * 创建二叉树
     *
     * @param linkedList 链表
     * @return {@link Node}
     */
    public static Node createBinaryTree(LinkedList<Integer> linkedList) {

        if (linkedList == null || linkedList.isEmpty()){
            return null;
        }

        Object data = linkedList.removeFirst();
        Node node = null;
        if (data != null){
            node = new Node(data);
            node.leftChild = createBinaryTree(linkedList);
            node.rightChild = createBinaryTree(linkedList);
        }

        return node;
    }

    /**
     * 前序遍历
     *
     * @param rootNode 根节点
     */
    public static void preorderTraversal(Node rootNode){

        if (rootNode == null){
            return;
        }
        System.out.println(rootNode.data);
        preorderTraversal(rootNode.leftChild);
        preorderTraversal(rootNode.rightChild);

    }

    /**
     * 中序遍历
     *
     * @param rootNode 根节点
     */
    public static void inOrderTraversal(Node rootNode){

        if (rootNode == null){
            return;
        }
        inOrderTraversal(rootNode.leftChild);
        System.out.println(rootNode.data);
        inOrderTraversal(rootNode.rightChild);

    }

    /**
     * 后序遍历
     *
     * @param rootNode 根节点
     */
    public static void postOrderTraversal(Node rootNode){

        if (rootNode == null){
            return;
        }
        postOrderTraversal(rootNode.leftChild);
        postOrderTraversal(rootNode.rightChild);
        System.out.println(rootNode.data);

    }


}
