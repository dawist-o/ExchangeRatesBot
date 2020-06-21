package BotManagement;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public enum BotState {
    MENU {
        @Override
        public ArrayList<KeyboardRow> updateKeyboard() {
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            KeyboardRow secondKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("Курсы валют");
            firstKeyboardRow.add("Калькулятор");
            secondKeyboardRow.add("Помощь");
            keyboard.add(firstKeyboardRow);
            keyboard.add(secondKeyboardRow);
            return keyboard;
        }
    },
    CALCULATOR {
        @Override
        public ArrayList<KeyboardRow> updateKeyboard() {
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            KeyboardRow secondKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("BYN");
            firstKeyboardRow.add("USD");
            firstKeyboardRow.add("EUR");
            firstKeyboardRow.add("RUB");
            secondKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            keyboard.add(secondKeyboardRow);
            return keyboard;
        }
    },
    HELP {
        @Override
        public ArrayList<KeyboardRow> updateKeyboard() {
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            return keyboard;
        }
    },
    RATES {
        @Override
        public ArrayList<KeyboardRow> updateKeyboard() {
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            KeyboardRow secondKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("Сегодня");
            firstKeyboardRow.add("Вчера");
            secondKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            keyboard.add(secondKeyboardRow);
            return keyboard;
        }
    },
    RATES_TODAY {
        @Override
        public ArrayList<KeyboardRow> updateKeyboard() {
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("Вчера");
            firstKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            return keyboard;
        }
    },
    RATES_YESTERDAY {
        @Override
        public ArrayList<KeyboardRow> updateKeyboard() {
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("Сегодня");
            firstKeyboardRow.add("Меню");
            keyboard.add(firstKeyboardRow);
            return keyboard;
        }
    };
    public abstract ArrayList<KeyboardRow> updateKeyboard();
}
