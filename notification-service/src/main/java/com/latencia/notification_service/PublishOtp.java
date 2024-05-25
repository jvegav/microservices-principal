package com.latencia.notification_service;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;

public class PublishOtp {
    public static final String ACCOUNT_SID = "AC1ecafd15aa3fc0a2974c61a972f1453f";
    public static final String AUTH_TOKEN = "f09f9d91cd52786bd7a4ce96b421dae2";
    public static final String SERVICE_AUTH = "VA5af1ad8306482f8c1bf2d501647344f9";

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



