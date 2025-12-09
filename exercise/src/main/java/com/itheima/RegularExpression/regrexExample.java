package com.itheima.RegularExpression;

import java.util.regex.Pattern;

public class regrexExample {
    public static void main(String[] args) {


        String sentence = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus in eros sit amet odio volutpat faucibus ac sit amet mi. Curabitur ac mauris vel libero volutpat suscipit. Integer et orci eget nulla lacinia feugiat ut id leo. Aenean at nisi sed nunc sodales gravida at sed sapien. Ut tincidunt purus nec dui auctor, vel tempor justo gravida. Nulla facilisi. Aliquam erat volutpat. Donec vitae lectus nec velit sollicitudin condimentum sed et sapien. Suspendisse potenti. Sed finibus euismod orci, vel sollicitudin metus tempor ac. In maximus quam sapien, nec tincidunt libero cursus non. Fusce euismod malesuada diam, ac lacinia leo congue eu. Donec fringilla nisi vitae turpis condimentum, non posuere magna tincidunt. Nunc malesuada, ipsum non posuere scelerisque, ante nunc tempus augue, sit amet efficitur nunc libero ut sapien. Mauris vehicula leo nec fringilla tempor.\n";


        sentence =sentence.replaceAll("[^a-zA-Z]","");


        System.out.println(sentence);
    }
}
