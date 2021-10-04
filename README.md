# Let Me Graduate! 

### Pass Projects with the "best" teammates for your graduation!!

#### What will this application do? 

###### Generals:

This application performs a game : Let Me Graduate.

In this game, the player is assigned to a team in a course for a project. 

The goal of this game is to finish the given project before the due date. 

It takes certain amount of time(days) to finish work of each team members.
 
To finish the project, all personal tasks must be done. 

There are obstacles in the way of the project involving our wonderful teamates. 
They have the following conditions to not work on the project

- exam preparation 
- dinner plan with their friends
- Or just not in a mood to work
- etc(need to be added)

Thus, as a team lead *even if you don't want to be...*
You MUST do one of the followings to finish the project:

- help a student to get rid of what makes them be not able to work on the project
- exclude from team
- sip a coffee do all the work

Each choice will have consequences, for example

- helping -> little annoying but increase productability
- excluding -> simple, but lose workforce
- doing all the work -> simple, but might not have enough time

Depending on the situation. You can choose whatever option you want.

Additionally, players have some favors for themselves.**Think about it, might get really complicated**

- coffee break
- talk with professor
- talk with TA  
- etc....

###### Details:

- Each project has n days till the due. 
- In a day, a player has restricted actions to perform (each action costs time)
- If all tasks assigned to a person is done before the due, you win

#### Who will use it? (need more specificatino)

-Gamers,students who are stressed from their everyday school team projects, 
who hope to take control over their college team projects, 
-Professors, instructors, who are about to distribute a new team project. 

#### Why this project interests me?

As a huge fan of many games, I've always wanted to make a game. Especially, the games with 
text-based interface attracted me since it left me with the space with imaginations. Also, a game where a
player has freedom to finish a task(for example, game "**Dishonored").

Also, as a college student, I always found team projects challenging due to its nature. 
different people, different courses, different abilities, teamates who do not fit to my expectations. 

Thus, I came up with a game with these interests
- room for imagination, and freedom.
- and about my school life.

In this game, I hope players to find the features that inspires me, and also what I've seen, or realized in the project. 
ic fonts correctly but they will appear correctly on GitHub.

### User Story

- As a user, I want to be able to add a new student to my students list
- As a user, I want to be able to create a new game (of  project with due date and teammates)
- As a user, I want to be able to see actions of user's choice in each day
- As a user, I want to be able to perform actions of user's choice in each day
- As a user, I want to be able to progress to next time
- As a user, I want to be able to view of lists of tasks to finish and the required times
- As a user, I want to be able to save my game to file
- As a user, I want to be able to load my game from file
- As a user, I want to be able to see students with personal taks time more than 3

### Project Phase 4: Task 3

#### Changed
-Included a type hierarchy
-Task (abstract class)
-TeamTask (subclass 1), overrides toJson abstract method in super.
-PersonalTask (subclass 2), overrides toJson abstract method in super.


#### More refactoring if given more time
After drawing the UML diagram, I found out that coupling of this program is considerable.
To draw UML clearly, I had to cross many lines which indicates that there is a tight coupling
that is to be fixed. 
- So the parts that I can improve more are : the coupling around Student, Game, LetMeGraduate, StudentList
- I would be able to fix the coupling by making the association between the types bi-directional. 

Also, subclassing around Panels(SaveEndPanel, LoadStartPanel, StudentSelectionPanel) is another possible
improvement since there are duplicate codes between the three classes. 
