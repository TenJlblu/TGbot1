package my_bot;

import org.telegram.telegrambots.ApiContextInitializer;

public class EntryPoint {
    public static void main(String[] args){
        AnswerGenerator generator = new AnswerGenerator();
        AnswerGenerator generator1 = new AnswerGenerator();
        ApiContextInitializer.init();
        TGBot telegramBot = new TGBot(generator1);
        //telegramBot.SetAnswerGenerator(generator1);
        CMDBot cmdBot = new CMDBot(generator);
        JThread tgThread = new JThread("Telegram bot", telegramBot);
        JThread cmdThread = new JThread("Cmd bot", cmdBot);
    }
}
