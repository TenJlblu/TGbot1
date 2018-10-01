package my_bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.*;

public class TGBot extends TelegramLongPollingBot implements Runnable {

    private AnswerGenerator solver;

    public void run(){
        TelegramBotsApi botApi = new TelegramBotsApi();
        //System.out.print("12345" + "\n");
        try {
            botApi.registerBot(new TGBot(this.solver));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    TGBot(AnswerGenerator generator){
        this.solver = generator;
    }

    public void onUpdateReceived(Update update){
        //System.out.print("-------------------------------------------------\n");
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            //System.out.print(message.getText() + "   ----   " + message.getText().getClass() + "\n");
            //System.out.print(message.toString() + "\n");
            //System.out.print(solver + "   solver\n");
            //String text = message.getText();
            //System.out.print(text + "     text\n");
            //String answer = solver.GetAnswer(text);
            //System.out.print(answer + "\n");
            sendMsg(message, solver.GetAnswer(message.getText()));
        }
        /*
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help") || message.getText().equals("hi"))
                sendMsg(message, "Hi, right, look, I can say you date and time (/date).");
            else if (message.getText().equals("/date"))
                sendMsg(message, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            else
                sendMsg(message, "hmm, I don't know, what to say.");
        }*/
    }

    private void sendMsg(Message message, String text){
        //System.out.print(text + "   ======================== \n");
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "UrFU Ft-202";
    }

    public String getBotToken() {
        return "616457548:AAEOiC4COqi8epMpNz9q-GhHx69hSPsiQFk";
    }
}
