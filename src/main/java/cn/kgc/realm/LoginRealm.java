package cn.kgc.realm;

import cn.kgc.mapper.UserMapper;
import cn.kgc.po.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @author asus
 * @Title: LoginRealm
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/13 15:22
 */
public class LoginRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    /**
     * 授权的方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权方法执行了");
        //获取当前登录的用户
        User user = (User) principalCollection.getPrimaryPrincipal();
        //获取当前用户的所有权限名
        List<String> privilege = userMapper.getAllPrivilege(user);
        //授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(privilege);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证的方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //只需要据从数库中查出该用户对应的密码
        User user = userMapper.getUserByName(username);
        //杂质
        ByteSource salt = ByteSource.Util.bytes(username);
        //第一个参数:查询出来的用户对象
        //第二个参数:查询出来的密码
        //第三个参数:realmName;
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(user, user.getPassword(), salt, this.getName());
        return authenticationInfo;
    }
}
