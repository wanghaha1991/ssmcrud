package cn.kgc.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author asus
 * @Title: Node
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/9 17:58
 */
public class Node {
    private Integer id;
    private String text;
    private String href;
    private Integer parentId;
    private Integer level;
    private List<Node> nodes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Node node = (Node) o;
        return Objects.equals(id, node.id) &&
                Objects.equals(text, node.text) &&
                Objects.equals(href, node.href) &&
                Objects.equals(parentId, node.parentId) &&
                Objects.equals(level, node.level);
    }
    @Override
    public int hashCode() {

        return Objects.hash(id, text, href, parentId, level);
    }
}
