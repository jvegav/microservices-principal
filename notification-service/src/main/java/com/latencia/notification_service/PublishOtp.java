package com.latencia.notification_service;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;

public class PublishOtp {
    private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    private static final String SERVICE_AUTH = System.getenv("TWILIO_SERVICE_AUTH");
    public void publish(String number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification = Verification.creator(
                SERVICE_AUTH,
                number,
                "sms")
            .create();
    
        System.out.println(verification.getSid());
      }
    
}



