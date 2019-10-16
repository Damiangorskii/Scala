object Main extends App {
  println("podaj liczbe")
  var liczba =	io.StdIn.readInt()

  var i=1
  var a=0
  while (a==0)
  {
    while ((i*i)!=liczba)
    {
      i+=1
      if (i>100000)
      {
        a=1
      }
    }

  }

}