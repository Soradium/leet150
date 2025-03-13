package org.lcsol;

import java.util.*;

class RandomizedSet {
    Map<Integer,Integer> s;
    List<Integer> l;
    Random random;

    public RandomizedSet() {
        s = new LinkedHashMap<>();
        l = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean a = s.put(val,val)==null;
        if(a) {
            l.add(val);
        }
        return a;
    }

    public boolean remove(int val) {
        boolean a = s.remove(val) != null;
        if(a) {
            l.remove((Integer) val);
        }
        return a;
    }

    public int getRandom() {
        random = new Random();
        return l.get(random.nextInt(l.size()) + 1);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 *
 * At most 2 * 105 calls will be made
 * to insert, remove, and getRandom.
 *
 * There will be at least one element in the data structure
 * when getRandom is called.
 */