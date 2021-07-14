package subtask2

class SquareDecomposer {

    private fun Int.square(): Long = (this.toLong() * this.toLong()) // перемножение чисел - возведение в квадрат из Int в Long'ах

    fun decomposeNumber(number: Int): Array<Int>? {
        return getArraySquare(number, number.square()) // передаем число и число в квадрате (тип Long)
    }

    private fun getArraySquare(number: Int, numberInTwo: Long): Array<Int>? {
        for (i in number - 1 downTo 1) { // от (числа - 1) спукаемся до 1
            if (i.square() == numberInTwo) return Array(1) { i } // квадрат числа = искомому, то возращаем массив с этим числом

            val decline = numberInTwo - i.square() // из искомомого отнимаем возведенное число в квадрат
            if (decline > 0) { // если не ушли в минус:
                val array = getArraySquare(i, decline) // рекурсивно вызываем функцию с новым результатом и получаем массив который должен получить массив подходящий под условие квадрат числа = искомому
                if (array != null) return array.plus(i) // при имеющемся массиве прибавляем к нему i (обычное число) которое подходит квадрат числа = искомому
            }
        }
        return null // при отсутствии ответа
    }

}
