package com.xuzhaoju.util;

import com.xuzhaoju.frame.MainFrameOne;
import com.xuzhaoju.frame.login;
import com.xuzhaoju.util.ModelUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/17 22:51
 */
public class OneThread implements Runnable  {
    @Override
    public void run() {
        Date date = null;
        while (true){
            date = Calendar.getInstance().getTime();
            Thread thread = Thread.currentThread();
            //线程睡眠1秒
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ModelUtils.TIME = ModelUtils.getSimpleDateFormat().format(date);
            login.timeButton.setText(ModelUtils.TIME);
            MainFrameOne.text.setText(ModelUtils.TIME);
        }
    }
}
