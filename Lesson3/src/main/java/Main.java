import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {"home", "word", "auto", "aple", "home", "car", "friend", "room", "aple", "stack", "book",
                "foot", "bike", "hello", "hello"
        };
        Set<String> arrayUniq = new HashSet<>(); // Создаем HashSet для добавления уникальных значений
        for (String i: array) { // Добавляем массива слов в HashSet
            arrayUniq.add(i);
        }
        System.out.println(arrayUniq); // Выводим уникальные значение

        for (String key: arrayUniq) {
            System.out.println(key + ": " + Collections.frequency(Arrays.asList(array), key));
        }

//        Iterator<String> iterator = arrayUniq.iterator();
//        while (iterator.hasNext()){
//            String time = iterator.;
//            for (int i = 0; i < array.length; i++){
//                int count = 0;
//                if (time.equals(array[i])){
//                    count++;
//                }
//                System.out.println("Слово " + iterator.toString() + " встречается " + count + " раз");
//            }
//        }
    }
}
