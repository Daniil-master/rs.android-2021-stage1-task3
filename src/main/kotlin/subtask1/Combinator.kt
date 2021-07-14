package subtask1

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        fun factorial(n: Int): Int { // обычная реализация факториала
            var result = 1 // для формирования результата
            for (i in 1..n) {
                result *= i
            } // перемножаем до n числа
            return result // возращаем
        }

        // при том если: первое число и второе меньше 0 (для 2го ещё и равен) или у списка не 2 числа или пустой список
        if (array[0] < 0 || array[1] <= 0 || array.size < 2 || array.isEmpty())
            return null

        val k = array[0]
        val n = array[1]

        // находим число удовлетворяющее логике
        for (i in 0..n) { // проходим до второго числа
            // при том если:
            // n! равно ли: k * (n - i)! * i!
            if (factorial(n) == k * factorial(n - i) * factorial(i))
                return i // возращаем полученное число (удовлетворяет условию)
        }
        return null // при не одном условии возращаем null
    }
}
