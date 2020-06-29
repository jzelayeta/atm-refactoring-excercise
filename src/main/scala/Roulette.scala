import scala.util.Random
import collection.mutable.Map

class Roulette {
  private val bets = Map.empty[Player, List[Bet]]

  private val payOutTable = (bet: Bet) =>
    if (bet.name == "Straight") 36
    else if (bet.name == "Split") 18
    else if (bet.name == "Street") 12
    else if (bet.name == "Square") 8
    else if (bet.name == "Double Street") 5
    else 2

  def spin(): List[(Player, BigDecimal)] = {
    val winningNumber = Random.nextInt(36)
    var responsePayOutByPlayer = List.empty[(Player, BigDecimal)]
    for ((player, bets) <- bets) {
      var accumulatedPayout = BigDecimal(0)
      for (bet <- bets) {
        if (bet.isWinner(winningNumber)) {
          accumulatedPayout = accumulatedPayout + (payOutTable(bet) * bet.amount)
        }
      }
      responsePayOutByPlayer = responsePayOutByPlayer :+ (player -> accumulatedPayout)
    }
    bets.clear()
    responsePayOutByPlayer
  }

  def registerBet(bet: Bet, player: Player): Roulette = {
    if (bets(player) == null)
      bets.put(player, List(bet))
    else bets.update(player, bets(player) :+ bet)
    this
  }
}
