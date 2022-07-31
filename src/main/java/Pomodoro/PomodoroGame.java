package Pomodoro;
// Приложение помогает использовать "Метод помидора".
// Это техника управления временем, предложенная Франческо Чирило в конце 1980-х,
// предполагает увеличение эффективности работы при меньших временных затратах
// за счет глубокой концентрации и коротких перерывов.
// В классической технике, отрезки времени - "помидоры" длятся полчаса: 25 минут работа и 5 минут отдыха.
//
// Техническое задание:
// 1. вывести Приветствие, и выдать запрос на ввод параметров программы - время работы и время отдыха,
// 2. ввести с клавиатуры время работы, время отдыха и количество циклов работа-отдых ("помидоров"),
// 3. иметь возможность вывести подсказку по программе,
// 4. визуально отображать текущее состояние по технике - работа или отдых, с прогрессбаром.
// 5. когда все циклы-помидоры будут завершены, выйти из программы с сообщением "Работа завершена".

import java.util.Scanner;

public class PomodoroGame {
    private boolean worked = true;
    // Время работы, в минутах.
    private int workTime = 25;
    // Время отдыха, в минутах.
    private int breakTime = 5;
    // Число циклов работа-отдых.
    private int pomodoroCount = 2;
    // Точка входа в приложение.
    public static void main(String[] args) throws InterruptedException {
        PomodoroGame pg = new PomodoroGame();
        pg.init();
    }
    // Основная инициализация и главный цикл приложения.
    public void init() throws InterruptedException {
        System.out.println("Добро пожаловать в Помидоро!");
        System.out.println("Введите желаемое время работы, отдыха и количество помидоров (--help):");
        String[] userInput = new Scanner(System.in).nextLine().split(" ");
        read_line_options(userInput);
        if (worked && (pomodoroCount > 0))
            System.out.printf("Время работы : " + workTime +
                        ", время отдыха : " + breakTime +
                        ", помидоров: " + pomodoroCount + "\n");
        // Основной цикл работа-отдых.
        pomodoro_loop();
        // Завершаем программу.
        System.out.println("Работа завершена!");
    }

    private void pomodoro_loop() throws InterruptedException {
        while (worked && (pomodoroCount > 0)) {
            printProgress("Время работы : ", workTime, 60);
            printProgress("Время отдыха : ", breakTime, 60);
            pomodoroCount--;
        }
    }

    // Разбираем массив параметров программы.
    private void read_line_options(String[] userInput) {
        for (int i = 0; i < userInput.length; i++) {
            String msg = userInput[i];
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
                        if (i < userInput.length - 1)
                            workTime = Integer.parseInt(userInput[++i]);
                        break;
                    case "-b":
                        if (i < userInput.length - 1)
                            breakTime = Integer.parseInt(userInput[++i]);
                        break;
                    case "-c":
                        if (i < userInput.length - 1)
                            pomodoroCount = Integer.parseInt(userInput[++i]);
                        break;
                    case "-x":
                        worked = false;
                        break;
                }
            }
        }
    }

    // String process - отображаемое название прогресбара,
    // time - время ожидания таймера в секундах,
    // size - размер прогресбара на экране в символах (кратное времени ожидания),
    // InterruptedException - необходимо для обработки TimeUnit.SECONDS.sleep (заменить?).
    private void printProgress(String process, int time, int size) throws InterruptedException {
        // Количество секунд в одном символе прогресбара.
        int length = 60* time / size;
        // Реальная длина прогрессбара в символах.
        int rep = 60* time /length;

        int stretch_b = size /(3* time);
        for(int i=1; i <= rep; i++){
            // Текущий размер заполненной полосы прогрессбара.
            double x = i;
            x = 1.0/3.0 *x;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            double w = time * stretch_b;
            double percent = (x / w) * 1000;
            x /= stretch_b;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            percent = Math.round(percent);
            percent /= 10;
            System.out.print(process + percent + "% " + (" ").repeat(
                    5 - (String.valueOf(percent).length())) +
                    "[" + ("#").repeat(i) + ("-").repeat(rep - i)+
                    "]    ( " + x +"min / " + time +"min )"+  "\r");
            Thread.sleep(length*1000);
        }
        System.out.println();
    }
}
