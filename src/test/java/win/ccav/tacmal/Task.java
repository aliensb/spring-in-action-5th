package win.ccav.tacmal;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Task implements Runnable {


    public Task(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void run() {
        for(int i=0;i<=1;i++){
            if(i==0){
                printTimeMsg("initialization");
            }else{
                printTimeMsg("executing");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"complete");
    }

    private void printTimeMsg(String state){
        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
        System.out.println(state+"time for task name "+name+"="+simpleDateFormat.format(d));
    }
}
