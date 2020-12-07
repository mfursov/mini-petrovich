package com.github.petrovich4j;

import java.util.Arrays;

public final class RuleSet {
    /**
     * Исключения
     */
    public final Rule[] exceptions;
    /**
     * Правила
     */
    public final Rule[] suffixes;

    public RuleSet(Rule[] exceptions, Rule[] suffixes) {
        this.exceptions = Arrays.copyOf(exceptions, exceptions.length);
        this.suffixes = Arrays.copyOf(suffixes, suffixes.length);
    }
}
