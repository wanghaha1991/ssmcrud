package cn.kgc.po;

import java.io.Serializable;

/**
 * @author asus
 * @Title: User
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/9 9:41
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
