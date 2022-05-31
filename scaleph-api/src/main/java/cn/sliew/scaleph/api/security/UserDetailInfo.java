package cn.sliew.scaleph.api.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.sliew.scaleph.common.enums.UserStatusEnum;
import cn.sliew.scaleph.security.service.dto.SecUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息
 *
 * @author gleiyu
 */
public class UserDetailInfo implements UserDetails {

    private static final long serialVersionUID = -7255246796611902520L;
    /**
     * 用户信息
     */
    private SecUserDTO user;
    /**
     * 登录相关信息
     */
    private Boolean remember;
    private String loginIpAddress;
    private Date loginTime;

    /**
     * 权限信息
     */
    private List<GrantedAuthority> authorities;

    public SecUserDTO getUser() {
        return user;
    }

    public void setUser(SecUserDTO user) {
        this.user = user;
    }

    public String getLoginIpAddress() {
        return loginIpAddress;
    }

    public void setLoginIpAddress(String loginIpAddress) {
        this.loginIpAddress = loginIpAddress;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Boolean getRemember() {
        return remember != null && remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        String userStatus = this.user.getUserStatus().getValue();
        return !UserStatusEnum.LOGOFF.getValue().equals(userStatus);
    }

    @Override
    public boolean isAccountNonLocked() {
        String userStatus = this.user.getUserStatus().getValue();
        return !UserStatusEnum.DISABLE.getValue().equals(userStatus);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        String userStatus = this.user.getUserStatus().getValue();
        return !UserStatusEnum.LOGOFF.getValue().equals(userStatus) &&
            !UserStatusEnum.DISABLE.getValue().equals(userStatus);
    }
}
