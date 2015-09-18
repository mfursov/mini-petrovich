package com.github.petrovich4j;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 *
 */
@Test
public class RegressionTests {
    private Petrovich petrovich;

    @BeforeTest
    public void setUp() {
        petrovich = new Petrovich();
    }

    private void checkName(NameType nameType, Gender gender, String p1, String p2, String p3, String p4, String p5, String p6) {
        assertEquals(petrovich.say(p1, nameType, gender, Case.Genitive), p2);
        assertEquals(petrovich.say(p1, nameType, gender, Case.Dative), p3);
        assertEquals(petrovich.say(p1, nameType, gender, Case.Accusative), p4);
        assertEquals(petrovich.say(p1, nameType, gender, Case.Instrumental), p5);
        assertEquals(petrovich.say(p1, nameType, gender, Case.Prepositional), p6);
    }

    @Test
    public void issue1() throws Exception {
        checkName(NameType.FirstName, Gender.Male, "Паша", "Паши", "Паше", "Пашу", "Пашей", "Паше");
    }

    @Test
    public void issue2() throws Exception {
        checkName(NameType.FirstName, Gender.Male, "Павел", "Павла", "Павлу", "Павла", "Павлом", "Павле");
    }

    @Test
    public void issue3() throws Exception {
        checkName(NameType.LastName, Gender.Female, "Ковалёва", "Ковалёвой", "Ковалёвой", "Ковалёву", "Ковалёвой", "Ковалёвой");
    }

    @Test
    public void issue4() throws Exception {
        checkName(NameType.PatronymicName, Gender.Male, "Ильич", "Ильича", "Ильичу", "Ильича", "Ильичом", "Ильиче");
    }

    @Test
    public void issue5() throws Exception {
        checkName(NameType.FirstName, Gender.Female, "Ия", "Ии", "Ие", "Ию", "Ией", "Ие");
    }

    @Test
    public void issue6() throws Exception {
        checkName(NameType.LastName, Gender.Male, "Муромец", "Муромца", "Муромцу", "Муромца", "Муромцем", "Муромце");
    }
}