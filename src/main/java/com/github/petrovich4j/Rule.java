package com.github.petrovich4j;

import java.util.Arrays;

public final class Rule {

    /**
     * пол
     */
    public final Gender gender;

    /**
     * правила нахождения
     */
    public final String[] test;

    /**
     * правила изменения
     */
    public final String[] mods;

    public Rule(Gender gender, String[] test, String[] mods) {
        if (gender == null) throw new NullPointerException(); // java 1.6: no java.util.Objects
        this.gender = gender;
        // make a copy to have truly immutable object
        this.test = Arrays.copyOf(test, test.length);
        this.mods = Arrays.copyOf(mods, mods.length);
    }
}
