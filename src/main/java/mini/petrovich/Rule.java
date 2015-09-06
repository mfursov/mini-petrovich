package mini.petrovich;

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
        this.gender = gender;
        this.test = test;
        this.mods = mods;
    }
}
