package com.shop.utils;


import com.opensymphony.sitemesh.Content;
import com.shop.model.jpa.Account;
import com.shop.model.jpa.Cart;
import com.shop.model.jpa.Cartitem;
import com.shop.model.jpa.Product;
import static java.lang.System.out;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;

import java.util.Random;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

/**
 *
 * @author ADMIN
 */
public class SendEmailUtil {
  //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(Account acc) {
        boolean test = false;
        SendEmailUtil sm = new SendEmailUtil();
       // String code = sm.getRandom();
//        Account ac = new Account("khoi", "khoiyahoo@gmail.com",code);
//        boolean test = sm.sendEmail(ac);
            
            final String fromEmail = "khoiyahoo@gmail.com";
            final String fromPass ="minhkhoi";
            Properties pr = new Properties();
            pr.put("mail.smtp.auth",true);
            pr.put("mail.smtp.starttls.enable",true);
            pr.put("mail.smtp.host","smtp.gmail.com");
            pr.put("mail.smtp.port","587");
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
             @Override
             protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, fromPass);
                }
            });
            try {
                Message mess = new MimeMessage(session);		
                mess.setFrom(new InternetAddress(fromEmail));   		
                mess.setRecipient(Message.RecipientType.TO, new InternetAddress(acc.getEmail()));
                mess.setSubject("User Email Verification");	
                mess.setText("Registered successfully.Please verify your account using this code: " + acc.getCode());       
                Transport.send(mess);
                test = true;
            } catch (Exception e) {
                out.println(e);
             }
        return test;
    }
// //send email to the user email
//    public boolean sendGridEmail(Account acc) {
//        boolean test = false;
//        Email from = new Email("khoiyahoo@gmail.com");
//        String subject = "User Email Verification";
//        Email to = new  Email(acc.getEmail());
//        Content content = new Content("text/plain", acc.getCode());
//        Mail mail = new Mail(from, subject, to, content);
//
//        SendGrid sg = new SendGrid("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");
//        Request  rq = new Request();
//            try {
//               rq.setMethod
//                test = true;
//            } catch (Exception e) {
//                out.println(e);
//             }
//        return test;
//    }
    public static void main(String[] args){
        SendEmailUtil sm = new SendEmailUtil();
        Account acc = new Account();
        acc.setEmail("19110010@student.hcmute.edu.vn");
        boolean test = sm.sendEmail(acc);
        System.out.println(test);
        System.out.println("Hello");
    }
}
