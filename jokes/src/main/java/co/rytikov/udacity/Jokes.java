package co.rytikov.udacity;

import java.util.Random;

public class Jokes {

    public String[] jokes = {
        // 1
        "Knock, knock.\n" +
            "\n" +
            "Who's there?\n" +
            "\n" +
            "very long pause...\n" +
            "\n" +
            "Java.",
        // 2
        "How many programmers does it take to change a light bulb?\n" +
            "\n" +
            "None, that's a hardware problem!",
        // 3
        "If you put a million monkeys at a million keyboards, one of them will eventually write a Java program.\n" +
            "\n" +
            "The rest of them will write Perl programs.",
        // 4
        "Q: Whats the object-oriented way to become wealthy?\n" +
            "\n" +
            "A: Inheritance",
        // 5
        "It's not a bug, it's a feature!",
        // 6
        "Q: How many Microsoft programmers does it take to change a light bulb?\n" +
            "\n" +
            "None, Bill Gates will just redefine Darkness as the new industry standard.",
        // 7
        "Programmer's son asks his father: Dad, why do the sun rise on the east and set on the west?\n" +
            "\n" +
            "Father: It works? don't touch it."
    };

    public String getRandomJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}