package com.itheima.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的地址
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        //获取指定域名的ip地址
        System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress() + InetAddress.getByName("www.baidu.com").getHostName());
    }
}
