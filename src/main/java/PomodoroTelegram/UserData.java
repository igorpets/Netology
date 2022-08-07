package PomodoroTelegram;

import PomodoroTelegram.PomodoroTelegram;

import java.time.Instant;

/**
 * Класс для хранения параметров текущего сеанса пользователя.
 */
public class UserData {
     // Идентификатор текущей (последней) сессии чата пользователя.
     long chatId;
     // Имя пользователя.
     String userName;
     // Время завершения текущего таймера работа-отдых.
     Instant time = null;
     // Тип текущего таймера.
     TimerType timerType = TimerType.NONE;
     //количество оставшихся циклов
     int cycle = 0;
     // текущие значения время работы, время отдыха, число циклов и множитель времени работы.
     int cfgWork = 25;
     int cfgRelax = 5;
     int cfgCount = 3;
     int cfgMulti = 1;
     public UserData (long chat_id, String user_name) {
          chatId = chat_id;
          userName = user_name;
     }
}

