
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.Comparator;

import java.util.List;

import static java.lang.Math.toIntExact;

import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageCaption;


import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;


public class Application extends TelegramLongPollingBot {

    //public int num=1;
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {

            telegramBotsApi.registerBot(new Application());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "Miit Love";
    }

    @Override
    public String getBotToken() {
        //return "487089461:AAE131pIxM2o0KySxK2jHRvzJeXQK_r7qHI";

        return "594398219:AAF1RZTHUosJT7mK7ij8y1X9amP6Dk57aec";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();


        coreGUI coreMenu = new coreGUI();
        connectDB conn = new connectDB();

        if (message != null) {
            switch (conn.selectStateFromDB(message.getChatId().toString())) {
                case "0":

                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "📇Продолжить":
                                conn.UpdateState(message.getChatId().toString(), 1);
                                sendMessageMain(coreMenu.registerSexBot(message, "Выберите пол 🚹🚺"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADFgIAAjbsGwUrH3k-y6Vv9gI"));
                                break;


                        }
                    }

                    break;
                case "1":

                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "Муж":
                                conn.UpdateState(message.getChatId().toString(), 2);
                                conn.UpdateSex(message.getChatId().toString(), 1);
                                sendMessageMain(coreMenu.registerAgeBot(message, "Выберите Ваш возраст 🤔"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADTgEAAjbsGwVmaL1khrmddQI"));

                                break;
                            case "Жен":
                                conn.UpdateState(message.getChatId().toString(), 2);
                                conn.UpdateSex(message.getChatId().toString(), 2);
                                sendMessageMain(coreMenu.registerAgeBot(message, "Выберите Ваш возраст 🤔"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADTgEAAjbsGwVmaL1khrmddQI"));
                                break;

                        }
                    }

                    break;
                case "2":
                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "17":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 17);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "18":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 18);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "19":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 19);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "20":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 20);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "21":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 21);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "22":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 22);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "23":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 23);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "24":
                                conn.UpdateState(message.getChatId().toString(), 3);
                                conn.UpdateAge(message.getChatId().toString(), 24);
                                sendMessageMain(coreMenu.registerHelpBot(message, "Отправьте лучшую фотографию для вашего нового аккаунта 📷"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;

                        }
                    }


                    break;
                case "3":

                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "❗️Помощь":
                                sendMessageMain(coreMenu.sendMsgCore(message, "Тапните по пиктограмме в виде скрепки возле поля для сообщений📎 \nИ выберите фотографию из галереи или сделайте фото с помощью камеры."));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADHQADW34RE52gAXe2yKMWAg"));
                                break;


                        }
                    } else if (update.hasMessage() && message.hasPhoto()) {


                        List<PhotoSize> photos = message.getPhoto();

                        String f_id = photos.stream()
                                .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                                .findFirst()
                                .orElse(null).getFileId();


                        conn.UpdatePhoto(message.getChatId().toString(), f_id);
                        conn.UpdateState(message.getChatId().toString(), 4);
                        sendMessageMain(coreMenu.registerHelpBot(message, "Напишите пару слов о себе. \nДля примера название группы 🎓 хобби 🏄 ссылки на Инстаграм, Вконтакте и т.д."));
                        sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADBAAD7AIAAlI5kwZ5UZ4Wu90nGQI"));
                    }
                    break;
                case "4":

                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "❗️Помощь":
                                sendMessageMain(coreMenu.sendMsgCore(message, "Любая информация о Вас: смайлы, ссылки, текст.(Не поддерживаются гифки, стикеры, видео, фото, файлы)"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADHQADW34RE52gAXe2yKMWAg"));
                                break;

                            default:
                                conn.UpdateState(message.getChatId().toString(), 5);
                                conn.UpdateDiscription(message.getChatId().toString(), message.getText());
                                sendMessageMain(coreMenu.startBot(message, "Отлично! Вы полностью заполнили свой профиль. Теперь Вы с нами!"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgAD1wUAAjbsGwVnzbwqalKLrQI"));
                                break;
                        }
                    }

                    break;
                case "5":

                    if (message.hasText()) {


                        switch (message.getText()) {


                            case "💞Поиск":
                                sendPhotoMain(coreMenu.SearchPeople(message));
                                break;
                            case "📇Настройки":
                                conn.UpdateState(message.getChatId().toString(), 6);
                                sendMessageMain(coreMenu.OptionstBot(message, "Настройки профиля"));
                                break;
//				 case "2":
//					 for(int i=0;i<60;i++)
//					 {
//					 SendPhoto msg = new SendPhoto()
//		              .setChatId(message.getChatId().toString())
//		              .setPhoto(conn.selectALLPhoto().get(i))
//		              ;
//				 
//					 sendPhotoMain(msg);
//					 }
//	                 break;
                        }
                    }
//			 if (update.hasMessage() && message.hasPhoto()) {
//
//				    long chat_id = message.getChatId();
//
//				    List<PhotoSize> photos = message.getPhoto();
//
//				    String f_id = photos.stream()
//				                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
//				                    .findFirst()
//				                    .orElse(null).getFileId();
//				    System.out.println(f_id+"           "+num);
//				    conn.UpdatePhotoAll(f_id, num);
//				    num=num+1;
//				}

                    break;
                case "6":

                    if (message.hasText()) {

                        switch (message.getText()) {

                            case "👤Ваш профиль":
                                sendPhotoMain(coreMenu.ReturnMeForPeopleEnd(message.getChatId().toString(), message.getChatId().toString()));
                                break;
                            case "📸️Изм. фото":
                                conn.UpdateState(message.getChatId().toString(), 7);
                                sendMessageMain(coreMenu.registerHelp2Bot(message, "Отправьте фотографию, чтобы изменить аватарку профиля"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADygEAAjbsGwWaET7zEOMz9wI"));
                                break;
                            case "✍️Изм. описание":
                                conn.UpdateState(message.getChatId().toString(), 8);
                                sendMessageMain(coreMenu.registerHelp2Bot(message, "Напишите пару слов о себе"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADBAAD7AIAAlI5kwZ5UZ4Wu90nGQI"));
                                break;
                            case "🗑Удалить аккаунт":
                                conn.UpdateState(message.getChatId().toString(), 9);
                                sendMessageMain(coreMenu.DeleteBot(message, "Вы уверены, что хотите удалить аккаунт?"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADYwEAAjbsGwXkTe2zgRvwWAI"));
                                break;
                            case "⬅️Обратно":
                                conn.UpdateState(message.getChatId().toString(), 5);
                                sendMessageMain(coreMenu.startBot(message, "Главное меню"));
                                break;
                        }
                    }
                    if (update.hasMessage() && message.hasPhoto()) {


                        List<PhotoSize> photos = message.getPhoto();

                        String f_id = photos.stream()
                                .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                                .findFirst()
                                .orElse(null).getFileId();
                        System.out.println(f_id);

                    }
                    break;
                case "7":

                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "❗️Помощь":
                                sendMessageMain(coreMenu.sendMsgCore(message, "Тапните по пиктограмме в виде скрепки возле поля для сообщений📎 \nИ выберите фотографию из галереи или сделайте фото с помощью камеры."));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADHQADW34RE52gAXe2yKMWAg"));
                                break;
                            case "⬅️Обратно":
                                conn.UpdateState(message.getChatId().toString(), 6);
                                sendMessageMain(coreMenu.OptionstBot(message, "Настройки профиля"));
                                break;


                        }
                    } else if (update.hasMessage() && message.hasPhoto()) {


                        List<PhotoSize> photos = message.getPhoto();

                        String f_id = photos.stream()
                                .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                                .findFirst()
                                .orElse(null).getFileId();


                        conn.UpdatePhoto(message.getChatId().toString(), f_id);
                        conn.UpdateState(message.getChatId().toString(), 6);
                        sendMessageMain(coreMenu.OptionstBot(message, "Отлично! Фотография изменена."));
                    }
                    break;
                case "8":
                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "❗️Помощь":
                                sendMessageMain(coreMenu.sendMsgCore(message, "Любая информация о Вас: смайлы, ссылки, текст.(Не поддерживаются гифки, стикеры, видео, фото, файлы)"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgADHQADW34RE52gAXe2yKMWAg"));
                                break;
                            case "⬅️Обратно":
                                conn.UpdateState(message.getChatId().toString(), 6);
                                sendMessageMain(coreMenu.OptionstBot(message, "Настройки профиля"));
                                break;
                            default:
                                conn.UpdateState(message.getChatId().toString(), 6);
                                conn.UpdateDiscription(message.getChatId().toString(), message.getText());
                                sendMessageMain(coreMenu.OptionstBot(message, "Отлично! Описание изменено."));
                                break;
                        }
                    }

                    break;
                case "9":


                    if (message.hasText()) {


                        switch (message.getText()) {

                            case "Да":
                                conn.DeleteUserToDB(message.getChatId().toString());
                                sendMessageMain(coreMenu.registerBot(message, "Ваш аккаунт удачно удален, мы будем скучать."));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADAgAD9wADmY-lB42Lzic6DYb1Ag"));
                                break;

                            case "Нет":
                                conn.UpdateState(message.getChatId().toString(), 6);
                                sendMessageMain(coreMenu.OptionstBot(message, "Ну и хорошо ^^"));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADBAADnAMAAlI5kwYuCIUZcVF_EQI"));
                                break;
                        }
                    }
                    break;

                case "99":
                    if (message.hasText())
                        if (message.getText().equals("/start")) {

                            sendMessageMain(coreMenu.registerBot(message, "Приветствую тебя в нашей Миит пати, пройди регистрацию, нажав на кнопку👇"));
                            sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADBAADkQMAAlI5kwbnjKy7bSH9GAI"));
                        }

                    try {
                        if (message.getContact().getPhoneNumber() != null) {
                            List<String> listphone = conn.selectPhoneFromDB();
                            String youphone = message.getContact().getPhoneNumber();
                            if (youphone.substring(0, 1).equals("+"))
                                youphone = youphone.substring(1);
                            boolean metka = true;
                            for (int i = 0; i < listphone.size(); i++) {

                                if (youphone.equals(listphone.get(i)) == true) {
                                    metka = false;
                                }
                            }
                            if (metka == true) {
                                conn.InsertUserToDB(message.getChatId().toString(), youphone,
                                        message.getContact().getFirstName(), message.getContact().getLastName(), message.getChat().getUserName());
                                String mytext = "Уважаемый(ая) " + message.getContact().getFirstName() + ", Вы удачно зарегистрированы по номеру: +" + youphone;

                                sendMessageMain(coreMenu.registerNextBot(message, mytext));
                                sendStikerMain(coreMenu.sendStikerCore(message.getChatId().toString(), "CAADBAAD0AIAAlI5kwawwS2UUaU0XQI"));

                            } else {
                                String mytext = "Уважаемый " + message.getContact().getFirstName() + ", Вы уже были зарегистрированы по номеру: " +
                                        youphone;
                                sendMessageMain(coreMenu.registerNextBot(message, mytext));

                            }


                        }
                    } catch (NullPointerException ex) {
                    }


                    break;
            }
        } else if (update.hasCallbackQuery()) {
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            String chat_id_me = update.getCallbackQuery().getMessage().getChatId().toString();
            switch (call_data) {
                case "like":
                    String photo = update.getCallbackQuery().getMessage().getPhoto().stream()
                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                            .findFirst()
                            .orElse(null).getFileId();

                    EditMessageCaption editMessage = new EditMessageCaption();
                    editMessage.setChatId(chat_id_me);
                    editMessage.setMessageId(toIntExact(message_id));
                    editMessage.setCaption("Like");

                    String chatidYou = conn.selectChatIdFromPhoto(photo);


                    sendPhotoMain(coreMenu.ReturnMeForPeople(chat_id_me, chatidYou));
                    try {
                        execute(editMessage);
                    } catch (TelegramApiException e) {

                    }
                    sendPhotoMain(coreMenu.SearchPeople(chat_id_me));

                    // sendXLSMsg(chat_id);


                    break;

                case "nope":
                    DeleteMessage del = new DeleteMessage();

                    del.setChatId(chat_id_me);
                    del.setMessageId(toIntExact(message_id));

                    try {
                        execute(del);
                    } catch (TelegramApiException e) {
                        //    e.printStackTrace();
                    }
                    sendPhotoMain(coreMenu.SearchPeople(chat_id_me));

                    //  sendPDFMsg(chat_id);


                    break;

                case "nope2":
                    DeleteMessage del2 = new DeleteMessage();

                    del2.setChatId(chat_id_me);
                    del2.setMessageId(toIntExact(message_id));

                    try {
                        execute(del2);
                    } catch (TelegramApiException e) {
                        //   e.printStackTrace();
                    }


                    break;
                case "like2":
                    String photo2 = update.getCallbackQuery().getMessage().getPhoto().stream()
                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                            .findFirst()
                            .orElse(null).getFileId();

                    String chatidYou2 = conn.selectChatIdFromPhoto(photo2);

                    DeleteMessage deletemes = new DeleteMessage();

                    deletemes.setChatId(chat_id_me);
                    deletemes.setMessageId(toIntExact(message_id));

                    try {
                        execute(deletemes);
                    } catch (TelegramApiException e) {
                        //  e.printStackTrace();
                    }
                    sendMessageMain(coreMenu.ReturnMeForPeopleEndMes(chatidYou2, chat_id_me));
                    sendMessageMain(coreMenu.ReturnMeForPeopleEndMes(chat_id_me, chatidYou2));
                    sendPhotoMain(coreMenu.ReturnMeForPeopleEnd(chat_id_me, chatidYou2));

                    sendPhotoMain(coreMenu.ReturnMeForPeopleEnd(chatidYou2, chat_id_me));
                    sendStikerMain(coreMenu.sendStikerCore(chat_id_me, "CAADAgAD2QADmY-lB4lHkMcDiTfYAg"));
                    sendStikerMain(coreMenu.sendStikerCore(chatidYou2, "CAADAgAD2QADmY-lB4lHkMcDiTfYAg"));
                    //   sendPhotoMain( coreMenu.SearchPeople(chat_id_me));

                    //  sendPDFMsg(chat_id);


                    break;
            }
        }


    }


    private void sendMessageMain(SendMessage message) {

        try {

            execute(message);

        } catch (TelegramApiException e) {
            //e.printStackTrace();
        }
    }

    private void sendPhotoMain(SendPhoto message) {

        try {

            sendPhoto(message);

        } catch (TelegramApiException e) {
            //  e.printStackTrace();
        }
    }

    private void sendStikerMain(SendSticker message) {

        try {

            sendSticker(message);

        } catch (TelegramApiException e) {
            //e.printStackTrace();
        }
    }

}