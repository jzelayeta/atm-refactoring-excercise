package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Roulette {
  private val bets = ArrayBuffer.empty[(Player, Bet)]

  private val payOutTable: Bet => BigDecimal = (bet: Bet) =>
    if (bet.name == "Straight") 36
    else if (bet.name == "Split") 18
    else if (bet.name == "Street") 12
    else if (bet.name == "Square") 9
    else if (bet.name == "Double Street") 6
    else if (bet.name == "First Column" || bet.name == "Second Column" || bet.name == "Third Column") 3
    else if (bet.name == "First Dozen" || bet.name == "Second Dozen" || bet.name == "Third Dozen") 3
    else if (bet.name == "Red" || bet.name == "Black") 2
    else if (bet.name == "Even" || bet.name == "Odd") 2
    else null

  def spin(): List[(Player, BigDecimal)] = {
    val winningNumber = Random.nextInt(37)
    var responsePayOutByPlayer = List.empty[(Player, BigDecimal)]

    for((player, bet) <- bets) {
      val betsByPlayer = bets.filter(_._1 == player)
        .map(_._2)
        .filter(_.isWinner(winningNumber))

      var winningAcc = BigDecimal(0)
      for (winningBet <- betsByPlayer) {
        val payout = payOutTable(winningBet)
        val winningAmount = if (payout == null) BigDecimal(0) else payout * winningBet.amount
        winningAcc = winningAcc + winningAmount
      }
      responsePayOutByPlayer = responsePayOutByPlayer :+ player -> winningAcc
    }
    bets.clear()  // remove all placed bets after paying out
    responsePayOutByPlayer.distinct // this is to avoid possible duplicate answers
  }


  def registerBet(bet: Bet, player: Player): Roulette = {
    bets.addOne(player -> bet)
    this
  }
}