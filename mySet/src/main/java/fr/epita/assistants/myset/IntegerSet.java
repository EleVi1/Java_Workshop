package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    ArrayList<Integer> base_;
    public IntegerSet() {
        base_ = new ArrayList<>();
    }

    public void insert(Integer i) {
        if (has(i))
        {
            return;
        }
        base_.add(i);
        Collections.sort(base_);
    }

    public void remove(Integer i) {
        if (!has(i))
        {
            return;
        }
        base_.remove(i);
    }

    public boolean has(Integer i) {
        return base_.contains(i);
    }

    public boolean isEmpty() {
        return base_.isEmpty();
    }

    public Integer min() {
        return Collections.min(base_);
    }

    public Integer max() {
        return Collections.max(base_);
    }

    public int size() {
        return base_.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
        IntegerSet res = new IntegerSet();
        if (a.isEmpty())
        {
            return b;
        }
        if (b.isEmpty())
        {
            return a;
        }
        for (Integer i: a.base_) {
            if (b.has(i)) {
                res.insert(i);
            }
        }
        return res;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        IntegerSet res = new IntegerSet();
        if (a.isEmpty())
        {
            return b;
        }
        if (b.isEmpty())
        {
            return a;
        }
        for (Integer i: a.base_) {
            res.insert(i);
        }

        for (Integer i: b.base_) {
            res.insert(i);
        }
        return res;
    }
}
