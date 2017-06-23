//def pascal(c: Int, r: Int): Int = {
//  if (c > r) throw new IllegalArgumentException()
//  if (c == 0 || c == r) return 1
//  pascal(c - 1, r - 1) + pascal(c, r - 1)
//}
//
//if (pascal(0, 2) == 1) println("(0,2) is OK")
//if (pascal(1, 2) == 2) println("(1,2) is OK")
//if (pascal(1, 3) == 3) println("(1,3) is OK")
//
//
//def balance(chars: List[Char]): Boolean = {
//  var parenthesesOpen = 0
//
//  def checkOpenParenthesis(chars: List[Char]): Boolean = {
//    if (chars.isEmpty) return parenthesesOpen == 0
//
//    if (chars.head == '(') {
//      if (parenthesesOpen >= 0) {
//        parenthesesOpen += 1
//      }
//    }
//
//    if (chars.head == ')') {
//      parenthesesOpen -= 1
//    }
//
//    checkOpenParenthesis(chars.tail)
//  }
//
//  checkOpenParenthesis(chars)
//}
//
//if (balance("()".toList)) println("Is balanced")
//if (!balance("(((()))))".toList)) println("Not balanced")
//if (!balance(")()(".toList)) println("Not balanced")
//
//def countChange(money: Int, coins: List[Int]): Int = {
//  if (coins.isEmpty || money < 0) return 0
//  if (money == 0) return 1
//  countChange(money, coins.tail) + countChange(money - coins.head, coins)
//}
//
//if (countChange(300, List(500, 5, 50, 100, 20, 200, 10)) == 1022) println("Correct")

