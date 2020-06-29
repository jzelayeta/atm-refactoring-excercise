
abstract class  Bet(val amount: BigDecimal, val numbers: Int*) {
  def isWinner(number: Int): Boolean = numbers.contains(number)
  def name: String
}

case class Straight(override val amount: BigDecimal, number: Int) extends Bet(amount, number) {
  override def name: String = "Straight"
}
case class Split(override val amount: BigDecimal, number1: Int, number2: Int) extends Bet(amount, number1, number2) {
  override def name: String = "Split"
}
case class Street(override val amount: BigDecimal, number1: Int, number2: Int, number3: Int) extends Bet(amount, number1, number2, number3) {
  override def name: String = "Street"
}
case class Square(override val amount: BigDecimal, number1: Int, number2: Int, number3: Int, number4: Int) extends Bet(amount, number1, number2, number3, number4) {
  override def name: String = "Square"
}

case class DoubleStreet(override val amount: BigDecimal, number1: Int, number2: Int, number3: Int, number4: Int, number5: Int, number6: Int)
  extends Bet(amount, number1, number2, number3, number4, number5, number6) {
  override def name: String = "Double Street"
}

case class FirstColumn(override val amount: BigDecimal)
  extends Bet(amount, 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34) {
  override def name: String = "First Column"
}

case class SecondColumn(override val amount: BigDecimal)
  extends Bet(amount, 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35) {
  override def name: String = "Second Column"
}

case class ThirdColumn(override val amount: BigDecimal)
  extends Bet(amount, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36) {
  override def name: String = "Third Column"
}

case class FirstDozen(override val amount: BigDecimal)
  extends Bet(amount, 1 to 12:_*) {
  override def name: String = "First Dozen"
}

case class SecondDozen(override val amount: BigDecimal)
  extends Bet(amount, 13 to 24:_*) {
  override def name: String = "Second Dozen"
}

case class ThirdDozen(override val amount: BigDecimal)
  extends Bet(amount, 25 to 36:_*) {
  override def name: String = "Third Dozen"
}

case class Red(override val amount: BigDecimal)
  extends Bet(amount, 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36) {
  override def name: String = "Red"
}

case class Black(override val amount: BigDecimal)
  extends Bet(amount, 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35) {
  override def name: String = "Black"
}

