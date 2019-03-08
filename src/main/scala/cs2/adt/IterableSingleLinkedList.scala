package cs2.adt

class IterableSingleLinkedList[A] 
       extends SingleLinkedList[A]
       with Iterable[A] {
  
  def iterator():Iterator[A] = {
    new Iterator[A] {
      var curr:Node = myhead
      def next():A = {
        val tmp = curr.data
        curr = curr.next
        tmp
      }
      def hasNext():Boolean = curr != null
    }
  }
  
}


object IterableSingleLinkedListTester {
  def main(args:Array[String]) {
    var lst = new IterableSingleLinkedList[Int]()
    for(i <- 1 to 10) lst.append(i)
    
    for(idx <- 0 until lst.length) {
      println(lst.get(idx))
    }
    
    val it = lst.iterator()
    while(it.hasNext) {
      println(it.next)
    }
    
    
  }
  
}





