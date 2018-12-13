package ua.com.ttbrand.longMap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LongMapImplTest extends Assert {
    public LongMap<String> longMap = new LongMapImpl<>(15);


    @Test
    public void testSize(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        assertTrue(longMap.size() == 3);
        longMap.clear();
    }

    @Test
    public void testGet(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        assertTrue(longMap.get(14001).equals("Butterfly Tenergy 05"));
        longMap.clear();
    }


    @Test
    public void testPut(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        longMap.put(108001, "SpinLord Marder 2");
        assertTrue(longMap.size() == 4);
        longMap.clear();
    }

    @Test
    public void testRemove(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        longMap.remove(68018);
        assertTrue(longMap.get(68018) == null);
        longMap.clear();
    }

    @Test
    public void testContainsKey(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        assertTrue(longMap.containsKey(68018));
        longMap.clear();
    }
    @Test
    public void testContainsValue(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        assertTrue(longMap.containsValue("Butterfly Tenergy 05"));
        longMap.clear();
    }
    @Test
    public void testKeys(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        long[] keys = longMap.keys();
        int count = 0;
        for (long key : keys) {
            if (key != 0){
                count++;
            }
        }
        assertTrue(count == longMap.size());
        longMap.clear();
    }
    @Test
    public void testValues(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        Object[] values = longMap.values();
        int count = 0;
        for (Object value : values) {
            if (value != null){
                count++;
            }
        }
        assertTrue(count == longMap.size());
        longMap.clear();
    }
    @Test
    public void testClear(){
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        longMap.clear();
        assertTrue(longMap.isEmpty());
    }
}
