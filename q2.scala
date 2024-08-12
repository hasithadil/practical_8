package practical_8

object q2 {

  def main(args: Array[String]): Unit={

    println("Enter integer value : ")
    val num = scala.io.StdIn.readInt()

    // Define lambda functions for the different cases
    val multipleOfThree: Int => Boolean = (n: Int) => n % 3 == 0
    val multipleOfFive: Int => Boolean = (n: Int) => n % 5 == 0
    val multipleOfBoth: Int => Boolean = (n: Int) => n % 3 == 0 && n % 5 == 0

    // Use pattern matching to categorize the number
    val result = num match {
      case n if multipleOfBoth(n) => "Multiple of Both Three and Five"
      case n if multipleOfThree(n) => "Multiple of Three"
      case n if multipleOfFive(n) => "Multiple of Five"
      case _ => "Not a Multiple of Three or Five"
    }

    println(result)

  }
}
