package com.mustafa.learn.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        SetTypes set = new SetTypes();
//        set.HashSet();
//        set.LinkedHashSet();
//        set.TreeSet();

        ListTypes list = new ListTypes();
//        list.ArrayList();
//        list.LinkedList();
//        list.Vector();

        Queue queue = new Queue();
//        queue.LinkedList();
//        queue.PriorityQueue();

        Map map = new Map();
        map.HashMap();

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

        // duplicate destekliyor, istenilen indexe ekleme yapılabilinir
        // ArrayList ile birebir aynı, Algoritmaları farklı sadece.
        // Arama Fonksiyonlarında -> LinkedList => O(n) iken, ArrayListler => O(1) dir.
        // Silme ve Ekleme Fonksiyonlarında -> LinkedList => O(1) iken, ArrayListler => O(n) dir.

        LinkedList list = new LinkedList();

        list.add("Armut");
        list.add("Çilek");
        list.add("Kavun");

        list.add(1, "Karpuz");

        list.forEach(i -> System.out.print(i + " "));

    }
    public void Vector() {

        // Senkronize bir Collection yapısı. Arama,Silme vs fonksiyonları eski
        // default olarak kapasitesi'ı 10 dur. ve 11. eleman eklendiği an kendi kapasitesini 10 daha arttırır. (v.capacity())

        Vector v = new Vector();

        v.add("Armut");
        v.add("Kiraz");
        v.add("Çilek");
        v.add("Kavun");
        v.add("Karpuz");
        v.add("Muz");
        v.add("Elma");
        v.add("Elma");
        v.add("Elma");

        System.out.println("size 9 iken Size ve Capacity çağırımı");
        System.out.println(v.size());
        System.out.println(v.capacity());

        v.add("Elma");
        v.add("Elma");

        System.out.println("size 11 iken Size ve Capacity çağırımı");
        System.out.println(v.size());
        System.out.println(v.capacity());

        Vector vector = new Vector(4, 5);

        vector.add("Armut");
        vector.add("Kiraz");
        vector.add("Çilek");
        vector.add("Kavun");
        vector.add("Elma");

        System.out.println("Capacity si 4 ve capacityIncrementi 5 olan bir Vectöre 5 eleman eklemek");
        System.out.println(vector.size());
        System.out.println(vector.capacity());

        System.out.println("FirstElement: " + vector.firstElement());
    }
}

class Queue {
    // FIFO
    // Özel methodları vardır
    // element() queue'un başındaki elemanı verir ancak onu queue den atmaz
    // offer(<T> o) mümkünse verilen objeyi kuyruğa ekler
    // peek() element() ile aynı şeyi yapar, queue boş ise null verir
    // poll() kuyruğun başındaki elemanı verip onu kuyruktan atar, boşsa null verir
    // remove() kuyruğun başındaki elemanı verir ve onu kuyruktan atar.

    public void LinkedList () {
        java.util.Queue q = new LinkedList();
        q.add("Deniz");
        q.add("Mehmet");

        // add den farklı, eğer ekleyemiyorsa bize bir exception fırlatmıyor.
        q.offer("Ali");
        q.offer("Damla");

        System.out.println("remove() " + q.remove());
        System.out.println("element() " + q.element());
        // peekin elementten farkı, eğer boş ise exception vermez, null verir.
        System.out.println("peek() " + q.peek());

        System.out.println("Queue");
        q.forEach(i -> System.out.print(i + " "));
    }

    public void PriorityQueue() {
        // tek farkı queue içinde sıralama yapması. priority tanımlarımıza göre objeler sıralanıyor.
        // comparator ile custom kurallar oluşturabiliriz.
        java.util.PriorityQueue q = new PriorityQueue();

        q.add(10);
        q.add(80);
        q.add(20);
        q.add(50);

        // iterable yok, bu yüzden while ile loop var
        while (!q.isEmpty()) {
            // default olarak intlerde küçükten büyüğe sıralanıyor.
            System.out.print(q.poll() + " ");
        }
    }
}

class Map {
    // clear() Map içinde bulunan bütün değerleri siler
    // get(<T> key) Anahtara karşılık gelen objeyi döndürür
    // put(<T> key, <E> value) Anahtar-değer ikilisini kaydeder.
    // key değerleri unique, value değerleri değildir.

    public void HashMap() {

        // key değerlerine göre default bir sıralama vardır. Yine comparator ile bunlar değiştirilebilinir.
        // aynı key değerleri atanırsa exception verilmez, üstüne yazılır

        HashMap b = new HashMap();

        b.put("Türkiye", "Istanbul");
        b.put("Türkiye", "Ankara");
        b.put("Fransa", "Paris");
        b.put("İngiltere", "Londra");

        System.out.println("Türkiye: " + b.get("Türkiye"));

        Set s = b.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            java.util.Map.Entry item = (java.util.Map.Entry) i.next();
            System.out.println(item.getKey() + " => " + item.getValue());
        }
    }

    public void LinkedHashMap() {

    }

    public void TreeMap() {
        // sorted ve navigetable map.
    }
}
