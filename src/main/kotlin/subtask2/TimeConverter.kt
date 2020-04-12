package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String
    {
        var result = ""

        val time_map: Map<Int, String> = mapOf( 1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five",
            6 to "six", 7 to "seven", 8 to "eight", 9 to "nine", 10 to "ten", 11 to "eleven", 12 to "twelve", 13 to "thirteen",
            14 to "fourteen", 16 to "sixteen", 17 to "seventeen", 18 to "eighteen", 19 to "nineteen")

        val hour_map: Map<Int, String> = mapOf( 1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five",
            6 to "six", 7 to "seven", 8 to "eight", 9 to "nine", 10 to "ten", 11 to "eleven", 12 to "twelve")

        val map_des: Map<Int, String> = mapOf(2 to "twenty", 3 to "thirty", 4 to "forty", 5 to "fifty")

        val map_ed: Map<Int, String> = mapOf( 1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five",
            6 to "six", 7 to "seven", 8 to "eight", 9 to "nine")

        var ok_minute = true
        var ok_quarter = true

        // 1-19
        if (time_map.containsKey(minute.toInt())) { ok_minute = false; result += (time_map[minute.toInt()]) }

        var hour_elem = hour.toInt()

        //15
        if (minute.toInt() == 15) { ok_minute = false; ok_quarter = false; result += "quarter" }
        if ( minute.toInt() == 45) { ok_minute = false; hour_elem++; ok_quarter = false; result += "quarter" }
        //30
        if (minute.toInt() == 30) { ok_minute = false; ok_quarter = false; result += "half" }

        if (ok_minute) {

            var min = minute.toInt()

            if (minute.toInt() > 30) { min = 60 - minute.toInt(); hour_elem++}

            if (map_des.containsKey(min / 10)) {
                result += map_des[min / 10] + " "
            }
            if (map_ed.containsKey(min % 10)) {
                result += map_ed[min % 10]
            }
        }

        if (minute.toInt() == 0)
        {
            result+= hour_map[hour.toInt()].toString() + " o' clock"
        }
        else
        {
            if(minute.toInt() < 60)
            {
                if (ok_quarter)
                {
                    if (minute.toInt() > 1) {
                        result += " minutes"
                    } else {
                        result += " minute"
                    }
                }
                if (minute.toInt() > 30) {
                    result += " to "
                } else {
                    result += " past "
                }
                result += hour_map[hour_elem].toString()
            }
        }

        return result
    }
}
