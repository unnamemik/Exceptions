package seminar1;

import java.util.*;

public class seminar1 {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String cyan = "\u001B[36m";
    public static Random rand = new Random();


    public static void exception1() {
        int a = 1;
        int b = 0;
        try{
            int num = a/b;
        } catch (ArithmeticException e) {
            System.out.println(red + "ArithmeticException: На ноль делить нельзя!" + reset);
        }
    }

    public static void exception2() {
        int[] arr = new int[1];;
        try{
            int num = arr[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(red + "ArrayIndexOutOfBoundsException: Выход индекса массива за его пределы!" + reset);
        }
    }

    public static void exception3() {
        Integer a = null;
        try{
            int num = a;
        } catch (NullPointerException e) {
            System.out.println(red + "NullPointerException: Пустой указатель!" + reset);
        }
    }


    public static int[] arrCreator(int arrSize, int maxVal) {
        int[] arr= new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = (rand.nextInt( maxVal));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(yellow + "---------------------------------------------" + reset);
        return arr;
    }

    public static int userInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.print(msg);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(red + "Неверный ввод! Введите целое число!" + reset);
            }
        }
        return inputStr;
    }

    public static ArrayList<int[]> arraySizeCompare() {
        int arrSize1 = userInput("\nВведите размер первого массива: ");
        int[] arr1 = new int[arrSize1];
        int arrSize2 = userInput("\nВведите размер второго массива: ");
        int[] arr2 = new int[arrSize2];
        if (arr1.length != arr2.length){
            System.out.println(yellow + "Ошибка! Массивы разной длины! Введите массивы равного размера." + reset);
            arraySizeCompare();
        }
        else{
            ArrayList<int[]> arrResult = new ArrayList<>();
            int arrMaxValue = userInput("\nВведите максимальное значение элементов массивов: \n");
            arrResult.add(arrCreator(arrSize1, arrMaxValue));
            arrResult.add(arrCreator(arrSize1, arrMaxValue));
            return arrResult;
        }
        return null;
    }

    public static void arraySubtracton(ArrayList<int[]> arrayList) {
        int[] arr1 = arrayList.get(0);
        int[] arr2 = arrayList.get(1);
        int[] arrResult = new int[arr1.length];
        System.out.print(cyan + "Разница массивов: " + reset);
        for (int i = 0; i < arr1.length; i++) {
            arrResult[i] = arr1[i] - arr2[i];
        }
        System.out.print(cyan + Arrays.toString(arrResult) + reset);
    }

    public static void arrayDivision(ArrayList<int[]> arrayList) {
        int[] arr1 = arrayList.get(0);
        int[] arr2 = arrayList.get(1);
        int[] arrResult = new int[arr1.length];
        try {
        for (int i = 0; i < arr1.length; i++) {
                arrResult[i] = arr1[i] / arr2[i];}
            } catch (RuntimeException e) {
                System.out.println(red + "В массиве-делителе есть ноль! Попробуйте еще раз." + reset);
                return;
            }
        System.out.println(cyan + "\nЧастное массивов: " + reset);
        System.out.print(cyan + Arrays.toString(arrResult) + reset);
        arrayList.clear();
    }

    public static void main(String[] args) {
        System.out.println(cyan + """
                1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
                                
                2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
                каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, 
                необходимо как-то оповестить пользователя.
                                
                3. * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
                каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, 
                необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь 
                может увидеть - RuntimeException, т.е. ваше.""" + reset);
        int checkExit = 4;
        while (checkExit != 0) {
            checkExit = userInput("\nВведите номер задачи. Для выхода нажмите 0. ");
            switch (checkExit) {
                case 1 -> {
                    exception1();
                    exception2();
                    exception3();
                }
                case 2 -> arraySubtracton(Objects.requireNonNull(arraySizeCompare()));
                case 3 -> arrayDivision(Objects.requireNonNull(arraySizeCompare()));
            }
        }

    }
}