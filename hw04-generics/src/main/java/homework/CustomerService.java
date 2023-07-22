package homework;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {
    private final NavigableMap<Customer, String> customerMap = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Entry<Customer, String> firstItem = customerMap.firstEntry();
        return createCustomerCopy(firstItem);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Entry<Customer, String> entry = customerMap.higherEntry(customer);
        return createCustomerCopy(entry);
    }

    public void add(Customer customer, String data) {
        customerMap.put(customer, data);
    }

    private Map.Entry<Customer, String> createCustomerCopy(Entry<Customer, String> entry) {
        return entry == null
               ? null
               : new AbstractMap.SimpleEntry<>(Customer.copy(entry.getKey()), entry.getValue());
    }
}
