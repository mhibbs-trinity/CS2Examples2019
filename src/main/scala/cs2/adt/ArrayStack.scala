package cs2.adt

class ArrayStack[A : Manifest] extends Stack[A] {
  private var arr:Array[A] = new Array[A] (0)
  
  def isEmpty():Boolean = { arr.length == 0 }
  
  def push(elem:A):Unit = {
    val tmp = new Array[A] (arr.length + 1)
    tmp(0) = elem
    for(i <- 0 until arr.length) {
      tmp(i+1) = arr(i)
    }
    arr = tmp
  }
  
  def peek():A = { arr(0) }
  
  def pop():A = {
    val tmp = new Array[A] (arr.length - 1)
    for(i <- 1 until arr.length) {
      tmp(i-1) = arr(i)
    }
    val ret = arr(0)
    arr = tmp
    ret
  }
  
}