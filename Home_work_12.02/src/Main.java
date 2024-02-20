import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.println("Чтобы закончить опросник введите 'exit'");

        System.out.println("Сколько игроков будет играть в игру: ");
        int numPlayers = scanner.nextInt();

        String[] nameOfPlayer = new String[numPlayers];
        int[] point = new int[numPlayers];


        for (int i = 0; i < numPlayers; i++) {

            System.out.println("Введите как зовут игрока " + (i + 1) + ": ");
            nameOfPlayer[i] = scanner.next();

        }
        for (int question = 0; question < 3; question++) {


            for (int playerI = 0; playerI < numPlayers; playerI++) {
                int number1 = random.nextInt(50);
                int number2 = random.nextInt(50);
                char[] operators = {'+', '-', '*', '/'};
                char operator = operators[random.nextInt(operators.length)];

                System.out.println(nameOfPlayer[playerI] + ", вопрос " + (question + 1) + ". Дайте правильный ответ: " + number1 + " " + operator + " " + number2);
                System.out.println("Ваш ответ: ");
                int answer = scanner.nextInt();
                int correctAnswer = arithmethicOperation(number1, number2, operator);

                if (answer == correctAnswer) {
                    System.out.println("Поздравляю, ваш ответ правильный! Вы заработали +5 баллов");
                    point[playerI] += 5;
                } else {
                    System.out.println("К сожалению, ваш ответ неправильный. - 5 баллов");
                    point[playerI] -= 5;
                }
                System.out.println("Правильный ответ: " + correctAnswer);
                System.out.println(nameOfPlayer[playerI] + " ваше общее количество баллов: " + point[playerI]);
            }
        }
        System.out.println("Опросник завершен. Список игроков и их счет: ");

        for (int j = 0; j < numPlayers; j++) {
            System.out.println(nameOfPlayer[j] + ": " + point[j] + " баллов.");
        }
    }
        private static int arithmethicOperation(int number1, int number2, char operator) {
            switch (operator) {
                case '+':
                    return number1 + number2;
                case '-':
                    return number1 - number2;
                case '*':
                    return number1 * number2;
                case '/':
                    return number1 / number2;
                default:
                    throw new
                            IllegalArgumentException("Неправильная арифметическая операция");

            }

        }
    }

