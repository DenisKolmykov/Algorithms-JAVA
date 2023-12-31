public class hw_task_01 {
    /* Дано целое число N из отрезка [1; 1000]. 
    Также даны N целых чисел Ai из отрезка [1; 1000000]. 
    Требуется для каждого числа Ai вывести количество различных делителей этого числа. 
    В этой задаче несколько верных решений, попробуйте найти наиболее оптимальное. 
    Для полученного решения укажите сложность в О-нотации.
    */

    public static void DividerCounter (int a){ // сложность O(sqrt(n))
        int dCount = 0;
        int i; // объявляем перед циклом, чтобы оставить последнее значение i (при выходе из цикла)
        for (i = 2; i * i <= a; i++){ // не учитываем в делителях '1' и само число
            if (a % i == 0){
                //System.out.print(i + " " + a/i + " ");
                dCount ++ ;
            }
        }
        dCount = dCount * 2; // т.к цикл до sqrt(a), поэтому делителей в 2 раза больше
        
        i --; // т.к. значение i при выходе больше на 1 (чем sqrt(a))
        if ( i * i == a){ // если есть целый sqrt(a), то убираем дублирующий делитель
            dCount = dCount - 1; 
        }

        if (dCount != 0){
            System.out.printf("число: %d | кол-во делителей: %d\n", a, dCount);
        }
        else {
            System.out.printf("число: %d  - простое число\n", a, dCount);
        }
    }

    public static void main(String[] args){
        int n1 = 1000;
        int n = (int)(Math.random() * n1 + 1);
        //System.out.println(n);

        /*  можно и без формирования массива чисел
            и просто в цикле генерить (или запрашивать) очередное число 'a'
            и сразу в этом же цикле вызывать DividerCounter(a)
            конструкция ниже - что бы можно было "подсунуть" любой список чисел
        */
        int [] a = new int [n];
        int a1 = 1000000;
        for (int i = 0; i < n; i++){
            a[i] = (int)(Math.random() * a1 + 1);
        }

        // int [] a = new int[] {4, 8, 9, 10, 17, 25, 49, 63, 69, 81, 99, 100}
        for (int i = 0; i < a.length; i++){ // общая сложность O(n sqrt(n))
            DividerCounter (a[i]);
        }
    }
}
