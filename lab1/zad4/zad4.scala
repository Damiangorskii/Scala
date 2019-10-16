object Main {
 def main(args: Array[String]) {
  println ("Podaj pierwsza liczbe")
  var a = io.StdIn.readInt()
  println ("Podaj druga liczbe")
  var b = io.StdIn.readInt()

  while(a!=b)
       if(a>b)
           a-=b //lub a = a - b;
       else
           b-=a
    
    println(b)
  
 }
}