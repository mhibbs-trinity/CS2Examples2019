package cs2.adt

class ArrayHeapPriorityQueue[A <% Ordered[A] : Manifest] extends PriorityQueue[A] {
  
  private var heap:Array[A] = new Array[A] (10)
  private var len:Int = 0
  
  def peek():A = heap(1)
  def isEmpty():Boolean = len == 0
  def add(elem:A):Unit = {
    len += 1
    if(len >= heap.length) {
      val tmp = new Array[A] (heap.length * 2)
      for(i <- 0 until len) tmp(i) = heap(i)
      heap = tmp
    }
    heap(len) = elem
    var loc = len
    while(loc > 1 && heap(loc/2) < heap(loc)) {
      heap(loc) = heap(loc/2)
      heap(loc/2) = elem
      loc = loc / 2
    } 
  }
  def get():A = {
    val ret = heap(1)
    var loc = 1
    heap(1) = heap(len)
    len -= 1
    
    var finished = false
    while(loc*2 <= len && !finished) {
      var bigKid = if(loc*2+1 > len || heap(loc*2) > heap(loc*2+1)) 
                      loc*2 else loc*2+1
      if(heap(bigKid) > heap(loc)) {
        val tmp = heap(loc)
        heap(loc) = heap(bigKid)
        heap(bigKid) = tmp
        loc = bigKid
      } else {
        finished = true
      }
    }
    
    ret
  }
  
  
  
  
  
  
  
  
  
  
}