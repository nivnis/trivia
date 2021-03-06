package com.trivia.champion.ui.output.player;

import com.trivia.champion.questions.Question;
import com.trivia.champion.users.Player;

import java.util.ArrayList;
import java.util.List;

public interface IPlayerUi {
    void greetUser(String userName, int userScore);

    void showTotalScore(int totalScore);

    void showMainMenu(ArrayList<String> categories);

    void showDifficultyLevel(String category);

    void showQuestion(Question question);

    void showApiProblem();

    void showCorrectAndScore(int currentRoundScore);

    void showTotalRoundScore(int totalRoundScore);

    void scoreBoard(List<Player> top10Users, int myPlace);
}
