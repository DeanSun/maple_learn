package com.spring.struct;

public class SingleIntSet {
    private Object[] _values = new Object[10];

    public void Add(int item){
        _values[item] = item;
    }

    public void Remove(int item){
        _values[item] = null;
    }

    public boolean Contains(int item){
        if(_values[item] == null){
            return false;
        }else{
            return (int)_values[item] == item;
        }
    }

    public static void main(String[] args) {
        SingleIntSet set = new SingleIntSet();
        set.Add(3);
        set.Add(7);
        System.out.println(set.Contains(3));
        System.out.println(set.Contains(5));
    }
}
