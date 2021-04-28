package com.spring.struct;

public class SingleIntSet3 {
    private Object[] _values = new Object[10];

    private int H(int value){
        if(value >= 0 && value <= 9){
            return value;
        }else{
            return value - 10;
        }
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
        SingleIntSet3 set = new SingleIntSet3();
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
