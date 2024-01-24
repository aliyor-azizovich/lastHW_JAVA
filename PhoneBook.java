import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String number) {
        Set<String> numbers = phoneBook.getOrDefault(name, new HashSet<>());
        numbers.add(number);
        phoneBook.put(name, numbers);
    }

    public void remove(String name, String number) {
        Set<String> numbers = phoneBook.get(name);
        if (numbers != null) {
            numbers.remove(number);
            if (numbers.isEmpty()) {
                phoneBook.remove(name);
            }
        }
    }

    public Set<String> getNumbers(String name) {
        return phoneBook.getOrDefault(name, Collections.emptySet());
    }

    public void print() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());

        for (Map.Entry<String, Set<String>> entry : entries) {
            String name = entry.getKey();
            Set<String> numbers = entry.getValue();
            System.out.printf("%s: %s%n", name, numbers);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PhoneBook phoneBook = new PhoneBook();

            while (true) {
                System.out.print("Введите имя (или пустую строку для выхода): ");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    break;
                }

                System.out.print("Введите номер телефона: ");
                String number = scanner.nextLine().trim();

                phoneBook.add(name, number);
            }

            System.out.println("\nТелефонная книга:");
            phoneBook.print();
        }
    }
}
//  Введите к примеру следующие данные:
// John
// 8989445
// Bob
// 4545555
// Glory
// 78111154
// Mary
// 789711111
// John
// 123456