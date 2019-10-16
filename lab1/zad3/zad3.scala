object Main {
 def main(args: Array[String]) {
  var x = 1
  var ujemne = 0
  var dodatnie =0
  while (x==1)
  {
    println ("Podaj liczbe")
    var liczba = io.StdIn.readDouble()
    if (liczba == 0)
    {
        x=4;
    }
    else if (liczba < 0)
    {
        ujemne=ujemne+1
    }
    else if (liczba>0)
    {
        dodatnie=dodatnie+1
    }
  }
  println(ujemne)
  println(dodatnie)
  
 }
}