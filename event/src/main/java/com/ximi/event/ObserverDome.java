package com.ximi.event;

import java.util.Observable;
import java.util.Observer;

/**
 * java 观察者用例
 *
 * @author Ximi
 * @see java.util.Observer
 * @see java.util.Observable
 * @since 2020/11/23
 */
public class ObserverDome {

    public static void main(String[] args) {

        MyObservable myObservable = new MyObservable();
        MyObserver myObserver = new MyObserver();
        myObservable.addObserver(myObserver);
        myObservable.notifyObservers("hello world");

    }

    /**
     * 被观察者
     */
    public static class MyObservable extends Observable {

        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
            clearChanged();
        }
    }

    /**
     * 观察者
     */
    public static class MyObserver implements Observer {

        @Override
        public void update(Observable o, Object message) {

            System.out.println("message:" + message);

        }
    }


}
