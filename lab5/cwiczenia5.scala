object cwiczenia5 extends App{

  //zadanie1

  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean =
  {
    def helper (a: Seq[A]): Boolean ={
    a match {
      case Seq() => true
      case Seq(_) => true
      case (a1 +: a2 +: an) if leq(a1, a2) == false => false
      case (a1 +: a2 +: an) => helper(a2 +: an)
    }

    }
    helper (seq)
  }
  val a = Seq(2,3,4,5,6,7,8)
  val b = Seq(3,1,2,8,7,6)

  println(isOrdered[Int](a)((a,b)=> a<b)+" "+ isOrdered[Int](b)((a,b)=> a<b))


  //Zadanie2

  def insertInto[A](a: A, seq: Seq[A])(leq: (A, A) => Boolean): Seq[A] = {
    def insertIntoAux(a: A, seq: Seq[A])(leq: (A, A) => Boolean)(head: Seq[A] = Seq()): Seq[A] = seq match {
      case e +: s if leq(a, e) => (head :+ a :+ e) ++ s
      case e +: s => insertIntoAux(a, s)(leq)(head :+ e)
      case Seq(e) if leq(a, e) => head :+ a :+ e
      case Seq(e) => head :+ e :+ a
    }
    insertIntoAux(a, seq)(leq)()
  }

  //Zadanie3

  def deStutter[A](seq: Seq[A]): Seq[A] = {
    def deStutterAux(seq: Seq[A], des: Seq[A] = Seq()): Seq[A] = seq match {
      case Seq(x, y) if x != y => des :+ x :+ y
      case Seq(_, y) => des :+ y
      case x +: y +: s if x != y => deStutterAux(y +: s, des :+ x)
      case _ +: y +: s => deStutterAux(y +: s, des)
    }
    deStutterAux(seq)
  }

  //Zdanie4

  def compress[A](seq: Seq[A]): Seq[(A, Int)] = {
    def compressAux(seq: Seq[A], com: Seq[(A, Int)] = Seq(), count: Int = 1): Seq[(A, Int)] = seq match {
      case Seq(x, y) if x != y => com :+ (x, count) :+ (y, 1)
      case Seq(_, y) => com :+ (y, count + 1)
      case x +: y +: s if x != y => compressAux(y +: s, com :+ (x, count))
      case _ +: y +: s => compressAux(y +: s, com, count + 1)
    }
    compressAux(seq)
  }

}
