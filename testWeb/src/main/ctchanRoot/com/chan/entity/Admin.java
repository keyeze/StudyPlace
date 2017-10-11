package com.chan.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Admin {
    User user;

    public User getUser() {
        return user;
    }

    public Admin setUser(User user) {
        this.user = user;
        return this;
    }

    public Boolean isExtra() {
        return user != null;
    }
}