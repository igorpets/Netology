package PomodoroTelegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Стартовый класс Телеграм-бота "Помидоро".
 * Обеспечивает взаимодействие с Telegram API,
 * начальную инициализацию и регистрацию бота.
 * t.me/MyPomodoro77Bot
 * Описание Bot API: https://core.telegram.org/bots/api
 * Token: 5433494058:AAGqZTo9RbOlbwPioSlIBjXOBPXp9TLgLUg
 *
 * @author Igor
 */

public class PomodoroMain {
    // Точка входа в приложение.
    public static void main(String[] args) throws TelegramApiException {
        // Объект для взаимодействия с Telegram API.
        var botsApi = new TelegramBotsApi(DefaultBotSession.class);
        // Создаем единственный экземпляр основного класса.
        var pomodoroBot = new PomodoroTelegram();
        // Регистрируем нового бота в Телеграм.
        botsApi.registerBot(pomodoroBot);
        // Инициализируем объект - внутри бесконечный цикл.
        pomodoroBot.init();
    }
}
