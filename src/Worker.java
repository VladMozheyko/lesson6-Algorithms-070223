public class Worker {   // Класс для обработки массивов

    /**
     * Метод для сортировки массива пузьком
     * @param arr массив
     */
    public static void bubbleSort(char[] arr){       // TODO Сделать сортировку слиянием и быструю сортировку
        for (int i = 0; i < arr.length; i++) {       // В двух циклах проводим сравнение каждого элемента с каждым элементом
            for (int j = 0; j < arr.length; j++) {
                 if (arr[i] > arr[j]){               // Сравниваем соседние элементы и если arr[i] больше arr[j], меняем их местами
                     char temp = arr[i];             // Запоминаем arr[i]
                     arr[i] = arr[j];                // Записываем в arr[i] arr[j]
                     arr[j] = temp;                  // В arr[i] записываем temp, в который ранее записали arr[i]
                 }
            }
        }
    }
}
