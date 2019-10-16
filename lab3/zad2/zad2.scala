object Main extends App
{
   def palindrom(tab: Array[Int], a: Int, b: Int): Boolean =
   {
       if (a<b)
       {
           if (tab(a) == tab(b))
           {
               return palindrom (tab, a+1, b-1)
           }
           else
           {
               return false
           }
       }
       return true
   }

   println("Podaj ile elementow ma miec twoja tablica: ")
   var n = io.StdIn.readInt()
   var tab = new Array[Int](n)

   var z =0

   while (z<n)
   {
       println("Podaj " + (z+1) + " element tablicy")
       tab(z) = io.StdIn.readInt()
       z=z+1
   }

   var x = tab.size-1

   if (palindrom(tab,0,x))
   {
       println("Tablica jest palindromem")
   }
   else
   {
       println("Nie jest palindromem")
   }
}