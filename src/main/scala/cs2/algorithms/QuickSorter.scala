package cs2.algorithms

object QuickSorter {
  type DLL[A] = cs2.adt.IterableSingleLinkedList[A]
  
  def quickSort[A <% Ordered[A] : Manifest](lst:DLL[A]):DLL[A] = {
    val pivot:A = lst.get(0)
    val lt = new DLL[A]()
    val gt = new DLL[A]()
    val et = new DLL[A]()
    val iter = lst.iterator()
    while(iter.hasNext) {
      val data = iter.next
      if(data < pivot) lt.prepend(data)
      else if(data > pivot) gt.prepend(data)
      else et.prepend(data)
    }
    val result = new DLL[A]()
    quickSort(lt).iterator().foreach(x => result.append(x))
    et.iterator().foreach(x => result.append(x))
    quickSort(gt).iterator().foreach(x => result.append(x))
    result
  }
  
  
}