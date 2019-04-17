package cs2.util

class TimeLogger {
  private var start = System.nanoTime
  def reset():Unit = { start = System.nanoTime }
  def logTime():Unit = {
    println((System.nanoTime - start)/1e9 + "s has elapsed")
  }
}