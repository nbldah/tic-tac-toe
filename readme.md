
L'objectif est de développer le jeu du morpion (en TDD).
Voici les fonctionnalités voulues (cas de tests): 

1. On veut pouvoir savoir si un **mouvement est autorisé**. C'est à dire que lorsque le joueur X joue dans la case "1", le joueur O ne peut plus jouer dans cette même case.


2) Lors d'une partie, à tout moment, on veut pouvoir savoir si un des joueurs à **gagner la partie**
     
|  |           |  |
| :-----: |:--:| :---:|
| 1  |  2  |  3 |
| 4  | 5   |   6 |
| 7  | 8   |    9 |

Plusieurs combinaisons sont possibles pour gagner (1,4,7) ou (1,2,3) ou (1,5,9) etc... 

3) Lors d'une partie, a tout moment, on veut pouvoir savoir si la **partie est finie**. Cela signifie qu'un des deux joueurs à gagner ou bien que tous les coups on été joué.


Remarque: 

- Afin de simplifier la conception et se focaliser sur le TDD, il sera possible de créer une classe TicTacToeGame qui comprendra 2 listes playerXmoves, player0moves. 

- On admettera qu'une partie se joue de manière linéaire :
X joue 1
O joue 4 
X joue 2 
... 
