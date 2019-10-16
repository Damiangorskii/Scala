object Main extends App {
    
    
    println("Podaj pierwsza liczbe: ")
    var a = io.StdIn.readLine()

    println("Podaj druga liczbe: ")
    var b = io.StdIn.readLine()

    if (a.length < b.length)
    {
        val o = a 
        a = b
        b = o
    }   


    a = "0" + a 

    while (a.length != b.length)
    {
        b = "0" + b
    }


    val operacje = a.length +1

    var i=0
    var sum = ""
    var gora = 0

    while (i<operacje-1)
    {
        val A : Int = ("" + a.charAt(operacje-i-2)).toInt
        val B : Int = ("" + b.charAt(operacje-i-2)).toInt

        val SUMA = A + B + gora

        if (SUMA>=10)
        {
            gora = 1
        }
        else
        {
            gora = 0
        }

        sum = SUMA%10 + sum

        i+=1

    }

    println(sum)



}