package subtask1

import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String
    {
        var  result = "Такого дня не существует"

        var text_day = ""
        var text_month = ""

        if ((day.toInt() > 0) && (day.toInt() < 10)) {text_day = "0$day"} else { text_day = day}
        if ((month.toInt() > 0) && (month.toInt() < 10)) {text_month = "0$month"} else {text_month = month}

        var date: LocalDate

        try
        {
            date = LocalDate.parse("$year-$text_month-$text_day")
            // day operation
            var day_buf = 0
            var month_buf = ""

            when(month.toInt())
            {
                // обработка 31
                1,3,5,7,8,10,12 -> { day_buf = 32 }
                // обработка 30
                4,6,9,11 ->  { day_buf = 31 }
                // обработка 28,29
                2 -> { if (date.isLeapYear){ day_buf = 30 } else { day_buf = 29} }
                else -> {result = "Такого дня не существует" }
            }

            if(day_buf > 0)
            {
                if ((day.toInt() > 0) && (day.toInt() < day_buf))
                {
                    // вывод результата в result
                    when(month.toInt())
                    {
                        1 -> { month_buf = "января" }
                        2 -> { month_buf = "февраля" }
                        3 -> { month_buf = "марта" }
                        4 -> { month_buf = "апреля" }
                        5 -> { month_buf = "мая" }
                        6 -> { month_buf = "июня" }
                        7 -> { month_buf = "июля" }
                        8 -> { month_buf = "августа" }
                        9 -> { month_buf = "сентября" }
                        10 -> { month_buf = "октября" }
                        11 -> { month_buf = "ноября" }
                        12 -> { month_buf = "декабря" }
                        else -> {result = "Такого дня не существует" }
                    }

                    when(date.dayOfWeek.toString())
                    {
                        "MONDAY" -> { result = "${day.toInt()} $month_buf, понедельник" }
                        "TUESDAY" -> { result = "${day.toInt()} $month_buf, вторник" }
                        "WEDNESDAY" -> { result = "${day.toInt()} $month_buf, среда" }
                        "THURSDAY" -> { result = "${day.toInt()} $month_buf, четверг" }
                        "FRIDAY" -> { result = "${day.toInt()} $month_buf, пятница" }
                        "SATURDAY" -> { result = "${day.toInt()} $month_buf, суббота" }
                        "SUNDAY" -> { result = "${day.toInt()} $month_buf, воскресенье" }
                        else -> {result = "Такого дня не существует" }
                    }
                }
            }
        }
        catch (e:Exception)
        {
            result = "Такого дня не существует"
        }

        return result
    }
}
