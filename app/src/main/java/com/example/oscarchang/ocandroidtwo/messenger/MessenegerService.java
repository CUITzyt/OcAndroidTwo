package com.example.oscarchang.ocandroidtwo.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.example.oscarchang.ocandroidtwo.util.MyLog;

/**
 * Created by SDT13976 on 2018/5/15.
 */
public class MessenegerService extends Service {

    private static final int MSG_SUM_CLIENT = 0xff0001;

    @Override
    public IBinder onBind(Intent intent) {
        MyLog.i(" MessenegerService onBind() ");
        return messenger.getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.i(" MessenegerService onCreate() ");
    }

    private Messenger messenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Message messageToClient = Message.obtain(msg);
            switch (msg.what) {
                case MSG_SUM_CLIENT:
                    MyLog.i(" MessengerService has got arg1 " + msg.arg1 + " arg2 is " + msg.arg2);
                    messageToClient.what = MSG_SUM_CLIENT;
                    messageToClient.arg2 = msg.arg1 + msg.arg2;
                    try {
                        Thread.sleep(2000);
                        msg.replyTo.send(messageToClient);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    });
}
