package com.trivia.champion;

public interface IShow {
    int mainMenu();
    int difficultyLevel(Category category);
    int askQuestion(Question question);
}