package com.zipcodewilmington.phonebook;



import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
       this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
//        addAll(name, phoneNumber);
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        map.put(name, numbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return  ((reverseLookup(name) != null) | map.containsKey(name));
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String name : map.keySet()) {
            if (map.get(name).contains(phoneNumber)) return name;
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(map.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
