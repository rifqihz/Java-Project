# Java-Project
This is my spare time Java Project. I'm trying to create a simple but useful program such as a simple game like snake and ladders and etc and It's a **CLI Program**.
#### Table of Content :
Title | Description
----- | -----------
[Simple Snake and Ladders](https://github.com/zhafrant/Java-Project/tree/master/Simple%20snake%20and%20ladder) | A simple Snake and Ladders (maybe it's more likely a dice game)
[Rock Scissor Paper Game](https://github.com/zhafrant/Java-Project/tree/master/Rock%20Scissor%20Paper%20Game) | Just like a usual rock scissor and paper game

# Simple Snake and Ladders
### Java
I used **java 1.8.0_241**
Library : 
- **Java.Util.Random** for the dice and the output is integer between 1-12 
- **Java.util.Scanner** to read the input from keyboard
### input
1. The first line is **board size** (ex 100) (**int**)  
1. The next line is the n **number of player** (ex 5) (**int**)  
1. There will be n line to add **player's name** (ex bejo) (**string**)
### Output
For example
```
Input board size : 100
Input number of player : 5
Input player 1 name : bejo
Input player 2 name : tejo
Input player 3 name : burjo
Input player 4 name : banjo
Input player 5 name : sijo
---Ranking---
1. burjo(Player 3)
Movement (16 moves) : 6 12 15 18 25 25 34 45 52 62 69 74 84 89 89 100 
2. sijo(Player 5)
Movement (21 moves) : 11 22 26 27 35 42 49 60 66 66 74 81 83 84 84 84 95 96 95 95 100 
3. tejo(Player 2)
Movement (23 moves) : 6 6 11 22 28 35 41 52 57 59 65 66 66 67 73 78 89 91 95 98 97 94 100 
4. banjo(Player 4)
Movement (26 moves) : 6 7 14 22 25 28 28 33 35 36 46 46 54 63 68 72 76 82 87 87 92 98 92 92 97 100 
5. bejo(Player 1)
Movement (50 moves) : 9 20 27 33 37 44 46 52 60 71 79 85 94 96 97 96 95 95 98 99 93 98 92 97 98 97 97 93 96 94 98 93 95 95 99 90 93 97 97 97 96 96 97 99 95 98 93 99 90 100
```


# Rock Scissor Paper Game
### Java  
I use **Java 1.8.0_241**  
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

