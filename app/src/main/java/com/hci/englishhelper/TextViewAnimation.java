package com.hci.englishhelper;

import android.widget.TextView;

public class TextViewAnimation {


    private static TextView tv;
    private static String s;
    private static int length;
    private static long time;
    static int n = 0;
    private static int nn;
    private static boolean running = false;


    public TextViewAnimation(TextView tv, String s, long time) {
        this.tv = tv;//textview
        this.s = s;//字符串
        this.time = time;//间隔时间
        this.length = s.length();
        running = true;
        startAnimation(n);//开启线程
    }


    public static void startAnimation(final int n) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final String stv = s.substring(0, n);//截取要填充的字符串
                            tv.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(stv);
                                }
                            });
                            Thread.sleep(time);//休息片刻
                            nn = n + 1;//n+1；多截取一个
                            if (nn <= length && running == true) {//如果还有汉字，那么继续开启线程，相当于递归的感觉
                                startAnimation(nn);
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }

        ).start();
    }


    public void stopAnimation() {
        running = false;
    }
}