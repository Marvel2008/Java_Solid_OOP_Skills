package soluteinter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public abstract class Solution {
    private Sortingtype type;
    public Integer[] array;
    protected int count;
    protected Random rand;
    public abstract void solve();
    public Solution(int count, Sortingtype type){
        array= new Integer[count];
        setCount(count);
        this.type=type;
        rand= new Random();
    }
    public Solution(int count){
        array= new Integer[count];
        setCount(count);
        rand= new Random();
    }
    protected final void rund(){
        for(int i=0; i < array.length; i++)
        {
            array[i] = rand.nextInt(0,15);
        }
    }
    public final void fill() {
        rund();
        if (type!=null){
                    switch (type){
            case Ascending -> Arrays.sort(array);
            case Descending -> Arrays.sort(array, Collections.reverseOrder());
        }
        }
    }
    public void setCount(int count){
        if (count>=1){
            this.count = count;
        }
    }
}
