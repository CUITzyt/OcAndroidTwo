package com.example.oscarchang.ocandroidtwo;

import android.app.Service;
import android.content.Intent;
import android.os.*;

import com.example.oscarchang.ocandroidtwo.util.CommUtil;
import com.example.oscarchang.ocandroidtwo.util.MyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDT13976 on 2018/5/14.
 */
public class RemoteService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.setTAG("OscarChang");
        MyLog.i(" RemoteService onCreate() ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public void callBackAdd(int fir, int sec){
        final int N = callbackList.beginBroadcast();
        for (int i=0; i<N; i++){
            try {
                int sum = callbackList.getBroadcastItem(i).getActivitySum(fir,sec);
                MyLog.i(" inRemoteService sum is  " + sum);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        callbackList.finishBroadcast();
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub(){

        @Override
        public List<Book> getBooks() throws RemoteException {
            List<Book> books = new ArrayList<Book>();
            books = CommUtil.generateBooks();
            return books;
        }

        @Override
        public int getPid() throws RemoteException {
            callBackAdd(1,2);
            return android.os.Process.myPid();
        }

        @Override
        public void registerCallBack(IRemoteCallBack cb) throws RemoteException {
            if (cb != null){
                callbackList.register(cb);
            }
        }

        @Override
        public void unregisterCallBack(IRemoteCallBack cb) throws RemoteException {
            if (cb != null){
                callbackList.unregister(cb);
            }
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }
    };

    public final RemoteCallbackList <IRemoteCallBack> callbackList = new RemoteCallbackList<IRemoteCallBack>();
}
