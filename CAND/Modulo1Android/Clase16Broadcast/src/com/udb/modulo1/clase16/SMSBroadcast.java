package com.udb.modulo1.clase16;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSBroadcast extends BroadcastReceiver {

SmsManager sms = SmsManager.getDefault();
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
		 
        try {
             
            if (bundle != null) {
                 
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                 
                for (int i = 0; i < pdusObj.length; i++) {
                     
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                     
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
 
                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);
                     
                    Toast.makeText(context, 
                    		"senderNum: "+ senderNum + ", message: " + message, 
                    		Toast.LENGTH_SHORT).show();
                    
                    
                    if(message.contains("PAQUETE")||message.contains("paquete")){
	                    PackageManager manager = context.getPackageManager();                    
	                    Intent intent2 = manager.getLaunchIntentForPackage("com.udb.modulo1.clase16");
	                    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                    intent2.putExtra("com.udb.modulo1.clase16.NOTIFICATION", "PAQUETE RECIBIDO");
	                    intent2.putExtra("com.udb.modulo1.clase16.MESSAGE", message);
	                    context.startActivity(intent2);
                    }
                    
                } // end for loop
              } // bundle is null
 
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
             
        }
	}
}
