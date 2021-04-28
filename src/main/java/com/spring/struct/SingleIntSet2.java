package com.spring.struct;

public class SingleIntSet2 {
    private Object[] _values = new Object[10];

    private int H(int value){
        return value - 10;
    }

    private void Add(int item){
        _values[H(item)] = item;
    }

    private void Remove(int item){
        _values[H(item)] = null;
    }

    public boolean Contains(int item){
        if(_values[H(item)] == null){
            return false;
        }else{
            return (int)_values[H(item)] == item;
        }
    }


    public static void main(String[] args) {
        SingleIntSet2 set = new SingleIntSet2();
        set.Add(13);
        set.Add(17);
        System.out.println(set.Contains(13));
        System.out.println(set.Contains(15));
    }
}
