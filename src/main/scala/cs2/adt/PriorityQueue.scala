package cs2.adt

trait PriorityQueue[A] {
  def add(elem:A):Unit
  def get():A
  def peek():A
  def isEmpty():Boolean
}