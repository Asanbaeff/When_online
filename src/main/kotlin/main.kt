fun main() {
    val user = "Елена"
    val time = 60 * 11
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
    val result = time / 60
    if (result % 10 == 1 && result % 100 != 11) return "$result минуту назад"
    if (result % 100 in 11..14) return "$result минут назад"
    if (result % 10 == 2
        || result % 10 == 3
        || result % 10 == 4
    ) return "$result минуты назад"
    return "$result минут назад"
}

fun timeToTextHour(time: Int): String {
    val result = time / 3600
    if (result == 21) return "$result час назад"
    if (result in 5..20) return "$result часов назад"
    return "$result часа назад"
}
