package com.jeanboy.app.kotlin.training.part4;

/**
 * Created by jianbo on 2022/1/6 15:37.
 */
public class Test2 {
    /**
     * 【1】接口
     */
    interface Clickable {
        void click();

        default void showOff() {
            System.out.println("I'm clickable!");
        }
    }

    class Button implements Clickable {

        @Override
        public void click() {
            System.out.println("I was clicked");
        }
    }
}
