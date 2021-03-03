package com.codeforc.collection;

import java.lang.ref.WeakReference;

public class WeekReferencesDemo {

    public static void main(String[] args) throws InterruptedException {
        WeakReference<User> userWeakReference = new WeakReference<>(new User("张三"));
        for(int i = 0; i < 10000; i++) {
            Thread.sleep(1 * 5000);
            System.out.println(userWeakReference.get());
        }
    }

    public static class User {

        public User(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
