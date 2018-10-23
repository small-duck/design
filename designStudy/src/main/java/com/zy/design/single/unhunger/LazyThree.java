package com.zy.design.single.unhunger;

public class LazyThree {

    public static LazyThree getInint() {
        return LazeLoad.LAZY_THREE;
    }

    private static class LazeLoad{
        private static final LazyThree LAZY_THREE = new LazyThree();

    }


}
