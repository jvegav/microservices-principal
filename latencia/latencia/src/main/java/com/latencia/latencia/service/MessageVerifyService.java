package com.latencia.latencia.service;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.VerificationCheck;

public class MessageVerifyService {
  private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
  private static final String SERVICE_AUTH = System.getenv("TWILIO_SERVICE_AUTH");


  public String verificar(String numero, String telefono) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    VerificationCheck verificationCheck = VerificationCheck.creator(
            SERVICE_AUTH,numero).setTo(telefono).create();

    return verificationCheck.getStatus();
  }
    
}


