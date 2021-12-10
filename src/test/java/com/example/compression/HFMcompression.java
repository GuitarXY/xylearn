package com.example.compression;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author xiaoy
 * @date 2021/12/6
 */
public class HFMcompression {
    public static void main(String[] args)
    {
        HFMcompression hc = new HFMcompression();
        File file  = new File("src/test/java/com/example/compression/Test.txt");//源文件地址
        FileOperation fo = new FileOperation();
        int [] a = fo.getArrays(file);
        System.out.println(Arrays.toString(a)); //打印
        LinkedList<Node<String>> list = hc.createNodeList(a);//把数组的元素转为节点并存入链表
        for (Node<String> stringNode : list) {
            System.out.println(stringNode.toString());
        }
        Node<String> root = hc.CreateHFMTree(list); //建树
        System.out.println("打印整棵树、、、、");
        hc.inOrder(root); //打印整棵树
        System.out.println("获取叶子结点哈夫曼编码");
        HashMap<String,String> map = hc.getAllCode(root);//获取字符编码HashMap
        String str = fo.GetStr(map, file);
        System.out.println("转化得到的01字符串："+str);
        File fileCompress = new File("data2.zip");//压缩文件地址
        fo.compressFile(fileCompress,map,str);  //生成压缩文件
        File fileUncompress = new File("data3.txt");//压缩文件地址
        fo.uncompressFile(fileCompress,fileUncompress);//解压文件至fileUncompress处
    }
    /**
     * 把获得的数组转化为节点并存在链表中
     * @param arrays
     * @return
     */
    public LinkedList<Node<String>> createNodeList(int[] arrays)
    {
        LinkedList<Node<String>> list = new LinkedList<>();
        for(int i=0;i<arrays.length;i++)
        {
            if(arrays[i]!=0)
            {
                String ch = (char)i+"";
                Node<String> node = new Node<String>(ch,arrays[i]); //构建节点并传入字符和权值
                list.add(node); //添加节点
            }
        }
        return list;
    }
    /**
     * 对链表中的元素排序
     * @param list
     * @return
     */
    public void sortList(LinkedList<Node<String>> list)
    {
        for(int i=list.size();i>1;i--)
        {
            for(int j=0; j<i-1;j++)
            {
                Node<String> node1 = list.get(j);
                Node<String> node2 = list.get(j+1);
                if(node1.getWeight()>node2.getWeight())
                {
                    int temp ;
                    temp = node2.getWeight();
                    node2.setWeight(node1.getWeight());
                    node1.setWeight(temp);
                    String tempChar;
                    tempChar = node2.getData();
                    node2.setData(node1.getData());
                    node1.setData(tempChar);
                    Node<String> tempNode = new Node<String>(null, 0);
                    tempNode.setLeft(node2.getLeft());
                    tempNode.setRight(node2.getRight());
                    node2.setLeft(node1.getLeft());
                    node2.setRight(node1.getRight());
                    node1.setLeft(tempNode.getLeft());
                    node1.setRight(tempNode.getRight());
                }
            }
        }
    }
    /**
     * 建树的方法
     * @param list
     */
    public Node<String> CreateHFMTree(LinkedList<Node<String>> list)
    {
        while(list.size()>1)
        {
            sortList(list); //排序节点链表
            Node<String> nodeLeft = list.removeFirst();
            Node<String> nodeRight = list.removeFirst();
            Node<String> nodeParent = new Node<String>( null ,nodeLeft.getWeight()+nodeRight.getWeight());
            nodeParent.setLeft(nodeLeft);
            nodeParent.setRight(nodeRight);
            list.addFirst(nodeParent);
        }
        System.out.println("根节点的权重："+list.get(0).getWeight());
        return list.get(0);//返回根节点
    }
    public HashMap<String, String> getAllCode(Node<String> root)
    {
        HashMap<String, String> map = new HashMap<>();
        inOrderGetCode("", map, root);
        return map;
    }
    /**
     * 查询指定字符的哈夫曼编码（中序遍历）
     * @param code
     * @param
     * @param root
     * @return
     */
    public void inOrderGetCode(String code ,HashMap<String, String> map,Node<String> root)
    {
        if(root!=null)
        {
            inOrderGetCode(code+"0",map,root.getLeft());
            if(root.getLeft()==null&&root.getRight()==null)//存储叶子结点的哈夫曼编码
            {
                System.out.println(root.getData());
                System.out.println(code);
                map.put(root.getData(), code);
            }
            inOrderGetCode(code+"1",map,root.getRight());
        }
    }
    /**
     * 中序遍历输出整棵树
     * @param root
     * @return
     */
    public void inOrder(Node<String> root)
    {
        if(root!=null)
        {
            inOrder(root.getLeft());
            if(root.getData()!=null)
                System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }
}
