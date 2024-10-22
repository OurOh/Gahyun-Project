package com.gahyun.dev.service;

import org.springframework.stereotype.Service;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.Payment;

@Service
public class PaymentService {
   private IamportClient iamportClient;

    public PaymentService() {
        // 아임포트 클라이언트 초기화
        this.iamportClient = new IamportClient("0568173124846817", "02CBy0mr1VegHbFWBOm6yiFGbaaqET3ZV98Hdlg4XBkxqsblhwuE1LQYlyEQlAbcp9njZuUKa3VTeAQK");
    }

    public AccessToken getAccessToken() {
        try {
            return iamportClient.getAuth().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   public Payment getPaymentDetails() {

      return null;
   }
   }