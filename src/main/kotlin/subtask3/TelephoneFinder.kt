package subtask3

class TelephoneFinder {

    private fun number(): Map<Int, List<Int>> { // хранилище
        return mapOf(
            0 to listOf(8),
            1 to listOf(2, 4),
            2 to listOf(1, 3, 5),
            3 to listOf(2, 6),
            4 to listOf(1, 5, 7),
            5 to listOf(2, 4, 6, 8),
            6 to listOf(3, 5, 9),
            7 to listOf(4, 8),
            8 to listOf(5, 7, 9, 0),
            9 to listOf(6, 8)
        )
    }

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        val numbersMap = number() // получаем ком
        val result = mutableListOf<String>() // результативный массив ключ-строка
        val numChars = number.toCharArray() // из полученногон номера получаем массив char чисел
        if (number[0] == '-') return null // если у нас отрицательный, то возращаем null
        for (i in numChars.indices) { // проходим по числам не включая размер массива чисел
            val neighbourNumber = numChars.clone() // получаем копию чисел (для соседнего)
            val num = Character.getNumericValue(neighbourNumber[i]) // получаем из копии (приведенные из Char) числа

            val neighbours: List<Int>? = numbersMap[num] // массив соседей (с кол-вом самого числа)
            setNumber(
                i,
                result,
                neighbours,
                neighbourNumber
            ) // начиная от индекса, результативного массива, соседей и соседниму набору (Char)
        }

        return result.toTypedArray() // приводим к обычному массиву (из значений)
    }


    private fun setNumber(position: Int, result: MutableList<String>, neighbours: List<Int>?, number: CharArray) {
        neighbours?.let { // обращаемся напрямую к переменной
            for (j in it.indices) { // проходим до не включительно размера списка
                number[position] = '0' + it[j] // из наших чисел начинаем с позиции , к '0' прибавляем соседние
                result.add(number.joinToString(separator = "")) // добавляем строку из чисел (между ними ничего)
            }
        }
    }

}
