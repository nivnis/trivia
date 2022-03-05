package com.trivia.champion;

import com.trivia.champion.questions.Question;

import java.util.ArrayList;
import java.util.List;

public interface IPlayerUi {
    void showWelcomePage();

    void askForUserName();

    void askForUserPassword();

    void existingUser();

    void couldNotFindUser();

    void incorrectPassword();

    void greetUser(String userName, int userScore);

    void showTotalScore(int totalScore);

    void showMainMenu(ArrayList<String> categories);

    void showDifficultyLevel(String category);

    void showQuestion(Question question);

    void showApiProblem();

    void showCorrectAndScore(int currentRoundScore);

    void showTotalRoundScore(int totalRoundScore);

    void scoreBoard(List<User> top10Users);
}