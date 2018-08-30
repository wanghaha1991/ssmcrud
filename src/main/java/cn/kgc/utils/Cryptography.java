package cn.kgc.utils;

import cn.kgc.po.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author asus
 * @Title: Cryptography
 * @ProjectName ssmcrud
 * @Description: 密码加密
 * @date 2018/8/13 16:57
 */
public class Cryptography {
    public static User md5(User user) {
        //加密方式
        String hashAlgorithmName = "MD5";
        //明文
        Object credentials = user.getPassword();

        Object salt = ByteSource.Util.bytes(user.getName());
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, 1024);
        user.setPassword(result.toString());
        return user;
    }
}
