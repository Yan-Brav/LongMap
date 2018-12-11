package ua.com.ttbrand.longMap;

public class Start {
    public static void main(String[] args) {
        LongMap<String> longMap = new LongMapImpl<>(15);
        longMap.put(14001, "Butterfly Tenergy 05");
        longMap.put(21013, "Donic Acuda S3");
        longMap.put(68018, "Stiga Calibra LT spin");
        System.out.println("Size = " + longMap.size());//3
        System.out.println("Removed value is "+longMap.remove(21013));
        System.out.println("New size =" + longMap.size());//2
        System.out.println("Value by key 14001 = " + longMap.get(14001));
        System.out.println("LongMap contains key 68018 " + longMap.containsKey(68018));
        System.out.println("LongMap contains value Butterfly Tenergy 05 " + longMap.containsValue("Butterfly Tenergy 05"));

        long[] keys = longMap.keys();
        for (long key : keys) {
            System.out.println("Key = " + key);
        }

        Object[] values = longMap.values();
        System.out.println(values.length);
        for (Object value : values) {
            System.out.println("Value = " + value);
        }

        longMap.clear();
        System.out.println("New size =" + longMap.size());

        System.out.println("LongMap is empty = " + longMap.isEmpty());

    }
}
