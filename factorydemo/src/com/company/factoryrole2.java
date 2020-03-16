package com.company;

public class factoryrole2 extends factory {
    @Override
    public role createrole() {
        return new role2();
    }
}
