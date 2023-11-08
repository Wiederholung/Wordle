# Wordle

> Course Project of EBU4201 Introductory Java Programming (2021/22)

## Getting Started

This is a New York Times style Wordle game developed in Java Swing.

- Guess the Wordle word in tries just one more than the word length you selected.
- Each guess must be a valid word with the length you selected.
- For each letter you confirm to enter, it will show:
    - Green if it is in the word and in the correct spot.
    - Yellow if it is in the word but in the wrong spot.
    - Grey if it is not in the word in any spot.

## Structure

The workspace contains 4 folders by default, where are:

- `src`: source code
- `doc`: JavaDoc
- `out`: compiled files
- `resources`: word database and test case

## Complie & Run

Open with VS Code/IDEA and run the main method in Wordle.java, or run the following command in the terminal:

```bash
cd src
javac -d . *.java
java Wordle
```

## Test

See in `resources` folder.

## Reference

- [New York Times](https://www.nytimes.com/games/wordle/index.html)
- [Functional Design Document](https://www.mubucm.com/doc/7zAyAh92DyW)
