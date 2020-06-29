trait Roulette {
  def spin(): List[(Player, BigDecimal)]
  def registerBet(bet: Bet, player: Player): Roulette
}