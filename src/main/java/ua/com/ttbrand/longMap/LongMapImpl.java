package ua.com.ttbrand.longMap;

import java.util.Arrays;



public class LongMapImpl<V> implements LongMap<V>{
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int TREEIFY_THRESHOLD = DEFAULT_INITIAL_CAPACITY * (int)DEFAULT_LOAD_FACTOR;

    private static final long[] TABLE;

    static {
        TABLE = new long[256];
        long h = 0x544B2FBACAAF1684L;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 31; j++) {
                h = (h >>> 7) ^ h;
                h = (h << 11) ^ h;
                h = (h >>> 10) ^ h;
            }
            TABLE[i] = h;
        }
    }
    private int maxValue;
    private int[] table;
    private int[] nextPs;
    private long[] hashValues;
    private V[] elements;
    private int nextHashValuePosition;
    private int hashMask;
    private long size;

    public LongMapImpl(int maxValue) {
        int sizze = 10;
        int expectedTableSize = maxValue;
        if (expectedTableSize < TREEIFY_THRESHOLD) {
            expectedTableSize = expectedTableSize * 4 / 3;
        }
        expectedTableSize = Math.min(expectedTableSize, MAXIMUM_CAPACITY);
        while (sizze < expectedTableSize) {
            sizze <<= 1;
        }
        this.maxValue = maxValue;
        this.table = new int[sizze];
        this.nextPs = new int[maxValue];
        this.hashValues = new long[maxValue];
        this.elements = (V[]) new Object[sizze];
        Arrays.fill(table, -1);
        this.hashMask = sizze - 1;
    }

    private int calcKey(long key){
        int hashCode = (int) key & hashMask;
        int[] table = this.table;
        return table[hashCode];
    }

    @Override
    public V put(long key, V value) {
        int k = calcKey(key);
        if (k != -1) {
            int lastKey;
            do {
                if (hashValues[k] == key) {
                    V old = elements[k];
                    elements[k] = value;
                    return old;
                }
                lastKey = k;
                k = nextPs[k];
            } while (k != -1);
            k = nextHashValuePosition++;
            nextPs[lastKey] = k;
        } else {
            k = nextHashValuePosition++;
            table[(int) key & hashMask] = k;
        }
        if (k >= maxValue) {
            throw new IllegalStateException("HashTable is completed (size =" + size + ", key =" + k);
        }
        hashValues[k] = key;
        nextPs[k] = -1;
        elements[k] = value;
        size++;
        return null;
    }

    @Override
    public V get(long key) {
        V result = null;
        int k = calcKey(key);
        if (k != -1) {
            do {
                if (hashValues[k] == key) {
                    result = elements[k];
                    return result;
                }
                k = nextPs[k];
            } while (k != -1);
        }
        return result;
    }

@Override
    public V remove(long key) {
        int k = calcKey(key);
        if (k != -1) {
            do {
                if (hashValues[k] == key) {
                    elements[k] = null;
                    size--;
                }
                k = nextPs[k];
            } while (k != -1);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() > 0)
            return false;
        return true;
    }

    @Override
    public boolean containsKey(long key) {
        for (long k : hashValues) {
            if (k == key)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (V val : this.elements) {
            if (value.equals(val)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long[] keys() {
        return hashValues;
    }

    @Override
    public V[] values() {
        return elements;
    }


    @Override
    public long size() {
        return size;
    }

    @Override
    public void clear() {
        this.elements = null;
        this.hashValues = null;
        size = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LongMapImpl other = (LongMapImpl) obj;
        if (!Arrays.equals(hashValues, other.hashValues))
            return false;
        return true;
    }


}
