package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculationsUnitTest {
    @Test
    public void calcByWordsGivenEmptyString() {
        final String givenString = "";
        final int expectedString = 0;
        final int actualString = Calculations.calcByWords(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByWordsGivenStringWithDotsAndCommas(){
        final String givenString = "Laba diena, sveiki atvyke.";
        final int expectedString = 4;
        final int actualString = Calculations.calcByWords(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByWordsGivenStringWithSpaceAfterDot(){
        final String givenString = "Laba diena. Sveiki atvyke.";
        final int expectedString = 4;
        final int actualString = Calculations.calcByWords(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByWordsGivenStringWithDotInBeginning(){
        final String givenString = ".Laba diena su vistiena.";
        final int expectedString = 4;
        final int actualString = Calculations.calcByWords(givenString);
        assertEquals(expectedString,actualString);//test fails because the dot before the first word is counted as a separate word
    }
    @Test
    public void calcByWordsGivenLongStringWithMultipleDotsAndCommas(){
        final String givenString = "Laba diena, sveiki atvyke. Siam miske yra trys gulbes, keturi briedziai, septynios zasys ir dvi kiaunes.";
        final int expectedString = 16;
        final int actualString = Calculations.calcByWords(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByCharsGivenEmptyString() {
        final String givenString = "";
        final int expectedString = 0;
        final int actualString = Calculations.calcByChars(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByCharsGivenStringWithDotsAndCommas(){
        final String givenString = "Laba diena, sveiki atvyke.";
        final int expectedString = 26;
        final int actualString = Calculations.calcByChars(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByCharsGivenStringWithSpaceAfterDot(){
        final String givenString = "Laba diena. Sveiki atvyke.";
        final int expectedString = 26;
        final int actualString = Calculations.calcByChars(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByCharsGivenStringWithDotInBeginning(){
        final String givenString = ".Laba diena su vistiena.";
        final int expectedString = 26;
        final int actualString = Calculations.calcByChars(givenString);
        assertEquals(expectedString,actualString);
    }
    @Test
    public void calcByCharsGivenLongStringWithMultipleDotsAndCommas(){
        final String givenString = "Laba diena, sveiki atvyke. Siam miske yra trys gulbes, keturi briedziai, septynios zasys ir dvi kiaunes.";
        final int expectedString = 104;
        final int actualString = Calculations.calcByChars(givenString);
        assertEquals(expectedString,actualString);
    }
}
