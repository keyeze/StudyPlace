package com.chan.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_GLOBAL_SESSION)
public class LoginUser {
    private User user;

    public User getUser() {
        return user;
    }

    public LoginUser setUser(User user) {
        this.user = user;
        return this;
    }

    public Boolean isLogin() {
        return user != null;
    }
}
