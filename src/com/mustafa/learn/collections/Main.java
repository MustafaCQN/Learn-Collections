package com.mustafa.learn.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        SetTypes set = new SetTypes();
        //set.HashSet();
        //set.LinkedHashSet();
        //set.TreeSet();

        ListTypes list = new ListTypes();
        list.ArrayList();
    }

}

class SetTypes {
    public void HashSet() {
        // HashSet, LinkedHashSet, TreeSet

        // HashSetlerde Birden Fazla aynı eleman olamaz. örnekte birden fazla 12 integer sayısını ekliyoruz ancak sadece 1 tane ekleniyor

        HashSet<Object> h = new HashSet<>();
        h.add("naber");
        h.add(12);
        h.add(12);
        h.add(12);
        h.add(12.00);
        h.add(true);
        h.add(null);

        h.remove(12.0);

        Iterator itr = h.iterator();
        while (itr.hasNext()) {
            System.out.println("1 h: " + itr.next());
        }
        System.out.println("2 hashCode: " + itr.hashCode());
        System.out.println("3 size: " + h.size());

        System.out.println("4 h.forEach");
        h.forEach(item -> System.out.print(item + " "));
    }
    public void LinkedHashSet() {
        // HashSet, LinkedHashSet, TreeSet

        // HashSetten extend olmuştur, farklı yanı, HashSette objeler random olabilirken LinkedHashSette tam olarak verdiğimiz sırayla dururlar

        LinkedHashSet<Object> days = new LinkedHashSet<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        days.add(12);
        days.add(true);

        days.add("Monday");
        days.add(null);

        days.remove("Sunday");

        System.out.println("Days LinkedHashSet Listesi");
        days.forEach(item -> System.out.print(item + " "));
    }
    public void TreeSet() {
        // HashSet, LinkedHashSet, TreeSet

        // Tüm Setler gibi duplicate tutmaz.
        // null kabul edilmez, sadece tek bir tür tutabilir. Object bile desek ilk eklenen türü kabul eder.
        // eğer farklı bir tür eklemeden önce onu silersek, hata almayız. Yani kendi tipini değiştirir.
        // verilen tip içerisinde ekleme sırasından bağımsız şekilde dataları küçükten büyüğe default sıralar.

        TreeSet<Object> tree = new TreeSet<>();

        tree.add("true");
        tree.remove("true");
        tree.add(10);
        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(6);
        tree.add(6);

        try {
            tree.add("hata verecek, çünkü int alıyor");
        }catch (Exception e){
            System.out.println("Hata verdi :) Message: " + e.getMessage());
        }

        System.out.println("\ntree");
        tree.forEach(item -> System.out.print(item + " "));

        TreeSet<Object> treeString = new TreeSet<>();
        treeString.add("naber1");
        treeString.add("naber2");
        treeString.add("ahmet");
        treeString.add("deneme");
        treeString.add("a");

        System.out.println("\n\ntreeString");
        treeString.forEach(item -> System.out.print(item + " "));

        treeString.add("babanneSırayaGirer");
        System.out.println("\n\ntreeString");
        treeString.forEach(item -> System.out.print(item + " "));

    }
}

class ListTypes {
    public void ArrayList() {

        // FIFO, duplicate kabul ediyor
        // Araya ekleme var, eğer eklersen sonrakiler öteleniyor.

        ArrayList<String> country = new ArrayList<>();
        country.add("Ankara");
        country.add("Siirt");
        country.add("Bolu");
        country.add("Istanbul");
        country.add("Ankara");

        country.add(0, "Batman");

        country.remove(2);

        country.forEach(i -> System.out.print(i + " "));
    }
    public void LinkedList() {

    }
    public void Vector() {

    }
}
