package model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DataModel {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();


    public String getData() throws InterruptedException {

        return queue.take();

    }

    public Boolean addData(String data){
        return queue.offer(data);
    }


}
