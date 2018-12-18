package ru.miitlovebot.gui;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.miitlovebot.database.connectDB;


public class coreGUI  {
    connectDB conn=new connectDB();
    public SendMessage sendMsgCore (Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        return sendMessage;

    }
    public SendSticker sendStikerCore (String chatid,String sticker) {
        SendSticker sendstiker = new SendSticker();

        sendstiker.setChatId(chatid);




        sendstiker.setSticker(sticker);




        return sendstiker;

    }


    public SendMessage createInlineButtondMenu(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Сайт университета");

        button.setUrl("http://miit.ru/portal/page/portal/miit");
        row.add(button);
        rows.add(row);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Расположение на карте");

        button2.setUrl("https://yandex.ru/maps/213/moscow/?ll=37.603274%2C55.789509&z=18&from=1org_map&mode=search&ol=biz&oid=1202533988");
        row2.add(button2);
        rows.add(row2);
        inlineKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }
    public SendPhoto  SearchPeople(Message message)
    {
        List<String> info=conn.selectPeople(message.getChatId().toString());
        SendPhoto msg = new SendPhoto()
                .setChatId(message.getChatId().toString())
                .setPhoto(info.get(2))
                .setCaption("Имя: "+info.get(1)+"\nОписание: "+info.get(3)+"\nВозраст: "+info.get(4));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Like");

        button.setCallbackData("like");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Nope");

        button2.setCallbackData("nope");

        row.add(button2);
        row.add(button);
        rows.add(row);
        inlineKeyboardMarkup.setKeyboard(rows);
        msg.setReplyMarkup(inlineKeyboardMarkup);
        return msg;
    }
    public SendPhoto  SearchPeople(String chatId)
    {
        List<String> info=conn.selectPeople(chatId);
        SendPhoto msg = new SendPhoto()
                .setChatId(chatId)
                .setPhoto(info.get(2))
                .setCaption("Имя: "+info.get(1)+"\nОписание: "+info.get(3)+"\nВозраст: "+info.get(4));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();

        button.setText("Like");

        button.setCallbackData("like");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Nope");

        button2.setCallbackData("nope");

        row.add(button2);
        row.add(button);
        rows.add(row);
        inlineKeyboardMarkup.setKeyboard(rows);
        msg.setReplyMarkup(inlineKeyboardMarkup);
        return msg;
    }
    public SendPhoto  ReturnMeForPeople(String chatIdMe,String chatIdYou)
    {
        List<String> info=conn.selectMe(chatIdMe);
        SendPhoto msg = new SendPhoto()
                .setChatId(chatIdYou)
                .setPhoto(info.get(2))
                .setCaption("Имя: "+info.get(1)+"\nОписание: "+info.get(3)+"\nВозраст: "+info.get(4));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();

        button.setText("Like");

        button.setCallbackData("like2");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Nope");

        button2.setCallbackData("nope2");

        row.add(button2);
        row.add(button);
        rows.add(row);
        inlineKeyboardMarkup.setKeyboard(rows);
        msg.setReplyMarkup(inlineKeyboardMarkup);
        return msg;
    }
    public SendPhoto  ReturnMeForPeopleEnd(String chatIdMe,String chatIdYou)
    {
        List<String> info=conn.selectMe(chatIdMe);
        SendPhoto msg = new SendPhoto()
                .setChatId(chatIdYou)
                .setPhoto(info.get(2))
                .setCaption("Имя: "+info.get(1)+"\nОписание: "+info.get(3)+"\nВозраст: "+info.get(4));

        return msg;
    }
    public SendMessage  ReturnMeForPeopleEndMes(String chatIdMe,String chatIdYou)
    {
        List<String> info=conn.selectMeEnd(chatIdMe);
        List<String> info2=conn.selectMeEnd(chatIdYou);
        SendMessage sendMessage = new SendMessage();
        sendMessage.disableWebPagePreview();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatIdMe);
        sendMessage.setText("Уррраа! Образовалась новая пара "+info.get(0)+" - "+info2.get(0)+". Начните общаться в телеграмме по номеру: +"+info2.get(1)+" ❤️  \nНебольшая [инструкция](http://telegram.org.ru/357-kak-dobavit-kontakt-v-telegram.html) как создать чат.");



        return sendMessage;
    }

    public SendMessage startBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardNullRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardNullRow.add("💞Поиск");

        // Добавляем кнопки в первую строчку клавиатуры


        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры

        keyboardSecondRow.add("📇Настройки");


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardNullRow);

        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage OptionstBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardNullRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardNullRow.add("👤Ваш профиль");
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("📸️Изм. фото");

        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("✍️Изм. описание");
        KeyboardRow keyboard4Row = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboard4Row.add("🗑Удалить аккаунт");
        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры

        keyboardSecondRow.add("⬅️Обратно");


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardNullRow);
        keyboard.add(keyboardFirstRow);

        keyboard.add(keyboard4Row);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }

    public SendMessage registerBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры

        // Добавляем кнопки во вторую строчку клавиатуры
        KeyboardButton key2=new KeyboardButton();
        //keyboardSecondRow.add("🚆Об университете");
        key2.setText("📇Регистрация").getRequestContact();
        key2.setRequestContact(true);
        keyboardFirstRow.add(key2);
        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage registerHelpBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры

        // Добавляем кнопки во вторую строчку клавиатуры
        KeyboardButton key2=new KeyboardButton();
        //keyboardSecondRow.add("🚆Об университете");
        key2.setText("❗️Помощь");
        keyboardFirstRow.add(key2);
        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage registerHelp2Bot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardNullRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardNullRow.add("❗️Помощь");
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("⬅️Обратно");


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardNullRow);
        keyboard.add(keyboardFirstRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage registerNextBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры

        // Добавляем кнопки во вторую строчку клавиатуры
        KeyboardButton key2=new KeyboardButton();
        //keyboardSecondRow.add("🚆Об университете");
        key2.setText("📇Продолжить");
        keyboardFirstRow.add(key2);
        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage registerAgeBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);


        List<KeyboardRow> keyboard = new ArrayList<>();




        for(int i=0;i<8;i++)
        {   KeyboardRow    keyboardFirstRow = new KeyboardRow();
            KeyboardButton keyitem=new KeyboardButton();
            int age=17+i;
            keyitem.setText(Integer.toString(age));

            keyboardFirstRow.add(keyitem);
            keyboard.add(keyboardFirstRow);
        }




        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage registerSexBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        // Добавляем кнопки в первую строчку клавиатуры

        // Добавляем кнопки во вторую строчку клавиатуры
        KeyboardButton key2=new KeyboardButton();
        KeyboardButton key=new KeyboardButton();
        //keyboardSecondRow.add("🚆Об университете");
        key2.setText("Муж");

        keyboardFirstRow.add(key2);
        key.setText("Жен");

        keyboardFirstRow.add(key);
        //keyboardSecondRow.add("🚆Об университете");


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
    public SendMessage DeleteBot(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        // Добавляем кнопки в первую строчку клавиатуры

        // Добавляем кнопки во вторую строчку клавиатуры
        KeyboardButton key2=new KeyboardButton();
        KeyboardButton key=new KeyboardButton();
        //keyboardSecondRow.add("🚆Об университете");
        key2.setText("Да");

        keyboardFirstRow.add(key2);
        key.setText("Нет");

        keyboardFirstRow.add(key);
        //keyboardSecondRow.add("🚆Об университете");


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;

    }
}
