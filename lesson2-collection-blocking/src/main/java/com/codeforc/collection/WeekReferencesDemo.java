package com.codeforc.collection;

import java.lang.ref.WeakReference;

public class WeekReferencesDemo {

    public static void main(String[] args) {

        String value = "111";


        WeakReference<User> weakReference = new WeakReference<>(new User("张三"));
        User user = weakReference.get();

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
