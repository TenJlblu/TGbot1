package my_bot;

class JThread extends Thread{

    Runnable item;

    JThread(String name, Runnable item){
        super(name);
        this.item = item;
        //System.out.print("Thread with name " + name + " is created");
        start();
    }

    public void run(){
        //System.out.printf("%s started... \n", Thread.currentThread().getName());
        try {
            item.run();
            Thread.sleep(500);
        } catch(InterruptedException e) {
            return;
            //System.out.println("Thread has been interrupted");
        }
        //System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}