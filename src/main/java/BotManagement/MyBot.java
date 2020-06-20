package BotManagement;
import BotManagement.BotStateController.BotState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.IOException;
import java.util.ArrayList;

import static ActionsWithRates.Rates.getRates;

public class MyBot extends TelegramLongPollingBot {

    private final String TG_TOKEN = "1201817328:AAHFFQav5s3_HszxLD3IO9aq3pzrsCgJqr8";
    private final String TG_BOT_NAME = "dawist_o_Bot";
    private long chat_id;
    public static BotState botState = BotState.MENU;
    //our keyboard
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        chat_id = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage().setChatId(chat_id);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            sendMessage.setText(getMessage(update.getMessage().getText()));
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void setBotState_Menu(){

    }

    private String getMessage(String message) {
        //buttons in rows
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstKeyboardRow = new KeyboardRow();
        KeyboardRow secondKeyboardRow = new KeyboardRow();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //todo refactor
        if (message.toLowerCase().equals("меню")) {
            firstKeyboardRow.add("Курсы валют");
            firstKeyboardRow.add("Калькулятор");
            secondKeyboardRow.add("Меню");
            secondKeyboardRow.add("Помощь");
            keyboard.add(firstKeyboardRow);
            keyboard.add(secondKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Вы вернулись в главное меню";
        }
        if (message.toLowerCase().equals("помощь")) {
            firstKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            //TODO more information
            return "Меню - возврат в меню." +
                    "Помощь - ознакомдение с командами бота." +
                    "Курсы валют - узнать курсы валют" +
                    "Калькулятор - подсчитать обмен валют";
        }
        if (message.toLowerCase().equals("курсы валют")) {
            firstKeyboardRow.add("Сегодня");
            firstKeyboardRow.add("Вчера");
            secondKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            keyboard.add(secondKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите дату или вернитесь в главное меню";
        }
        if (message.toLowerCase().equals("сегодня")) {
            firstKeyboardRow.add("Вчера");
            firstKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            try {
                return getRates(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if (message.toLowerCase().equals("вчера")) {
            keyboard.clear();
            firstKeyboardRow.add("сегодня");
            firstKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            try {
                return getRates(3);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if (message.toLowerCase().equals("калькулятор")) {
            keyboard.clear();
            firstKeyboardRow.add("BYN");
            firstKeyboardRow.add("EUR");
            firstKeyboardRow.add("RUB");
            firstKeyboardRow.add("USD");
            firstKeyboardRow.add("EUR");
            secondKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            keyboard.add(secondKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите валюту";
        }
        return getMessage("Помощь");
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

    public static BotState getBotState() {
        return botState;
    }

    public static void setBotState(BotState botState) {
        MyBot.botState = botState;
    }

    public String getBotUsername() {
        return TG_BOT_NAME;
    }

    public String getBotToken() {
        return TG_TOKEN;
    }
}
