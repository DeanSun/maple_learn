package com.spring.struct;

import java.util.LinkedList;

public class SingleIntSet4 {
    private Object[] _values = new Object[10];

    private int H(int value){
        if(value >= 0 && value <= 9){
            return value;
        }else{
            return value - 10;
        }
    }

    private void Add(int item){
        if(_values[H(item)] == null){
            LinkedList<Integer> ls = new LinkedList<>();
            ls.addFirst(item);
            _values[H(item)]  = ls;
        }else{
            LinkedList<Integer> ls = (LinkedList<Integer>) _values[H(item)];
            ls.addFirst(item);
        }
    }

    private void Remove(int item){
        LinkedList<Integer> ls = (LinkedList<Integer>) _values[H(item)];
        ls.remove(item);
    }

    public boolean Contains(int item){
        if(_values[H(item)] == null){
            return false;
        }else{
            LinkedList<Integer> ls = (LinkedList<Integer>) _values[H(item)];
            return ls.contains(item);
        }
    }

    public static void main(String[] args) {
        SingleIntSet4 set = new SingleIntSet4();
        set.Add(3);
        set.Add(17);
        System.out.println(set.Contains(3));  // 输出 true
        System.out.println(set.Contains(17)); // 输出 true
        System.out.println(set.Contains(13)); // 输出 false
        set.Add(13);
        System.out.println(set.Contains(13)); // 输出 true
        System.out.println(set.Contains(3));  // 输出 false. 但是应该输出 true 才对！
    }
}
