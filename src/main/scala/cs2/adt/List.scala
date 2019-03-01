package cs2.adt

trait List[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A)
  def insert(idx:Int, elem:A)
  def remove(idx:Int):A
  
  def isEmpty():Boolean
  def length():Int
  
  def prepend(elem:A) = insert(0,elem)
  def append(elem:A) = insert(length,elem)
  def apply(idx:Int):A = get(idx)
  def update(idx:Int, elem:A) = set(idx,elem)
}