package com.github.petrovich4j;

/**
 * Наборы правил по умолчанию для имен, фамилий и отчеств.
 */

public final class Library {
    public static final char KEEP_CHARACTER = '.';
    public static final char REMOVE_CHARACTER = '-';
    public static final String KEEP_MOD = Character.toString(KEEP_CHARACTER);
    static final String[] KEEP_ALL = new String[]{KEEP_MOD, KEEP_MOD, KEEP_MOD, KEEP_MOD, KEEP_MOD};

    public static final Rule[] LAST_NAME_RULES_EXCEPTIONS = new Rule[]{
            both(t("бонч", "абдул", "белиц", "гасан", "дюссар", "дюмон", "книппер", "корвин", "ван", "шолом", "тер", "призван", "мелик", "вар", "фон"), KEEP_ALL),
            both(t("дюма", "тома", "дега", "люка", "ферма", "гамарра", "петипа", "шандра", "скаля", "каруана"), KEEP_ALL),
            both(t("гусь", "ремень", "камень", "онук", "богода", "нечипас", "долгопалец", "маненок", "рева", "кива"), KEEP_ALL),
            both(t("вий", "сой", "цой", "хой"), m("-я", "-ю", "-я", "-ем", "-е")),
            both(t("я"), KEEP_ALL)
    };
    public static final Rule[] LAST_NAME_RULES_SUFFIXES = new Rule[]{
            female(t("б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ь"), KEEP_ALL),
            both(t("гава", "орота"), KEEP_ALL),
            female(t("ска", "цка"), m("-ой", "-ой", "-ую", "-ой", "-ой")),
            female(t("чая"), m("--ей", "--ей", "--ую", "--ей", "--ей")),
            female(t("цкая", "ская", "ная", "ая"), m("--ой", "--ой", "--ую", "--ой", "--ой")),
            female(t("яя"), m("--ей", "--ей", "--юю", "--ей", "--ей")),
            female(t("на"), m("-ой", "-ой", "-у", "-ой", "-ой")),
            male(t("иной"), m("-я", "-ю", "-я", "-ем", "-е")),
            male(t("уй"), m("-я", "-ю", "-я", "-ем", "-е")),
            both(t("ца"), m("-ы", "-е", "-у", "-ей", "-е")),
            male(t("рих"), m("а", "у", "а", "ом", "е")),
            both(t("ия"), KEEP_ALL),
            both(t("иа", "аа", "оа", "уа", "ыа", "еа", "юа", "эа"), KEEP_ALL),
            male(t("их", "ых"), KEEP_ALL),
            both(t("о", "е", "э", "и", "ы", "у", "ю"), KEEP_ALL),
            female(t("ова", "ева", "ёва"), m("-ой", "-ой", "-у", "-ой", "-ой")),
            both(t("га", "ка", "ха", "ча", "ща", "жа", "ша"), m("-и", "-е", "-у", "-ой", "-е")),
            both(t("а"), m("-ы", "-е", "-у", "-ой", "-е")),
            male(t("ь"), m("-я", "-ю", "-я", "-ем", "-е")),
            both(t("ия"), m("-и", "-и", "-ю", "-ей", "-и")),
            both(t("я"), m("-и", "-е", "-ю", "-ей", "-е")),
            male(t("ей"), m("-я", "-ю", "-я", "-ем", "-е")),
            male(t("рн", "ян", "ан", "йн"), m("а", "у", "а", "ом", "е")),
            male(t("мец", "ынец", "опец", "обец", "швец", "ьвец"), m("--ца", "--цу", "--ца", "--цем", "--це")),
            male(t("онец", "овец"), m("--ца", "--цу", "--ца", "--цом", "--це")),
            male(t("ай"), m("-я", "-ю", "-я", "-ем", "-е")),
            male(t("кой"), m("-го", "-му", "-го", "--им", "-м")),
            male(t("гой"), m("-го", "-му", "-го", "--им", "-м")),
            male(t("ой"), m("-го", "-му", "-го", "--ым", "-м")),
            male(t("ах", "ав", "ив"), m("а", "у", "а", "ом", "е")),
            male(t("ший", "щий", "жий", "ний", "чий"), m("--его", "--ему", "--его", "-м", "--ем")),
            male(t("ый", "хий"), m("--ого", "--ому", "--ого", "-м", "--ом")),
            male(t("кий"), m("--ого", "--ому", "--ого", "-м", "--ом")),
            male(t("ий"), m("-я", "-ю", "-я", "-ем", "-и")),
            male(t("ок"), m("--ка", "--ку", "--ка", "--ком", "--ке")),
            male(t("аец", "иец", "еец"), m("--йца", "--йцу", "--йца", "--йцем", "--йце")),
            male(t("ец"), m("--ца", "--цу", "--ца", "--цом", "--це")),
            male(t("ц", "ч", "ш", "щ"), m("а", "у", "а", "ем", "е")),
            male(t("ен", "нн", "он", "ун"), m("а", "у", "а", "ом", "е")),
            male(t("в", "н"), m("а", "у", "а", "ым", "е")),
            male(t("б", "г", "д", "ж", "з", "к", "л", "м", "п", "р", "с", "т", "ф", "х"), m("а", "у", "а", "ом", "е"))
    };

