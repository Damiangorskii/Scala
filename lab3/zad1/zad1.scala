object Main extends App 
{


    def odwroc (str: String): String = {
        
        

        if (str.length <=1)
        {
            
            return str

        }
        else
        {
            
            return "" + odwroc(str.substring(1)) + str.charAt(0)
        }
        
    }

    println("Podaj slowo: ")
    var slowo = readLine()

    println("Twoje slowo odwrotnie: ")
    print("\n")
    var n = slowo.length

    println(odwroc(slowo))

    
    

}