# Guideline
### Java
- I use Java 1.8.0  
library : 
    - java.time.Instant
    - java.time.ChronoUnit
    - java.util.Scanner
    - java.util.Random
### Input
1. Input the number of player (max 2)
1. For n player input player's name (one by one)
1. Input the choice (can be number or string)   
**Accepted** : 
   - Number (1 , 2 , 3)
   - String (rock, paper,scissor) in any case
1. Quit the game, the answer is 'y' or 'n' (in any case)

### Output
```
Created by Rifqihz
Welcome to Rock Paper & Scissor Game !!!

Input the number of player (max 2) : 1
Input your name : Rifqi

Choice : 
1. Rock
2. Scissor
3. Paper
Input your choice : 3
Rifqi paper
Computer 1 paper
It's Draw !!! 
Do you want to quit?[Y|N] : n

Input your choice : 1
Rifqi rock
Computer 1 scissor
Rifqi win !!!
Do you want to quit?[Y|N] : n

Input your choice : 2
Rifqi scissor
Computer 1 scissor
It's Draw !!! 
Do you want to quit?[Y|N] : n

Input your choice : 1
Rifqi rock
Computer 1 scissor
Rifqi win !!!
Do you want to quit?[Y|N] : n

Input your choice : 1
Rifqi rock
Computer 1 rock
It's Draw !!! 
Do you want to quit?[Y|N] : n

Input your choice : 3
Rifqi paper
Computer 1 paper
It's Draw !!! 
Do you want to quit?[Y|N] : n

Input your choice : 2
Rifqi scissor
Computer 1 rock
Computer 1 win !!!
Do you want to quit?[Y|N] : y


=====Final Ranking=====
Total Time  : 0 Minutes 37 Seconds
Total Games : 7

Name  	: Rifqi
Win 	: 2
Lose	: 1
Draw	: 4

Name  	: Computer 1
Win 	: 1
Lose	: 2
Draw	: 4
```
