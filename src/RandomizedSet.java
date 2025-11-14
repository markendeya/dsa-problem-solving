import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {

    HashMap<Integer,Integer> hm;
    List<Integer> ls;
    Random rs;

    public RandomizedSet() {
        hm = new HashMap<>();
        ls = new ArrayList<>();
        rs = new Random();
    }

    public boolean insert(int val) {
        if(hm.containsKey(val))  return false;
        hm.put(val,ls.size());
        ls.add(ls.size(),val);
        return true;
    }

    public boolean remove(int val) {
        if(!hm.containsKey(val))    return false;
        int lastEle = ls.get(ls.size()-1);
        int idx=hm.get(val);
        ls.set(idx,lastEle);
        hm.put(lastEle,idx);
        hm.remove(val);
        ls.remove(ls.size()-1);
        return true;
    }

    public int getRandom() {
        return ls.get(rs.nextInt(ls.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */