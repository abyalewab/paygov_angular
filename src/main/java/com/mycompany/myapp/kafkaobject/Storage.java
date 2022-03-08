package com.mycompany.myapp.kafkaobject;

import com.mycompany.myapp.domain.Pay;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private final List<Pay> users = new ArrayList<>();

    public void add(Pay pay) {
        users.add(pay);
    }

    public void clear() {
        users.remove(0);
    }

    public List<Pay> getAll() {
        return users;
    }
}
