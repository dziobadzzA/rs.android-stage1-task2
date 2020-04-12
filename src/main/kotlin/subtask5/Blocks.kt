package subtask5

import kotlin.reflect.KClass
import java.time.LocalDate

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any
    {
        var type_name = blockB.toString()
        //var type_name = blockB.simpleName

        if (type_name.contains("String"))
        {
                var result_buf = ""
                for (i in 0..blockA.size - 1)
                {
                    if(blockA[i] is String) {result_buf+=blockA[i]}
                }

                return  result_buf
        }
        if (type_name.contains( "int"))
            {
                var result_int = 0
                for (i in 0..blockA.size - 1)
                {
                    if(blockA[i] is Int)
                    {
                        result_int += blockA[i].toString().toInt()
                    }
                }
                return  result_int
            }
        if (type_name.contains( "LocalDate" ))
            {

                for (i in 0..blockA.size - 1)
                {
                    if(blockA[i] is LocalDate)
                    {
                        val time = blockA[i].toString().split("-").toTypedArray()
                        return time[2] + "." + time[1] + "." + time[0]
                    }
                }
            }

        return 0
    }
}