    public static final Rule[] FIRST_NAME_RULES_EXCEPTIONS = new Rule[]{
            male(t("лев"), m("--ьва", "--ьву", "--ьва", "--ьвом", "--ьве")),
            male(t("пётр"), m("---етра", "---етру", "---етра", "---етром", "---етре")),
            male(t("павел"), m("--ла", "--лу", "--ла", "--лом", "--ле")),
            male(t("яша"), m("-и", "-е", "-у", "-ей", "-е")),
            male(t("илья"), m("-и", "-е", "-ю", "-ёй", "-е")),
            male(t("шота"), KEEP_ALL),
            female(t("ьфия"), m("-и", "-е", "-ю", "-ёй", "-е")),
            female(t("^ия"), m("-и", "-е", "-ю", "-ей", "-е")),
            female(t("агидель", "жизель", "нинель", "рашель", "рахиль"), m("-и", "-и", ".", "ю", "-и"))
    };
    public static final Rule[] FIRST_NAME_RULES_SUFFIXES = new Rule[]{
            both(t("е", "ё", "и", "о", "у", "ы", "э", "ю", "уа", "иа"), KEEP_ALL),
            female(t("б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ", "ъ"), KEEP_ALL),
            female(t("ль"), KEEP_ALL),
            female(t("ь"), m("-и", "-и", ".", "ю", "-и")),
            male(t("ь"), m("-я", "-ю", "-я", "-ем", "-е")),
            both(t("га", "ка", "ха", "ча", "ща", "жа"), m("-и", "-е", "-у", "-ой", "-е")),
            both(t("ша"), m("-и", "-е", "-у", "-ей", "-е")),
            both(t("а"), m("-ы", "-е", "-у", "-ой", "-е")),
            female(t("ия"), m("-и", "-и", "-ю", "-ей", "-и")),
            female(t("а"), m("-ы", "-е", "-у", "-ой", "-е")),
            female(t("я"), m("-и", "-е", "-ю", "-ей", "-е")),
            male(t("ия"), m("-и", "-и", "-ю", "-ей", "-и")),
            male(t("я"), m("-и", "-е", "-ю", "-ей", "-е")),
            male(t("ей"), m("-я", "-ю", "-я", "-ем", "-е")),
            male(t("ий"), m("-я", "-ю", "-я", "-ем", "-и")),
            male(t("й"), m("-я", "-ю", "-я", "-ем", "-е")),
            male(t("бек"), m("-ка", "-ку", "-ка", "-ком", "-ке")),
            male(t("ек", "ёк"), m("--ька", "--ьку", "--ька", "--ьком", "--ьке")),
            male(t("б", "в", "г", "д", "ж", "з", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч"), m("а", "у", "а", "ом", "е")),
            both(t("ния", "рия", "вия"), m("-и", "-и", "-ю", "-ем", "-ем"))
    };

    public static final Rule[] PATRONYMIC_NAME_RULES_EXCEPTIONS = new Rule[]{};
    public static final Rule[] PATRONYMIC_NAME_RULES_SUFFIXES = new Rule[]{
            male(t("ьич"), m("а", "у", "а", "ом", "е")), // http://new.gramota.ru/spravka/trudnosti?layout=item&id=36_189
            male(t("ич"), m("а", "у", "а", "ем", "е")),
            female(t("на"), m("-ы", "-е", "-у", "-ой", "-е")),
    };

    public static final RuleSet LAST_NAME_RULES = new RuleSet(LAST_NAME_RULES_EXCEPTIONS, LAST_NAME_RULES_SUFFIXES);
    public static final RuleSet FIRST_NAME_RULES = new RuleSet(FIRST_NAME_RULES_EXCEPTIONS, FIRST_NAME_RULES_SUFFIXES);
    public static final RuleSet PATRONYMIC_NAME_RULES = new RuleSet(PATRONYMIC_NAME_RULES_EXCEPTIONS, PATRONYMIC_NAME_RULES_SUFFIXES);

    static String[] t(String... values) {
        return values;
    }

    static String[] m(String... values) {
        return values;
    }

    static Rule male(String[] exceptions, String[] suffixes) {
        return new Rule(Gender.Male, exceptions, suffixes);
    }

    static Rule female(String[] exceptions, String[] suffixes) {
        return new Rule(Gender.Female, exceptions, suffixes);
    }

    static Rule both(String[] exceptions, String[] suffixes) {
        return new Rule(Gender.Both, exceptions, suffixes);
    }
}
