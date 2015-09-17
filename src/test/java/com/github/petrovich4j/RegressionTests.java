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

    @Test
    public void issue2() throws Exception {
        assertEquals(petrovich.say("Павел", NameType.FirstName, Gender.Male, Case.Genitive), "Павла");
        assertEquals(petrovich.say("Павел", NameType.FirstName, Gender.Male, Case.Dative), "Павлу");
        assertEquals(petrovich.say("Павел", NameType.FirstName, Gender.Male, Case.Accusative), "Павла");
        assertEquals(petrovich.say("Павел", NameType.FirstName, Gender.Male, Case.Instrumental), "Павлом");
        assertEquals(petrovich.say("Павел", NameType.FirstName, Gender.Male, Case.Prepositional), "Павле");
    }
}