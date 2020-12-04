package com.github.petrovich4j;

public class Petrovich {

    private final RuleSet firstNameRules;
    private final RuleSet lastNameRules;
    private final RuleSet patronymicNameRules;

    public Petrovich() {
        this(Library.FIRST_NAME_RULES, Library.LAST_NAME_RULES, Library.PATRONYMIC_NAME_RULES);
    }

    public Petrovich(RuleSet firstNameRules, RuleSet lastNameRules, RuleSet patronymicNameRules) {
        if (firstNameRules == null || lastNameRules == null || patronymicNameRules == null) {
            throw new IllegalArgumentException("Rule set is null! First:" + firstNameRules + ", last:" + lastNameRules + ", patronymic: " + patronymicNameRules);
        }
        this.firstNameRules = firstNameRules;
        this.lastNameRules = lastNameRules;
        this.patronymicNameRules = patronymicNameRules;
    }

    public String say(String name, NameType type, Gender gender, Case cas) {
        if (name == null || name.isEmpty()) { // do not force caller to check every name it asks.
            return null;
        }
        if (type == null || gender == null || cas == null) { // configuration parameters must always be set up correctly.
            throw new IllegalArgumentException("Not all required parameters are set! Type: " + type + ", gender:" + gender + ", case: " + cas);
        }
        RuleSet rules = type == NameType.FirstName ? firstNameRules : type == NameType.LastName ? lastNameRules : patronymicNameRules;
        Rule exceptionRule = findRule(rules.exceptions, gender, name);
        Rule suffixRule = findRule(rules.suffixes, gender, name);
        Rule rule;
        if (exceptionRule != null && exceptionRule.gender == gender) {
            rule = exceptionRule;
        } else if (suffixRule != null && suffixRule.gender == gender) {
            rule = suffixRule;
        } else {
            rule = exceptionRule != null ? exceptionRule : suffixRule;
        }
        return rule == null ? name : applyMod(rule.mods[cas.modIdx], name);
    }

    /**
     * Guess gender for NameType.PatronymicName
     */
    public Gender gender(String name, Gender defaultValue) {
        return gender(name, NameType.PatronymicName, defaultValue);
    }

    Gender gender(String name, NameType type, Gender defaultValue) {
        if (name == null || name.isEmpty()) {
            return defaultValue;
        }
        if (type == null) {
            throw new IllegalArgumentException("Not all required parameters are set: name type is null! ");
        }
        RuleSet rules = type == NameType.FirstName ? firstNameRules : type == NameType.LastName ? lastNameRules : patronymicNameRules;
        Rule exceptionRule = findRule(rules.exceptions, null, name, false);
        if (exceptionRule != null) {
            return defaultValue;
        }
        Rule suffixRule = findRule(rules.suffixes, null, name, false);
        if (suffixRule != null) {
            return suffixRule.gender;
        }
        return defaultValue;
    }

    public static String applyMod(String mod, String name) {
        if (mod.equals(Library.KEEP_MOD)) {
            return name;
        }
        String result = name;
        if (mod.indexOf(Library.REMOVE_CHARACTER) >= 0) {
            for (int i = 0; i < mod.length(); i++) {
                if (mod.charAt(i) == Library.REMOVE_CHARACTER) {
                    result = result.substring(0, result.length() - 1);
                } else {
                    result += mod.substring(i);
                    break;
                }
            }
        } else {
            result = name + mod;
        }
        return result;
    }

    public static Rule findRule(Rule[] allRules, Gender gender, String name) {
        return findRule(allRules, gender, name, true);
    }

    private static Rule findRule(Rule[] allRules, Gender gender, String name, boolean checkGender) {
        if (allRules == null) {
            return null;
        }
        String lcName = name.toLowerCase();
        for (Rule rule : allRules) {
            for (String test : rule.test) {
                boolean fullMatch = test.charAt(0) == '^';
                boolean nameMatched = fullMatch ? test.substring(1).equals(lcName) : lcName.endsWith(test);
                if (nameMatched && (!checkGender || rule.gender == Gender.Both || rule.gender == gender)) {
                    return rule;
                }
            }
        }
        return null;
    }
}
