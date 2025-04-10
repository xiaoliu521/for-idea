package org.example.dataStructure;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<String> sites = new LinkedList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.add(null);
//        sites.add(11, "Xianren");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("110");
        sites.addAll(strings);
        sites.addFirst("First");
        sites.addLast("Last");

        System.out.println(sites);
        boolean offer = sites.offer("offer");
        boolean offerFirst = sites.offerFirst("offerFirst");
        boolean offerLast = sites.offerLast("offerLast");
        System.out.println(sites);
        sites.clear();
    }
}
