# ProjetJava
projet Java


Jeu d'échecs avec JavaFX. 

Une fois le programme lancé, on peut lancer le jeu appuyant sur Jouer ou alors changer le noir pour une autre couleur en appuyant 
sur le bouton en dessous. Un aperçu de la couleur est affiché sur le menu même.

Une fois le jeu lancé, le joueur blanc (en bas) commence.

Les fonctionnalités mises en place :
- un système de tour par tour est mis en place. On peut connaître le joueur actuel grâce à sa couleur affichée dans un carré à gauche.
  Néanmoins, la couleur change même si le joueur a réalisé un mouvement illicite. Toutefois, le programme comprend qu'il s'agit toujours
  de son tour.
- les pièces sont contraintes dans leurs déplacements. Leur direction est imposée et les fous/cavaliers/dames ne peuvent pas sauter par
  dessus d'autres pièces.
- on peut savoir si un joueur est en échec.
- un pion peu avancer de deux cases lors de son premier tour.

Les fonctionnalités non abouties (qui entrainaient de nombreux beugs)
- restreindre les déplacements d'un joueur lorsqu'il est en échec par les déplacements permettant de protéger le roi. Par extension, les
  echecs et mat ne sont pas disponibles.
- transformer un pion une fois qu'il a traversé le plateau. Il devient inutile. Les lignes permettant cela sont commentées et la classe en   question est incluse dans le projet bien que pas utilisée.

Les fonctionnalités non disponibles :
- tous les coups spréciaux tels que les deux rocks ou encore la prise en passant.
- situation de pat
- bouton pour réinitialiser le jeu. Il faut fermer la fenêtre et cliquer de nouveau sur Jouer (le menu reste ouvert).
- message indiquant le vainqueur. En effet, la détection d'échec et mat n'est pas disponible.



