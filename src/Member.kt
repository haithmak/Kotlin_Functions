class Member{
    /*0-Member functions
      A member function is a function that is defined inside a class or object:
     */
    fun foo() { println("Foo") }

    /*1-inline functions
    inline annotation means that function as well as function
    parameters will be expanded at call site that means it helps
    reduce call overhead. The goal of this post is to get a basic
    understanding of inline in Kotlin.
     */
    fun Squre(a: Int, func: () -> Unit):Int {
        func()
        return 2*a
    }


    inline fun inlineSqure(a: Int, func: () -> Unit):Int {
        func()
        return 2*a
    }

/*2-Local functions
    Kotlin supports local functions, i.e. a function inside another function:
     */
fun login(username: String, password: String) : Boolean {
    var something = 1
    fun validateInput(input: String) {
        something++
        if (input.isEmpty()) {
            throw IllegalArgumentException("Must not be empty")
        }
    }
    validateInput(username)
    validateInput(password)
    return true
}

 /*3-lambda functions
    Lambda is a function which has no name.
    Lambda is defined with a curly braces {}
    which takes variable as a parameter (if any) and body of function.
     The body of function is written after variable
     (if any) followed by -> operator.
  */
 val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }


    
 fun addNumber(x: Int, y: Int): Int =  x + y

    fun addNumber(a: Int, b: Int, mylambda: (Int) -> Unit ){   //high level function lambda as parameter
        val add = a + b
        mylambda(add) // println(add)
    }

    fun compare(a: String, b: String): Boolean = a.length < b.length



}

fun main(args: Array<String>) {
//0-Member functions
    Member().foo() ;
//1-inline functions
    var a = 2
    println(Member().Squre(a, {println("Just some dummy function")}))

    println(Member().inlineSqure(a, {println("Just some dummy function")}))

//2-Local functions
    Member().login("admin", "admin") ;

//3-lambda functions
    println(Member().sum(3,4))



    Member().compare("haitham","Laith")

    val myLambdaa: (Int) -> Unit= {s: Int -> println(s) } //lambda function
    Member().addNumber(5,10,myLambdaa)
    Member().addNumber(5,10)





}