import java.util.*;

class PhoneBook {
    private HashMap<String, HashSet<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (book.containsKey(name)) {
            book.get(name).add(phone);
        } else {
            HashSet<String> phones = new HashSet<>();
            phones.add(phone);
            book.put(name, phones);
        }
    }

    public void remove(String name, String phone) {
        if (book.containsKey(name)) {
            book.get(name).remove(phone);
            if (book.get(name).isEmpty()) {
                book.remove(name);
            }
        }
    }

    public void print() {
        List<Map.Entry<String, HashSet<String>>> list = new ArrayList<>(book.entrySet());
        list.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

        for (Map.Entry<String, HashSet<String>> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
