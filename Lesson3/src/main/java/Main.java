import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {"home", "word", "auto", "aple", "home", "car", "friend", "room", "aple", "stack", "book",
                "foot", "bike", "hello", "hello"
        };
        arrayUniq(array);

        PhonDict dict = new PhonDict();
        dict.add("Ivanov", "8-999-199-25-99");
        dict.add("Ivanov", "8-999-199-25-98");
        dict.add("Lopuchov", "8-999-199-00-00");
        dict.add("Frolov", "8-999-199-01-00");
        dict.add("Frolov", "8-999-199-02-00");
        System.out.println(dict.get("Ivanov"));
        System.out.println(dict.get("Lopuchov"));
        System.out.println(dict.get("Frolov"));


    }

    public static void arrayUniq(String[] array){
        Set<String> arrayUniq = new HashSet<>(); // Создаем HashSet для добавления уникальных значений
        for (String i: array) { // Добавляем массива слов в HashSet
            arrayUniq.add(i);
        }
        System.out.println(arrayUniq); // Выводим уникальные значение

        Map<String, Integer> countWords = new HashMap<>(); // Подсчитываем количество слов
        for (String words : arrayUniq){
            int count = 0;
            for (int i = 0; i < array.length; i++){
                if(words.equals(array[i])){
                    count++;
                }
            }
            countWords.put(words, count);
        }
        System.out.println(countWords);

    }

     static class PhonDict{
        final Map<String, List<String>> book = new HashMap<>();

        public void add(String family, String number){
            if (book.containsKey(family)){
                book.get(family).add(number);
            }else {
                List<String> newNumber = new ArrayList<>();
                newNumber.add(number);
                book.put(family, newNumber);
            }
        }

        public List<String> get(String family){
            return book.get(family);
        }

    }
}
