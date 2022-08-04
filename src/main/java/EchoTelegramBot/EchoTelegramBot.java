package EchoTelegramBot;
/* Пример телеграм-бота ECHO.
Done! Congratulations on your new bot. You will find it at t.me/MyPomodoro77Bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.
Use this token to access the HTTP API:
5433494058:AAGqZTo9RbOlbwPioSlIBjXOBPXp9TLgLUg
Keep your token secure and store it safely, it can be used by anyone to control your bot.
For a description of the Bot API, see this page: https://core.telegram.org/bots/api
*/
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoTelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "MyPomodoro77Bot";
    }

    @Override
    public String getBotToken() {
        // Токен, выданный BotFather.
        return "5433494058:AAGqZTo9RbOlbwPioSlIBjXOBPXp9TLgLUg";
    }

    // При каждом событии (сообщении, подключении и т.д.) в чат-боте нам придет вызов с объектом update.
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("= "+update.toString());
        if (update.hasMessage()) {
            // Выделяем объект-сообщение от пользователя.
            Message in_msg = update.getMessage();
            if (in_msg.hasText()) {
                // Определяем уникальный идентификатор чата для отправки обратных сообщений.
                long chat_id = in_msg.getChatId();
                String text = in_msg.getText();
                if (text.equals("/start")) {
                    // Приветствие при подключении новых пользователей.
                    sendMsg(chat_id, "Добро пожаловать в чат ECHO_BOT!");
                } else {
                    // Основной режим "ЭХО".
                    sendMsg(chat_id, text + " :)");
                }
                // Журнал сообщений пользователей.
                Chat chat = in_msg.getChat();
                String user_name = chat.getUserName();
                if (user_name == null) {
                    String user_name1 = chat.getFirstName();
                    String user_name2 = chat.getLastName();
                    if (user_name1 == null && user_name2 == null) {
                        user_name = chat.getId().toString();
                    } else if (user_name1 != null) {
                        user_name = user_name1;
                    } else {
                        user_name = user_name2;
                    }
                }
                System.out.println("Получено сообщение " + text + " от: " +user_name);
            }
        }
    }

    // Отправка пользователю сообщения text.
    private void sendMsg(long chat_id, String text) {
        // Создаем объект-сообщение.
        SendMessage msg = new SendMessage();
        // Указываем в сообщении чат-получатель.
        msg.setChatId(chat_id);
        // Указываем текст сообщения.
        msg.setText(text);
        try {
            // Отправляем сообщение. Эта операция можеть быть выполнена с ошибкой.
            execute(msg);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
