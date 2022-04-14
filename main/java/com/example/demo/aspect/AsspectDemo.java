package com.example.demo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Aspect
@Component
public class AsspectDemo {

    @Pointcut("execution(* com.example.demo.DAO.*.*(..))")
    //@Pointcut("execution(* com.example.demo.DAO.*.*(..))")
    private void daoo()
    {
    }
    // @Before("execution(public void add*())")
    //@Before("execution( * add*(com.example.demo.POJO.Account))")
    //@Before("execution( * com.example.demo.DAO.*.*(..))")
    @Before("daoo()")
    public void beforeadd(){
        System.out.println("\n\n======> this from the aspect before");

        final String username = "hothifazoubi@gmail.com";
        final String password = "123578964hothaifa";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("hothaifazoubi@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("hothaifazoubi@gmail.com, hothaifazoubi@gmail.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @After("execution( * com.example.demo.DAO.*.*(..))")
    public void afteradd(){
        System.out.println("======> this from the aspect after");
    }
}
