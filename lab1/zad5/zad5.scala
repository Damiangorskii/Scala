object Main {
 def main(args: Array[String]) {
  println("podaj liczbe")
  var liczba =	io.StdIn.readInt()
    var dzielnik=0
  var i=1
  var a=0
    while (i<=liczba)
    {
      if (liczba%i==0)
      {
         dzielnik= dzielnik+1
      }
        i=i+1
    }
    if (dzielnik==2)
    {
        println("JEST PIERWSZA")
    }
    else
    {
        println("NIE JEST")
    }
    

    

  }
 }
