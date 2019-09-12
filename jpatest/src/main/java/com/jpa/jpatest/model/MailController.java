package com.jpa.jpatest.model;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    SmtpMailSender smtpMailSender;

    @RequestMapping(path = "/api/mail")
    public void sendMail(@RequestBody String body) throws MessagingException, javax.mail.MessagingException {
        smtpMailSender.sendMail("poojithkumar.hegde@microfocus.com", "testmail", body);
    }
    @RequestMapping(path = "/api/suite/info")
    public void getSuitInfo (@RequestBody String url,@RequestBody String pattern )  {
        System.out.println(url+pattern);

    }



}
