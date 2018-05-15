package com.example.oscarchang.ocandroidtwo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by SDT13976 on 2018/5/15.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.BOOT_COMPLETED")){
            context.startService(new Intent(context,RemoteService.class));
        }
    }
}
