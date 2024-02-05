package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class GenericSet<T extends Comparable<T>> {
    ArrayList<T> base_;
    public GenericSet() {
        base_ = new ArrayList<>();
    }

    public void insert(T elt) {
        if (has(elt))
        {
            return;
        }
        base_.add(elt);
        Collections.sort(base_);
    }

    public void remove(T elt) {
        if (!has(elt))
        {
            return;
        }
        base_.remove(elt);
    }

    public boolean has(T elt) {
        return base_.contains(elt);
    }

    public boolean isEmpty() {
        return base_.isEmpty();
    }

    public T min() {
        return Collections.min(base_);
    }

    public T max() {
        return Collections.max(base_);
    }

    public int size() {
        return base_.size();
    }

    public static GenericSet intersection(GenericSet a, GenericSet b) {
        GenericSet res = new GenericSet();
        if (a.isEmpty() || b.isEmpty())
        {
            return res;
        }
        for (Object elt: a.base_) {
            if (b.has((Comparable) elt)) {
                res.insert((Comparable) elt);
            }
        }
        return res;
    }

    public static GenericSet union(GenericSet a, GenericSet b) {
        GenericSet res = new GenericSet();
        if (a.isEmpty())
        {
            return b;
        }
        if (b.isEmpty())
        {
            return a;
        }
        for (Object elt: a.base_) {
            res.insert((Comparable) elt);
        }

        for (Object elt: b.base_) {
            res.insert((Comparable) elt);
        }
        return res;
    }
}
