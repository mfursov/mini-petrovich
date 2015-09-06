package mini.petrovich;

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
        this.exceptions = exceptions;
        this.suffixes = suffixes;
    }
}
