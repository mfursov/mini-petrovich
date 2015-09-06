package mini.petrovich;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static mini.petrovich.Gender.Both;
import static mini.petrovich.Gender.Female;
import static mini.petrovich.Gender.Male;
import static mini.petrovich.Library.both;
import static mini.petrovich.Library.female;
import static mini.petrovich.Library.m;
import static mini.petrovich.Library.male;
import static mini.petrovich.Library.t;
import static org.testng.Assert.assertEquals;

@Test
public class PetrovichTests {

    private Petrovich petrovich;

    @BeforeTest
    public void setUp() {
        petrovich = new Petrovich();
    }

    @Test
    public void modToName() throws Exception {
        assertEquals(Petrovich.applyMod("--", "test"), "te");
        assertEquals(Petrovich.applyMod("--st", "test"), "test");
        assertEquals(Petrovich.applyMod("st", "test"), "testst");
        assertEquals(Petrovich.applyMod(".", "test"), "test");
        assertEquals(Petrovich.applyMod("", "test"), "test");
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testFindModInRule() throws Exception {
        Rule[] rules = {
                male(t("one"), m("--11", "--12", "--13", "--14", "--15")),
                female(t("two"), m("--21", "--22", "--23", "--24", "--25")),
                both(t("three"), m("--31", "--32", "--33", "--34", "--35"))
        };

        assertEquals(Petrovich.findRule(rules, Male, "testone").mods[Case.Genitive.modIdx], "--11");
        assertEquals(Petrovich.findRule(rules, Female, "testone"), null);
        assertEquals(Petrovich.findRule(rules, Both, "testone"), null);
        assertEquals(Petrovich.findRule(rules, Male, "testone").mods[Case.Dative.modIdx], "--12");
        assertEquals(Petrovich.findRule(rules, Male, "teston"), null);

        assertEquals(Petrovich.findRule(rules, Female, "testtwo").mods[Case.Genitive.modIdx], "--21");
        assertEquals(Petrovich.findRule(rules, Male, "testtwo"), null);
        assertEquals(Petrovich.findRule(rules, Both, "testone"), null);
        assertEquals(Petrovich.findRule(rules, Female, "testtwo").mods[Case.Dative.modIdx], "--22");
        assertEquals(Petrovich.findRule(rules, Female, "testtw"), null);

        assertEquals(Petrovich.findRule(rules, Male, "testthree").mods[Case.Genitive.modIdx], "--31");
        assertEquals(Petrovich.findRule(rules, Female, "testthree").mods[Case.Genitive.modIdx], "--31");
        assertEquals(Petrovich.findRule(rules, Both, "testone"), null);
        assertEquals(Petrovich.findRule(rules, Male, "testthree").mods[Case.Dative.modIdx], "--32");
        assertEquals(Petrovich.findRule(rules, Male, "testtw"), null);
    }

    @Test
    public void testFemaleFirstNames() throws Exception {
        List<String[]> testCases = load("first_names_female.txt");
        for (String[] test : testCases) {
            check(petrovich, test, NameType.FirstName, Gender.Female);
        }
    }

    @Test
    public void testMaleFirstNames() throws Exception {
        for (String[] test : load("first_names_male.txt")) {
            check(petrovich, test, NameType.FirstName, Gender.Male);
        }
    }

    @Test
    public void testFemaleLastNames() throws Exception {
        for (String[] test : load("last_names_female.txt")) {
            check(petrovich, test, NameType.LastName, Gender.Female);
        }
    }

    @Test
    public void testMaleLastNames() throws Exception {
        for (String[] test : load("last_names_male.txt")) {
            check(petrovich, test, NameType.LastName, Gender.Male);
        }
    }

    @Test
    public void testFemalePatronymicNames() throws Exception {
        for (String[] test : load("patronymic_names_female.txt")) {
            check(petrovich, test, NameType.PatronymicName, Gender.Female);
        }
    }

    @Test
    public void testMalePatronymicNames() throws Exception {
        for (String[] test : load("patronymic_names_male.txt")) {
            check(petrovich, test, NameType.PatronymicName, Gender.Male);
        }
    }

    private void check(Petrovich p, String[] test, NameType type, Gender gender) {
        assertEquals(p.say(test[0], type, gender, Case.Genitive), test[1], "Genitive case, " + gender + ":");
        assertEquals(p.say(test[0], type, gender, Case.Dative), test[2], "Dative case, " + gender + ":");
        assertEquals(p.say(test[0], type, gender, Case.Accusative), test[3], "Accusative case, " + gender + ":");
        assertEquals(p.say(test[0], type, gender, Case.Instrumental), test[4], "Instrumental case, " + gender + ":");
        assertEquals(p.say(test[0], type, gender, Case.Prepositional), test[5], "Prepositional case, " + gender + ":");
    }


    private static List<String[]> load(String fileName) {
        InputStream is = PetrovichTests.class.getResourceAsStream("/" + fileName);
        try {
            List<String[]> res = new ArrayList<String[]>();
            for (Scanner scanner = new Scanner(is, "UTF-8"); scanner.hasNext(); ) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    res.add(line.split(","));
                }
            }
            return res;
        } finally {
            try {
                is.close();
            } catch (IOException ignored) {
            }
        }
    }
}
