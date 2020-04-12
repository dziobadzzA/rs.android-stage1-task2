package subtask4

class Pangram {

    fun getResult(inputString: String): String
    {
        var result = ""

        val list_a: List<String> = listOf("a", "e", "i", "o", "u", "y")
        val list_b: List<String> = listOf("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z")

        var result_panagrama = true


        var stroki_panagrama_buf = inputString.split(" ")
        var stroki_panagrama_read: MutableList<String> = mutableListOf()

        for (i in 0..stroki_panagrama_buf.size - 1)
        {
            if ((stroki_panagrama_buf[i] != "") and (stroki_panagrama_buf[i] != "\n")) {stroki_panagrama_read.add(stroki_panagrama_buf[i]) }
        }

        var stroki_panagrama = stroki_panagrama_read.toList()

        var stroki_panagrama_index = Array(stroki_panagrama.size, {0})

        result_panagrama = true

        for (i in 0..list_a.size - 1)
        {
            val buf_list = list_a[i].toUpperCase();
            if ((inputString.contains(list_a[i])) or (inputString.contains(buf_list))) {;}
            else
            {
                result_panagrama = false
                break
            }
        }

        if (result_panagrama)
        {
            for (i in 0..list_b.size - 1)
            {
                val buf_list = list_b[i].toUpperCase();

                if ((inputString.contains(list_b[i])) or (inputString.contains(buf_list))) {; }
                else
                {
                    result_panagrama = false
                    break
                }
            }
        }

        if (result_panagrama)
        {
            stroki_panagrama_index = podshet(stroki_panagrama, list_a)
            val output = map_stroki(stroki_panagrama_index, stroki_panagrama.toTypedArray());

            for (x in 0..output.size - 1)
            {
                result+= res_up(output[x], list_a)
                if (x < output.size - 1) { result+=" "}
            }
        }
        else
        {
            stroki_panagrama_index = podshet(stroki_panagrama, list_b)
            val output = map_stroki(stroki_panagrama_index, stroki_panagrama.toTypedArray());

            for (x in 0..output.size - 1)
            {
                result+= res_up(output[x], list_b)
                if (x < output.size - 1) { result+=" "}
            }
        }

        return result
    }

    fun podshet(stroki_panagrama: List<String>, list_map:List<String>):Array<Int>
    {
        var stroki_panagrama_index = Array(stroki_panagrama.size, {0})

        for(i in 0..stroki_panagrama.size-1)
        {
            val buf = stroki_panagrama[i].toCharArray()

            for(j in 0..buf.size-1) {

                for (k in 0..list_map.size - 1) {
                    val len = list_map[k].toUpperCase()
                    if((buf[j].toString() == list_map[k]) or (buf[j].toString() == len)) {stroki_panagrama_index[i]++; break}
                }
            }
        }

        return  stroki_panagrama_index
    }

    fun res_up(stroki_panagrama: String, list_map:List<String>): String
    {
        var result = ""

        val buf = stroki_panagrama.toCharArray()
        var ok = false

        for(j in 0..buf.size-1) {

            ok = false

            for (k in 0..list_map.size - 1)
            {
                if(buf[j].toString() == list_map[k]) {ok = true; break}
            }

            if(ok) {result += buf[j].toString().toUpperCase()}
            else {result += buf[j].toString()}
        }
        return  result
    }

    fun map_stroki (stroki_panagrama_index: Array<Int>, stroki_panagrama: Array<String>): List<String>
    {
        var output: MutableList<String> = mutableListOf()

        var ok = false

        var x = 0

        while (x < stroki_panagrama_index.size - 1)
        {
            ok = false

            for(y in x..stroki_panagrama_index.size - 1)
            {
                if (stroki_panagrama_index[x] > stroki_panagrama_index[y])
                {

                    var str = stroki_panagrama[y]
                    var index = stroki_panagrama_index[y]

                    var buf_massiv = stroki_panagrama.copyOfRange(x,y)
                    var index_massiv = stroki_panagrama_index.copyOfRange(x,y)

                    for(h in 0..buf_massiv.size-1)
                    {
                        stroki_panagrama[x + 1 + h] = buf_massiv[h]
                        stroki_panagrama_index[x + 1 + h] = index_massiv[h]
                    }
                    ok = true

                    stroki_panagrama[x] = str
                    stroki_panagrama_index[x] = index
                    break
                }
            }
            x++
            if (ok) {x-=1}
        }

        for(x in 0..stroki_panagrama_index.size - 1)
        {
            output.add(stroki_panagrama_index[x].toString() + stroki_panagrama[x])
        }

        return output
    }
}
