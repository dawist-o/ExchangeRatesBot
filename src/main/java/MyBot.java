import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {

    private final String TG_TOKEN = "1201817328:AAHFFQav5s3_HszxLD3IO9aq3pzrsCgJqr8";
    private final String TG_BOT_NAME = "dawist_o_Bot";

    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyToMessageId(update.getMessage().getMessageId());
        if (update.getMessage() == null || !update.getMessage().hasText())
            return;
        if (update.getMessage().getText().equals("Привет")) {
            try {
                sendMessage.setText("Привет. Напиши мне слово \"Курсы\" чтобы узнать курсы валют");
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.getMessage().getText().equals("Курсы")) {
            try {
                sendMessage.setText(Rates.getRates());
                execute(sendMessage);
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void sendMsg(Message message, String text) {
        SendMessage sMessage = new SendMessage();
        sMessage.enableMarkdown(true);
        sMessage.setChatId(message.getChatId());
        sMessage.setText(text);
        try {
            execute(sMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return TG_BOT_NAME;
    }

    public String getBotToken() {
        return TG_TOKEN;
    }
}
