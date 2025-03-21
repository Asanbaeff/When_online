fun main() {
    val user = "Елена"
    val time = 60 * 60 * 23
    val text = agoToText(time)
    println("$user был(а) $text")
}

fun agoToText(time: Int): String {
    return when {
        time in 0..60 -> "только что"
        time in 61..<60 * 60 -> timeToTextMinute(time)
        time in 60 * 60..24 * 60 * 60 -> timeToTextHour(time)
        time in 24 * 60 * 60..2 * 24 * 60 * 60 -> "вчера"
        time in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "позавчера"
        time > 3 * 24 * 60 * 60 + 1 -> "давно"
        else -> "ошибка"
    }
}

fun timeToTextMinute(time: Int): String {
    if (time / 60 == 1 || (time / 60) % 10 == 1) return (time / 60).toString() + " минуту назад"
    if (time / 60 == 2 || (time / 60) % 10 == 2
        || time / 60 == 3 || (time / 60) % 10 == 3
        || time / 60 == 4 || (time / 60) % 10 == 4
    ) return (time / 60).toString() + " минуты назад"
    return (time / 60).toString() + " минут назад"
}

fun timeToTextHour(time: Int): String {
    if (time / 3600 == 1 || time / 3600 == 21) return (time / 3600).toString() + " час назад"
    if (time / 3600 in 5..20) return (time / 3600).toString() + " часов назад"
    return (time / 3600).toString() + " часа назад"
}
