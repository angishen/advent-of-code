package adventofcode2015.asides

// Following along with the parser combinators chapter of the red book
object ParserCombinators {
  trait Parsers[ParseError, Parser[+_]] { self =>
    def or[A](s1: Parser[A], s2: Parser[A]): Parser[A]
    def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]]
    def many[A](p: Parser[A]): Parser[List[A]]
    def map[A, B](a: Parser[A])(f: A => B): Parser[B]

    def char(c: Char): Parser[Char]
    implicit def string(s: String): Parser[String]
    implicit def operators[A](p: Parser[A]) = ParserOps[A](p)
    implicit def asStringParser[A](a: A)(implicit f: A => Parser[String]): ParserOps[String] =
      ParserOps(f(a))

    def run[A](p: Parser[A])(input: String): Either[ParseError, A]

    case class ParserOps[A](p: Parser[A]) {
      def |[B >: A](p2: Parser[B]): Parser[B] = self.or(p, p2)
      def or[B >: A](p2: Parser[B]): Parser[B] = self.or(p, p2)
      def many: Parser[List[A]] = self.many(p)
      def map[B](f: A => B): Parser[B] = self.map(p)(f)
    }
  }

  trait List[+A] {
    def prepend[B >: A](elem: B): NonEmptyList[B] = NonEmptyList(elem, this)
  }

  case class NonEmptyList[+A](head: A, tail: List[A]) extends List[A]

  object Nil extends List[Nothing]

  trait Fruit
  case class Mango() extends Fruit
  case class Banana() extends Fruit

  val mangos: List[Mango] = Nil.prepend(Mango())
  val oranges: List[Fruit] = Nil
  val aFruit: Fruit = Banana()

  val fruits: List[Fruit] = mangos

  val someFruit = mangos.prepend(aFruit)
  val moreFruit = fruits.prepend(Banana())

  val allFruit = mangos.prepend(Banana())

//  val error = moreFruit.prepend(oranges)
}
