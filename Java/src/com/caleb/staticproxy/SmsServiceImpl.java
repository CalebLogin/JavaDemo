package com.caleb.staticproxy;

/**
 * @author：hanzhigang
 * @Date : 2021/1/24 4:01 PM
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
