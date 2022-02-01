import java.util.Scanner;

public class Console implements IShow{

    @Override
    public int mainMenu() {
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("Pick a category:");
        System.out.println("-------------------------\n");
        System.out.println("1 - General");
        System.out.println("2 - Science");
        System.out.println("3 - Geography");
        System.out.println("4 - Entertainment");
        System.out.println("5 - Quit");
        return getIntFromUser(Constants.NUM_OF_MAIN_MENU_OPTIONS);
    }

    @Override
    public int difficultyLevel(Category category) {
        System.out.println("Category: " + category.toString());
        System.out.println("-------------------------\n");
        System.out.println("Pick a difficulty level:");
        System.out.println("-------------------------\n");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("4 - Back to Main Menu");
        return getIntFromUser(Constants.NUM_OF_CATEGORY_OPTIONS);
    }

    @Override
    public int askQuestion(Question question) {
        return 0;
    }

    public int getIntFromUser(int endOfRange) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                if (num > 0 && num <= endOfRange) {
                    return num;
                } else {
                    System.out.println("please enter a number between 1 to " + endOfRange);
                }
            } catch (Exception e) {
                System.out.println("please enter a valid number.");
            }
        }
    }

}
