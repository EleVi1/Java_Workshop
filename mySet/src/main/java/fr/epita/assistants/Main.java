package fr.epita.assistants;

import fr.epita.assistants.myset.IntegerSet;

public class Main {
    public static void main(String[] args) {
        IntegerSet my_set = new IntegerSet();
        my_set.insert(1);
        my_set.insert(2);
        my_set.insert(3);
        my_set.insert(4);
        my_set.insert(6);
        my_set.insert(5);


        IntegerSet my_set2 = new IntegerSet();
        my_set2.insert(1);
        my_set2.insert(2);
        my_set2.insert(3);
        my_set2.insert(7);
        my_set2.insert(8);
        my_set2.insert(9);


        IntegerSet inter = IntegerSet.intersection(my_set2, my_set);
        IntegerSet union = IntegerSet.union(my_set2, my_set);
    }
}