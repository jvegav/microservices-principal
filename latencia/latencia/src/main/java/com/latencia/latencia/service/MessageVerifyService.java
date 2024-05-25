package com.latencia.latencia.service;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.VerificationCheck;

public class MessageVerifyService {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC1ecafd15aa3fc0a2974c61a972f1453f";
    public static final String AUTH_TOKEN = "f09f9d91cd52786bd7a4ce96b421dae2";
    public static final String SERVICE_AUTH = "VA5af1ad8306482f8c1bf2d501647344f9";


  public String verificar(String numero, String telefono) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    VerificationCheck verificationCheck = VerificationCheck.creator(
            SERVICE_AUTH,numero).setTo(telefono).create();

    return verificationCheck.getStatus();
  }
    
}


