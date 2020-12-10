package com.demo.userinfo.api;

import java.util.Optional;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Optional<Long> id) {
        super("Could not find userinfo " + (id.isPresent() ? id.get() : ""));
    }
}
