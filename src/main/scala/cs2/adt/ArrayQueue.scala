package cs2.adt

class ArrayQueue[A : Manifest] extends Queue[A] {
  var arr = new Array[A] (10)
  var len = 0
  var beg = 0
  
  def peek():A = arr(beg)
  def isEmpty():Boolean = len == 0
  
  def enqueue(elem:A):Unit = {
    if(len == arr.length) {
      val tmp = new Array[A] (arr.length * 2)
      for(i <- 0 until len) tmp(i) = arr((beg + i) % arr.length)
      beg = 0
      arr = tmp
    }
    arr((beg + len) % arr.length) = elem
    len += 1
  }
  def dequeue():A = {
    val tmp = arr(beg)
    beg = (beg + 1) % arr.length
    len -= 1
    tmp
  }
  
  
}