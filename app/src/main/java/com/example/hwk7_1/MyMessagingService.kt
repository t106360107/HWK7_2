package com.example.hwk7_1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyMessagingService :  FirebaseMessagingService() {
    companion object {
        const val TAG = "MessagingService"
    }
    //APP取得新token時呼叫，通常是在第一次啟動APP時會自動與Firebase註冊
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e(TAG, "onNewToken  $token")
    }
    //APP在前景時收到Notification Message會呼叫
    override fun onMessageReceived(msg: RemoteMessage) {
        super.onMessageReceived(msg)
        Log.e(TAG, msg.from ?: "")
        //透過for loop將msg夾帶的資料輸出
        for(entry in msg.data.entries)
            Log.e("message","${entry.key}/${entry.value}")
    }

}
