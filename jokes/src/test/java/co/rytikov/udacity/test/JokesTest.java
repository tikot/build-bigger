package co.rytikov.udacity.test;

import org.junit.Test;

import co.rytikov.udacity.Jokes;

public class JokesTest {
    @Test
    public void numberOfJokes() {
        Jokes jokes = new Jokes();
        assert jokes.jokes.length == 7;
    }
}