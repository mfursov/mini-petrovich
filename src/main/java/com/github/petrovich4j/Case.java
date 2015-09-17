package com.github.petrovich4j;

/**
 * Падеж
 */
public enum Case {
    Genitive(0),
    Dative(1),
    Accusative(2),
    Instrumental(3),
    Prepositional(4);

    final int modIdx;

    Case(int modIdx) {
        this.modIdx = modIdx;
    }
}
