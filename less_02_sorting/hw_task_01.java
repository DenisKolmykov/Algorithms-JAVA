package less_02_sorting;

public class hw_task_01 {
    // ПИРАМИДАЛЬНАЯ СОРТИРОВКА (сортировка кучей)

    public static void HeapSort (int [] arr){
        // построение кучи (перегруппировка массива)
        for (int i = arr.length / 2 -1; i >= 0; i--){
            Heapify (arr, arr.length, i);
        }
        
        // по очереди извлекаем элементы из кучи
        for (int j = arr.length -1; j >= 0; j--){
            //  перемещаем текущий корень в конец
            int temp = arr [0];
            arr [0] = arr [j];
            arr [j] = temp;

            // вызываем процедуру heapify на уменьшенной куче
            Heapify (arr, j, 0);
        } 
    }


    public static void Heapify (int [] arr, int heapSize, int rootIndex){
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1;
        int rigthChild = 2 * rootIndex + 2;

        //если левый дочерний жлемент БОЛЬШЕ корня
        if (leftChild <  heapSize && arr[leftChild] > arr [largest]){
            largest = leftChild;
        }

        // если правый дочерний элемент больше чем самый большой элемент на данный момент
        if (rigthChild <  heapSize && arr[rigthChild] > arr [largest]){
            largest = rigthChild;
        }

        // если самый большой элемент НЕ КОРЕНЬ 
        if (largest != rootIndex){
            int temp = arr[rootIndex];
            arr[rootIndex] = arr [largest];
            arr[largest] = temp;

            // рекурсивно преобразуем в двоичную кучу затронутое дерево
            Heapify (arr, heapSize, largest);
        }
    }



    public static void main(String[] args){
        int[] array = new int [] {56, 34, 89, 3, 43, 1, 54, 23, 8, 99, 67, 5, 78};

        HeapSort(array);

        for (int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}