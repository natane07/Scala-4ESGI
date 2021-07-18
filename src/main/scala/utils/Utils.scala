package utils

import java.text.SimpleDateFormat
import java.util.Date

object Utils {

  /**
   * Convert date to string yyyy-MM-dd
   * @param date
   * @return String yyyy-MM-dd
   */
  def dateToString(date: Date): String = {
    val DATE_FORMAT = "yyyy-MM-dd"
    val dateFormat = new SimpleDateFormat(DATE_FORMAT)
    dateFormat.format(date)
  }
}
