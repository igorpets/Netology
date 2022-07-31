package Pomodoro;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PomodoroGame {
    private boolean worked = true;
    // в минутах
    private int workTime = 10;
    private int breakTime = 2;
    private int pomodoroCount = 2;
    public int test=0;
    public static void main(String[] args) throws InterruptedException {
        PomodoroGame pg = new PomodoroGame();
        pg.init();
    }
    public void init() throws InterruptedException {
        String[] userInput;
        System.out.println("Добро пожаловать в Помидоро!");
        while (worked && (pomodoroCount > 0)) {
            userInput = new Scanner(System.in).nextLine().split(" ");
            check_comand(userInput);
            if (worked) {
                System.out.printf("Время работы : " + workTime + ", время отдыха : " + breakTime + "\n");
                printProgress("Время работы : ", workTime, 60);
                pomodoroCount--;
            }
        }
    }

    private void check_comand(String[] userInput) {
        String msg;
        for (int i = 0; i < userInput.length; i++) {
            msg = userInput[i];
            if (msg != "") {
                //System.out.println("Команда:" + msg);
                switch (msg) {
                    case "--help":
                        System.out.println("""
                            Pomodoro - это приложение для тренировки и повышения личной эффективности.
                            -w <минуты> - время работы в минутах,
                            -b <минуты> - время отдыха в минутах (должно быть меньше времени работы),
                            -c <количество> - количество циклов работа-отдых, 
                            -x - выход из программы,
                            --help - показать подсказку по программе.\n""");
                        worked = false;
                        break;
                    case "-w":
                        if (i < userInput.length-1)
                            workTime = Integer.parseInt(userInput[++i]);
                        break;
                    case "-b":
                        if (i < userInput.length-1)
                            breakTime = Integer.parseInt(userInput[++i]);
                        break;
                    case "-c":
                        if (i < userInput.length-1)
                            pomodoroCount = Integer.parseInt(userInput[++i]);
                        break;
                    case "-x":
                        worked = false;
                        break;
                }
            }
        }
    }

    // String process - подпись прогресбара,
    // time - время ожидания в секундах,
    // size - размер прогресбара на экране в символах.
    private void printProgress(String process, int time, int size) throws InterruptedException {
        int length;
        int rep;
        length = 60* time / size;
        rep = 60* time /length;
        int stretch_b = size /(3* time);
        for(int i=1; i <= rep; i++){
            double x = i;
            x = 1.0/3.0 *x;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            double w = time *stretch_b;
            double percent = (x/w) *1000;
            x /=stretch_b;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            percent = Math.round(percent);
            percent /= 10;
            System.out.print(process + percent+"% " + (" ").repeat(5 - (String.valueOf(percent).length())) +"[" + ("#").repeat(i) + ("-").repeat(rep - i)+"]    ( " + x +"min / " + time +"min )"+  "\r");
            if(test == 0){
                TimeUnit.SECONDS.sleep(length);
            }
        }
        System.out.println();
    }
}
