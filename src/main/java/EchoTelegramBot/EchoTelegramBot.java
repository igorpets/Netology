package EchoTelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoTelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Space15";
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage msg = new SendMessage();
            msg.setChatId(update.getMessage().getChatId());
            msg.setText(update.getMessage().getText()+"!");
            System.out.println("Получено сообщение от: " +
                    update.getMessage().getChat().getUserName());
            try {
                execute(msg);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }
}
