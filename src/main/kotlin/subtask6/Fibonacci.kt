package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {

        var result: IntArray = intArrayOf(0,0,0)
        var fibon: MutableList<Int> = mutableListOf(0, 1)
        var fibon_index = 0

        var ok = true

        while (ok)
        {
            if ((fibon[fibon_index] * fibon[fibon_index + 1]) < n)
            {
                fibon.add(fibon[fibon_index] + fibon[fibon_index+1])
                fibon_index++
            }
            else {ok = false}
        }

        result[0] = fibon[fibon_index]
        result[1] = fibon[fibon_index+1]

        if(result[0] * result[1] == n) { result[2] = 1 }

        return result
    }
}
