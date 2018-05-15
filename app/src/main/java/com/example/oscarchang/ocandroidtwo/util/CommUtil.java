package com.example.oscarchang.ocandroidtwo.util;

import android.util.SparseArray;

import com.example.oscarchang.ocandroidtwo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDT13976 on 2018/5/14.
 */
public class CommUtil {

    public static List<Book> generateBooks() {
        ArrayList<Book> ret = new ArrayList<Book>();
        Book temp;
        temp = new Book();
        temp.setName("Book1");
        temp.setPrice(20);
        ret.add(temp);
        temp.setName("Book2");
        temp.setPrice(40);
        ret.add(temp);

        return ret;
    }
}
