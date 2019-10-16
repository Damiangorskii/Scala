object Main 
{
 def main(args: Array[String]) 
 {
     println("Podaj n: ")
     var n = io.StdIn.readInt()

    var tab = new Array[String](n) 

    var x=0

    while (x<n)
    {
        println("Podaj wyraz:")
        tab(x)= io.StdIn.readLine()
        x+=1
    }

    x=0
    println("Twoja tablica wyglada tak:")
    while(x<n)
    {
        println(tab(x))
        x+=1
    }

    var j=0

    while (j<n-1)
    {
        var i=0
        while (i<n-1)
        {
            if (tab(i).length > tab(i+1).length)
            {
                var o = tab(i)
                tab(i) = tab(i+1)
                tab(i+1)= o
            }
            else if (tab(i).length == tab(i+1).length)
            {
                if (tab(i)> tab(i+1))
                {
                    var o = tab(i)
                    tab(i) = tab(i+1)
                    tab(i+1)= o
                }
            }
            i+=1
        }
        j+=1
    }

    x=0
    println("Twoja tablica wyglada tak:")
    while(x<n)
    {
        println(tab(x))
        x+=1
    }


    

 }


}