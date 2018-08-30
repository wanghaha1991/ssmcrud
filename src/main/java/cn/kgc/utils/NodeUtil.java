package cn.kgc.utils;

import cn.kgc.vo.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author asus
 * @Title: NodeUtil
 * @ProjectName ssmcrud
 * @Description: 节点的工具方法
 * @date 2018/8/10 9:03
 */
public class NodeUtil {

    public static List<Node> sort(List<Node> nodes) {
        //取得嵌套的最底层
        int level = 1;
        for (int i = 0; i < nodes.size(); i++) {
            if (level < nodes.get(i).getLevel()) {
                level = nodes.get(i).getLevel();
            }
        }
        //没有叶子节点存在
        if (level==1){
            return nodes;
        }
        //最底层的叶子节点
        for (int i = 0; i < nodes.size(); i++) {
            //最底层的叶子
            if (nodes.get(i).getLevel() == level) {
                //取得其父节点的id
                int parentId = nodes.get(i).getParentId();
                //匹配父节点并进行添加后移除
                for (int j = 0; j< nodes.size(); j++){
                    if (parentId==nodes.get(j).getId()){
                        nodes.get(j).getNodes().add(nodes.get(i));
                        nodes.remove(nodes.get(i));
                        //移除后长度改变，指针回跳
                        i--;
                        break;
                    }
                }
            }
        }
        return sort(nodes);
    }


    /**
     *  存在子节点，就必须返回其父节点，存在父节点就返回其全部的子节点
     */
    public static List<Node> logicNode(List<Node> nodes,List<Node> allNodes){
        //添加父节点的所有子节点
        //clone一个副本进行迭代，防止迭代时修改异常
        ArrayList<Node> nodesClone = new ArrayList<>(nodes);
        for (Node node:nodesClone) {
            //取出节点的ID，看是否存在以其为父节点(parentId)的节点
            int id = node.getId();
            for (Node node1:allNodes){
                //找到当前节点的子节点，并添加进list
                if (node1.getParentId()==id){
                    //迭代的过程中更改了list,一定不要迭代原list
                    nodes.add(node1);
                }
            }
        }
        //添加子节点对应的父节点
        //set 存储所有节点的父节点，防止重复
        HashSet<Integer> parentIds = new HashSet<>();
        for (Node node:nodes){
            int parentId = node.getParentId();
            parentIds.add(parentId);
        }
        //添加对应的父节点
        for (Node node:allNodes){
            if (parentIds.contains(node.getId())){
                nodes.add(node);
            }
        }
        //利用set集合去重操作,注意重写equals与hashcode
        HashSet<Node> nodeHashSet = new HashSet<>(nodes);
        List<Node> list = new ArrayList<>(nodeHashSet);
        return list;
    }
}
