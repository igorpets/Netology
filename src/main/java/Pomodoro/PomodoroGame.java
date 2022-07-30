package Pomodoro;
import java.util.Arrays;
import java.util.Scanner;
public class PomodoroGame {
    public static void main(String[] args) {
        // в секундах
        int workTime = 10;
        int breakTime = 2;
        System.out.println("Добро пожаловать в Помидоро!");
        String[] userInput = new Scanner(System.in).nextLine().split(" ");
        //Arrays.stream(userInput).sequential().forEach(msg -> my_print(msg));
        System.out.println("");

        for (String msg: userInput) {
            check_comand(msg);
        }
    }

    private static void check_comand(String msg) {
        if (msg != "") System.out.println("Команда:" + msg);
    }
}
