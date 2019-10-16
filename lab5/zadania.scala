object zadania extends App
{

  //zadanie1

  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean =
  {
    if (seq.size<=1)
      {
        return true
      }
    if (!leq(seq.head,seq(1))) return false
    else
      {
        isOrdered[A](seq.tail)(leq)
      }
  }
  def isOrdered2[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
    def helper(a: Seq[A]): Boolean = {
      (a) match {
        case Seq() => true
        case Seq(_) => true
        case (a1 +: a2 +: an) if leq(a1, a2) == false => false
        case (a1 +: a2 +: an) => helper(a2 +: an)

      }

    }

    helper(seq)
  }

  val a = Seq(2,3,4,5,6,7,8)
  val b = Seq(3,1,2,8,7,6)

  println(isOrdered2[Int](a)((a,b)=> a<b)+" "+ isOrdered2[Int](b)((a,b)=> a<b))




  //zadanie2

  def insertInto[A](a: A, seq: Seq[A])(leq: (A, A) => Boolean): Seq[A] =
  {
    def helper(a: A, seq: Seq[A]): Seq[A]=
    {
      ()
    }
  }

  //zadanie3

  def deStutter[A](seq: Seq[A]): Seq[A] =
  {
    ???
  }

  //zadanie4

  def compress[A](seq: Seq[A]): Seq[(A, Int)] =
  {
    ???
  }

}
