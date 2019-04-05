package cs2.adt

class BinarySearchTree[A <% Ordered[A]] {
  private class Node(var data:A, var left:Node, var right:Node) {
    def contains(elem:A):Boolean = {
      if(data == elem) true
      else if(elem < data) {
        if(left == null) false
        else left.contains(elem)
      } else {
        if(right == null) false
        else right.contains(elem)
      }
    }
    
    def insertBelow(elem:A):Unit = {
      if(elem < data) {
        if(left == null) left = new Node(elem,null,null)
        else left.insertBelow(elem)
      } else {
        if(right == null) right = new Node(elem,null,null)
        else right.insertBelow(elem)
      }
    }
    
    private def passUpMaxKid():(A,Node) = {
      if(right == null) (data, left)
      else {
        val (d,n) = right.passUpMaxKid
        right = n
        (d,this)
      }
    }
    
    def removeBelow(elem:A):Node = {
      if(elem == data) { //this node needs to be removed
        if(left == null) right
        else if(right == null) left
        else {
          val (d,n) = left.passUpMaxKid
          data = d
          left = n
          this
        }
      } else {
        if(elem < data) left = left.removeBelow(elem)
        else right = right.removeBelow(elem)
        this
      }
    }
    
    def getMax():A = {
      if(right == null) data
      else right.getMax
    }
   
    
  }
  
  private var root:Node = null
  
  def isEmpty():Boolean = root == null
  
  def contains(elem:A):Boolean = {
    if(root == null) false
    else root.contains(elem)
  }
  
  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem,null,null)
    else root.insertBelow(elem)
  }
  
  def remove(elem:A):Unit = {
    if(root != null) root = root.removeBelow(elem)
  }
  
  def removeLargest():A = {
    val mx = root.getMax
    remove(mx)
    mx
  }
  def returnLargest():A = {
    root.getMax
  }
  
  def printPreOrder():Unit = {
    def processNode(curr:Node) {
      print(curr.data + ", ")
      if(curr.left != null) processNode(curr.left)
      if(curr.right!= null) processNode(curr.right)
    }
    processNode(root)
  }
  
  def printPreOrderStack():Unit = {
    val stk = new LinkedStack[Node]()
    stk.push(root)
    while(!stk.isEmpty) {
      val curr = stk.pop
      if(curr != null) {
        print(curr.data + ", ")
        stk.push(curr.right)
        stk.push(curr.left)
      }
    }
    println
  }
  
  
  
  
}


