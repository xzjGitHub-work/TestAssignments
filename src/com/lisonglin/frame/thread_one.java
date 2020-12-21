package com.lisonglin.frame;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/17 22:51
 */
public class thread_one implements Runnable  {
    @Override
    public void run() {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (true){
            date = Calendar.getInstance().getTime();
            Thread thread = Thread.currentThread();
            //线程睡眠1秒
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            login.userText.setText(format.format(date));
        }
    }
}
