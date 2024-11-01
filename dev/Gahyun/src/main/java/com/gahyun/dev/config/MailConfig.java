package com.gahyun.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

	 @Bean
	    public JavaMailSender javaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        
	        // 네이버 SMTP 서버 설정 !! 자신의 이메일 입력.
	        mailSender.setHost("smtp.naver.com");
	        mailSender.setPort(465); // 네이버 설정에 따른 포트 번호
	        mailSender.setUsername("dhtmddks98@naver.com"); // 실제 네이버 이메일 주소
	        mailSender.setPassword("asd123595321"); // 네이버 비밀번호

	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.ssl.trust", "smtp.naver.com"); // SSL 신뢰 설정
	        props.put("mail.debug", "true"); // 디버그 정보 활성화

	        return mailSender;
	    }
	}
