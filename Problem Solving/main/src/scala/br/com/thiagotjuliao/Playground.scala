package br.com.thiagotjuliao

object Playground extends App {
  val time = "12:05:45PM"
  val hourPattern = raw"(\d{2}):\d{2}:\d{2}(\w+)".r

  val militaryTime = time match {
    case hourPattern("12", "AM") => time.replace("12", "00").replace("AM", "")
    case hourPattern(h, "AM") => time.replace("AM", "")
    case hourPattern("12", "PM") => time.replace("PM", "")
    case hourPattern(h, "PM") => time.replace(h, (h.toInt + 12).toString).replace("PM", "")
  }

  println(militaryTime)
}
