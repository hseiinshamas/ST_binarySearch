public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private final Key[] keys;
    private final Value[] values;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int rank(Key key){
        int lo = 0, hi = N-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int comp = key.compareTo(keys[mid]);
            if(comp < 0)        hi = mid - 1;
            else if(comp > 0)   lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key key){
        if(isEmpty())   return null;
        int rank = rank(key);
        if(rank < N && key.compareTo(keys[rank]) == 0)
            return values[rank];
        else
            return null;
    }

    public void put(Key key, Value value){
        int rank = rank(key);
        if(rank < N && key.compareTo(keys[rank]) == 0){ //key already existing, just update value.
            values[rank] = value;
            return;
        }
        for(int i = N; i > rank; i--){
            keys[i] = keys[i-1]; values[i] = values[i-1];
        }

        keys[rank] = key;
        values[rank] = value;
        N++;
    }
}



