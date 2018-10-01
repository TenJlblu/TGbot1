package my_bot;
import java.util.Scanner;

public class CMDBot implements Runnable {

    private AnswerGenerator solver;

    CMDBot(AnswerGenerator generator){
        this.solver = generator;
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        Boolean end = false;
        while (!end) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("end")){
                end = true;
                break;
            } else {
                System.out.print(solver.GetAnswer(line));
            }
        }
    }
}
