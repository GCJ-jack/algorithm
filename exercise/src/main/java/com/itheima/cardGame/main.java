package com.itheima.cardGame;

import javax.xml.transform.Source;

public class main {

    public static void main(String[] args) {
        colorEnum color = colorEnum.BLUE;

        switch (color){
            case RED -> System.out.println("颜色是红色");
            case BLUE -> System.out.println("颜色是蓝色");
            case GREEN -> System.out.println("颜色是绿色");
        }


    }
}
