package cs2.algorithms

object MergeSorter {
  
  type SLL[A] = cs2.adt.DoubleLinkedList[A]
  
  def mergeLists[A <% Ordered[A] : Manifest](left:SLL[A], right:SLL[A]):SLL[A] = {
    var ret = new SLL[A]()
    while(left.length != 0 && right.length != 0) {
      if(left.get(0) < right.get(0)) {
        ret.append(left.remove(0))
      } else {
        ret.append(right.remove(0))
      }
    }
    while(left.length != 0) ret.append(left.remove(0))
    while(right.length!= 0) ret.append(right.remove(0))
    ret
  }
  
  def splitList[A : Manifest](lst:SLL[A]):(SLL[A],SLL[A]) = {
    val one = new SLL[A]()
    val two = new SLL[A]()
    var addToOne = true
    while(lst.length != 0) {
      if(addToOne) one.prepend(lst.remove(0))
      else two.prepend(lst.remove(0))
      addToOne = !addToOne
    }
    (one,two)
  }
  
  def mergeSort[A <% Ordered[A] : Manifest](lst:SLL[A]):SLL[A] = {
    val halves = splitList(lst)
    if(halves._2.length == 0) halves._1
    else {
      mergeLists( mergeSort(halves._1), mergeSort(halves._2) )
    }
  }
  
}