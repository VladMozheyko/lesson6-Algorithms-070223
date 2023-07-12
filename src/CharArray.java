public class CharArray {          // Класс обертка над массивом
    private char[] arr = new char[5];     // Создаем массив из 5 элементов. Указывать на выделенную память будет переменная arr
    private int cursor = 0;               // Создаем указатель на свободную ячейку массива. В самом начале это 0

    //В Java существуют конструкторы по умолчанию, т.е. можно создать объект без явного указания конструктора в классе

    /**
     * Метод для добавления элемента в массив
     * @param element сам элемент
     */
    public void add(char element){
        if(cursor == arr.length){  // Проверяем не заполнен ли массив, если заполнен, выделяем дополнительную память
            char[] temp = arr;     // Копируем по ссылке элемент
            arr = new char[2*arr.length]; // arr больше не указывает на старый массив, если бы мы не скопировали  ссылку на старый массив, мы бы его потеряли
            increaseMemory(temp);  // Передаю ссылку на старый массив в метод для выделения дополнительной памяти
        }
        arr[cursor] = element;    // Вставляем элемент в массив
        cursor++;                 // Меняем указатель на соседний элемент массива, чтобы записать новый элемент в пустую ячейку
    }

    /**
     * Метод для выделения дополнительной памяти
     * @param temp ссылка на старый массив
     */
    private void increaseMemory(char[] temp) {
        for (int i = 0; i < temp.length; i++) {    // Перебираю старый массив
            arr[i] = temp[i];                      // Записываю элементы старого массива в новый по тем же индексам, чтобы работать с ним без изменений
        }
    }

    /**
     * Метод для удаления элемента массива
     * @param pos позиция удаляемого элемента
     */
    public void delete(int pos){
        if(pos >= cursor){        // Проверяем происходит ли удаление из инициализированной части массива, если нет выводим сообщение и выходим из метода
            System.out.println("Такого элемента нет"); // Вывод сообщения, что такого элемента нет
            return;  // Прерываем метод. Возвращаем управление программой в точку вызова метода
        }
        for (int i = pos; i < cursor; i++){  // Перебираем элементы от позиции удаления до последнего вставленного элемента
            arr[i] = arr[i+1];               // В каждый элемент записываем его соседа справа, таким образом стираем элемент с индексом pos
        }
        cursor--;                            // Декрементируем cursor. Учитываем удаленный элемент
    }

    // Оба метода поиска называются find, но конфликта не возникает, потому, что у них разные параметры - полиморфизм

    /**
     * Метод для поиска элемента по позиции
     * @param pos позиция
     * @return элемент
     */
    public char find(int pos) {
        if(pos >= cursor){   // Проверяем есть ли такой индекс в нашем инициализированном массиве  TODO подумать как можно обойтись без возвращения элемента(Exception)
            System.out.println("Такого элемента нет");  // Выодим сообщение
            return '-';    // Возвращаем минус, чтобы было понятно, что элемента нет
        }
        return arr[pos]; // Возвращаем элемент, в котором указываем pos в качестве индекса
    }

    /**
     * Метод для поиска позиции по элементу
     * @param value  элемент
     * @return позиция
     */
    public int find(char value){
        for (int i = 0; i < cursor; i++) {   // Перебираем все инициализированные элементы массива
            if(arr[i] == value){             // Проверяем совпадает ли элемент с элементом массива
                return i;                    // Если совпал возвращаем позицию этого элемента. Оператор return, кроме возвращения значения, завершит метод
            }
        }
        System.out.println("Такого элемента нет"); // Выводим сообщение, что элемент не найдет, если прошли весь цикл и не нашли совпадение
        return -1; // Возвращаем -1, чтобы было понятно, что такого индекса нет  TODO подумать как можно обойтись без возвращения элемента(Excepti
    }


    /**
     * Метод для вывода массива на консоль
     */
    public void display(){
        System.out.println("Массив: ");
        for (int i = 0; i < cursor; i++) {    // Перебор элементов массива. Перебираем только вставленные элементы до cursor-a
            System.out.print(arr[i] + " ");   // Выводим элемент на консоль и добавляем пробел
        }
        System.out.println();                 // Переходим на новую строку
    }

    /**
     * Метод для удаления массива
     */
    public void clear(){
        cursor = 0;      // Обнуляем переменную для работы с массивом
    }

    /**
     * Метод условно показывающий взлом программы. После его вызова меняется указатель на выделенную память
     */
    public void hack(){
        cursor = arr.length; // Теперь вся память доступна для просмотра
    }

    public void erase(){
        for (int i = 0; i < cursor; i++) {
            arr[i] = '-';
        }
        cursor = 0;
    }

    public char[] getArr() {
        return arr;
    }
}
