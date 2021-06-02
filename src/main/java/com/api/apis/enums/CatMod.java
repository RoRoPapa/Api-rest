package com.api.apis.enums;

public enum CatMod {

    HAPPY("happy\\"), SAD("sad\\");

    private final String path;

    CatMod(String path) {
        this.path = path;
    }

    public static CatMod getIgnoreCase(String mod) throws IllegalAccessException {
        for (CatMod c: CatMod.values()){
            if(c.name().equalsIgnoreCase(mod)) return c;
        }
        throw new IllegalAccessException();
    }

    public String getPath(){
        return path;
    }
}
