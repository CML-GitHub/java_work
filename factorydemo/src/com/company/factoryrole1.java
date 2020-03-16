package com.company;

public class factoryrole1 extends factory {
    @Override
    public role createrole() {
        return new role1();
    }
}
