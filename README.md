# Roulette Model Implementation

* A player can place multiple bets on a single roulette hand.
* Supported bets are the following: 
	- Straight: Bet on a single number	
	- Split: Bet on two vertically/horizontally adjacent numbers (e.g. 14-17 or 8-9)
	- Street: Bet on three consecutive numbers in a horizontal line (e.g. 7-8-9)
	- Square: Bet on four numbers that meet at one corner (e.g. 10-11-13-14)
	- Double Street: Bet on six consecutive numbers that form two horizontal lines (e.g. 31-32-33-34-35-36)	
	- Column Bet: A bet that the number will be in the chosen vertical column of 12 numbers, such as 1-4-7-10 on down to 34. The chip is placed on the space below the final number in this sequence.
	- Dozen Bet: A bet that the number will be in the chosen dozen: first (1-12, Première douzaine or P12), second (13-24, Moyenne douzaine or M12), or third (25-36, Dernière douzaine or D12).
	- Red or black: A bet that the number will be the chosen color.
	- Even or Odd: A bet that the number will be of the chosen type.

* Each bet has an associated payout benefit, i.e Straight bet pays 36 to 1. 

* A Player is represented as following: 
    ```case class Player(name: String)```
* Bet attributes are : 
   - betting amount
   - betting numbers

The PoC must implement the two following use cases: 
* Collect all the bets that players place in each hand
* Spin the roulette
* Announce payouts to players
