package com.resonit.concepts;

import java.util.Objects;

public class EqualAndHashcodeContract {

    static class Visitor{
        int visitor_id;
        String city;

        public Visitor(int visitor_id, String city) {
            this.visitor_id = visitor_id;
            this.city = city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Visitor visitor = (Visitor) o;
            return visitor_id == visitor.visitor_id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(visitor_id);
        }
    }

    public static void main(String[] args) {

        Visitor v1 = new Visitor(1,"mumbai");
        Visitor v2 = new Visitor(1,"mumbai");

        System.out.println("v1.equals(v2) => " + v1.equals(v2));

        System.out.println("v1 hashcode => " + v1.hashCode());
        System.out.println("v2 hashcode => " + v2.hashCode());


    }
}
