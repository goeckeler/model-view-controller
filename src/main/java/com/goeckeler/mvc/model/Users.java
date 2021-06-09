package com.goeckeler.mvc.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

public class Users
{
    private Set<User> users = new HashSet<>();

    public Users() {
        insert(new User("anton", "geheim", "Anton Gauß"));
        insert(new User("frieda", "geheim", "Frieda Göckeler"));
    }

    public boolean insert(final User user) {
        return users.add(user);
    }

    public boolean delete(final User user) {
        return users.remove(user);
    }

    public Optional<User> match(final User user) {
        return users.stream().filter(u -> u.equals(user)).findFirst();
    }
}
