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
    // Множитель времени работы.
    private int multi = 1;
    // Число циклов работа-отдых.
    private int pomodoroCount = 2;
    // Точка входа в приложение.
    public static void main(String[] args) throws InterruptedException {
        PomodoroGame pg = new PomodoroGame();
        pg.init();
    }

    // Инициализация приложения и чтение параметров.
    public void init() throws InterruptedException {
        System.out.println("Добро пожаловать в Помидоро!");
        System.out.println("Введите желаемое время работы, отдыха и количество помидоров (--help):");
        String[] userInput = new Scanner(System.in).nextLine().split(" ");
        read_line_options(userInput);
        if (worked && (pomodoroCount > 0))
            System.out.printf("Параметры: время работы : " + workTime +
                        " мин, время отдыха : " + breakTime +
                        " мин, множитель времени работы : " + multi +
                        ", помидоров: " + pomodoroCount + "\n");
        // Основной цикл работа-отдых.
        pomodoro_loop();
        // Завершаем программу.
        System.out.println("Работа завершена!");
    }

    // Главный цикл приложения работа-отдых.
    private void pomodoro_loop() throws InterruptedException {
        while (worked && (pomodoroCount > 0)) {
            printProgress("Работа : ", workTime,  60);
            // Отдых имеет смысл только если за ним будет еще одна работа (то есть не последний цикл).
            if (pomodoroCount > 1)
                printProgress("Отдых  : ", breakTime, 60);
            pomodoroCount--;
            workTime *= multi;
        }
    }

    // Разбираем массив параметров программы.
    private void read_line_options(String[] userInput) {
        for (int i = 0; i < userInput.length && worked; i++) {
            String msg = userInput[i];
            if (msg != "") {
                //System.out.println("Команда:" + msg);
                switch (msg) {
                    case "--help":
                        System.out.println("""
                                Pomodoro - это приложение для тренировки и повышения личной эффективности.
                                -w <минуты> - время работы,
                                -b <минуты> - время отдыха,
                                -m <множитель> - на каждом новом цикле время работы увеличивается,
                                -c <количество> - циклы работа-отдых, 
                                -x - выход из программы,
                                --help - показать подсказку.\n""");
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
                    case "-m":
                        if (i < userInput.length - 1)
                            multi = Integer.parseInt(userInput[++i]);
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

    // Отображение прогресбара с ожиданием завершения текущей работы или отдыха.
    // String process - отображаемое название прогресбара,
    // time - время ожидания таймера в минутах,
    // size - размер прогресбара на экране в символах,
    // InterruptedException - необходимо для Thread.sleep.
    private void printProgress(String process, int time, int size) throws InterruptedException {
        // время в секундах
        int time_sec = time * 60;

        // Текущее пройденное время этапа (работа/отдых).
        float curr_tm = 0.0f;
        while (curr_tm < time_sec) {
            // Выполняем паузу в приложении на 100мс.
            Thread.sleep(100);
            // увеличиваем счетчик на 100мс.
            curr_tm = curr_tm + 0.1f;
            if (curr_tm > time_sec) curr_tm = time_sec;
            // Отображаемое время этапа в формате
            float look_tm = Math.round(curr_tm*10)/10;
            // Вычисляем процент и сразу приводим к формату ХХ.Х%
            double percent = Math.floor(curr_tm/(float)time_sec*1000.0f)/10.0f;
            // Число закрашенных символово прогресбара #
            int sym = Math.round((float)size * curr_tm / (float)time_sec);
            // Пройденное время в формате ХХ.X мин.
            double time_go = Math.floor((float)time * curr_tm * 10.0f / (float) time_sec) / 10.0f;
            // System.out.println("look="+look_tm+" curr="+curr_tm + " sym="+sym); // Тестовая печать.
            // Готовим строку - заголовок прогресбара.
            String head_str = process + percent + "% " +
                    (" ").repeat(5 - (String.valueOf(percent).length()));
            // Отображаем всю строку прогрессбара поверх старой строки.
            System.out.print(head_str + "[" + ("#").repeat(sym) + ("-").repeat(size - sym)+
                    "]    ( " + time_go +"мин / " + time +"мин)"+  "\r");
        }
        System.out.println();
    }
}
