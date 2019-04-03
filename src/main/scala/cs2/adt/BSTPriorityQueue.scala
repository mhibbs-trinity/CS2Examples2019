package cs2.adt

class BSTPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private var bst = new BinarySearchTree[A]
  
  def isEmpty():Boolean = bst.isEmpty
  def add(elem:A):Unit = bst.insert(elem)
  def peek():A = bst.returnLargest
  def get():A = bst.removeLargest
  
}