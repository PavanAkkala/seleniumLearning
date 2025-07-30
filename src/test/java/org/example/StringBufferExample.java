package org.example;

public class StringBufferExample {
        public static void main(String[] args) {
            StringBuffer sb = new StringBuffer("Hello");

            sb.append(" World");                   // Hello World
            sb.insert(5, ", Java");                // Hello, Java World
            sb.replace(0, 5, "Hi");                // Hi, Java World
            sb.delete(3, 9);                       // Hi World
            sb.reverse();                          // dlroW iH
            System.out.println(sb.length());

            System.out.println(sb.toString());     // dlroW iH
        }
    }

