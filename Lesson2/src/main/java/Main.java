public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arrayCorrect = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"},
        };

        String[][] arrayInCorrect1 = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"four1", "four2", "four3", "four14", "four14"},  //длинна больше заданной в задаче
        };

        String[][] arrayInCorrect2 = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"four1", "four2", "four3", "four14"},
        };

        System.out.println(mArray(arrayCorrect));
//        System.out.println(mArray(arrayInCorrect1));
        System.out.println(mArray(arrayInCorrect2));
    }

    public static int mArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (array.length != 4){
            throw new MyArraySizeException("Массив не подходит по длинне");
        }
        for(int i = 0; i <array.length; i++){
            if (array[i].length != 4){
                throw new MyArraySizeException("Массив не подходит");
            }
            for (int j = 0; j < array[i].length; j++){

                try {
                    int loc = Integer.parseInt(array[i][j]);
                    count += loc;
                }catch (IllegalArgumentException e){
                    String msg = "Элемент в  " + String.valueOf(i+1) + " строке и " + String.valueOf(j+1) + " ячейке невозможно преобразовать в число!";
                    throw new MyArrayDataException(msg);
                }
            }
        }
        return count;
    }


}
