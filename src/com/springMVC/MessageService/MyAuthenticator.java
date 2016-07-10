package com.springMVC.MessageService;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
        private String username = "zouzq7"; 

        private String password = "zll891219"; 

        public MyAuthenticator() { 
            super(); 
        } 

        public MyAuthenticator(String username, String password) { 
            super(); 
            this.username = username; 
            this.password = password; 
        } 

        @Override 
        protected PasswordAuthentication getPasswordAuthentication() { 

            return new PasswordAuthentication(username, password); 
        } 

}
