#  Stick Man 

## Game was made on 2K display screen, in any case of resolution issue contact dushyant22181@iiitd.ac.in
## Game Mechanics
### Stick Growth Mechanism:
   Hold your mouse button to extend the stick length.
   The stick's fate depends on whether it lands within the boundaries of the pillar or causes your hero to fall.

   ### Bonus Point for Precision:
   Receive a bonus point if your stick lands on the middle red section of a pillar.
        Precision landing enhances your score.

   ### Collectibles on the Way:
   Encounter cherries and bombs while progressing through the game.
        Flip hero using spacebar to collect cherries to earn points, but avoid bombs as they lead to instant game over.

   ### Revival with Cherries:
   Accumulate three cherries to revive your hero if a mishap occurs.
        Cherries act as a lifeline, providing a second chance to continue the game.

   ### Save and Load Game Progress:
   Utilize the save and load game functionality to retain or resume your progress.
        Ensure your achievements are preserved, allowing for a seamless gaming experience.
   ### Dramatic and Thrilling Music:
   The distinct sound effects accompanying each animation intensify the overall excitement, providing a more dramatic and immersive thrill during gameplay.
   ### Also include inception mode:
   An inverted universe, where everything, including our hero, defies the fundamental force of gravity, offers players a novel and exhilarating experience.

## How To Run

1. Open Terminal
2. Open your directory containing the POM File
3. Execute mvn clean javafx:run

If you are opening the project on Intellij and planning to run it using the run dialog then first extract the zip, a StickHero folder will be extracted, open another StickHero folder contained inside of it otherwise the code might malfunction.

# Classes Overview

## HelloApplication 

## Overview

This test case focuses on the `HelloApplication` class in the Stick Hero application. The `HelloApplication` class extends the `Application` class from JavaFX, and it is responsible for initializing the main stage, setting up the application window, and handling the launch of the Stick Hero game.

## Test Case Details



### Test Scenario

1. **Description**: Launch the Stick Hero application and verify the initialization of the main stage.
   - **Test Method**: `public void start(Stage stage) throws IOException, InterruptedException`
   - **Expected Outcome**: The main stage should be initialized with the appropriate title, icon, and resizable properties. The Stick Hero game should be displayed.

2. **Description**: Close the Stick Hero application.
   - **Test Method**: `public static void close()`
   - **Expected Outcome**: The main stage should be closed, terminating the Stick Hero application.

3. **Description**: Run the JUnit test for the `Sticks` class.
   - **Test Method**: `public static void main(String[] args)`
   - **Expected Outcome**: The JUnit test for the `Sticks` class should be executed, and the results should be printed. The test should indicate whether the `Sticks` class passed or failed.

## Test Execution

The test case executes the `HelloApplication` class, launching the Stick Hero application. It then runs the JUnit test for the `Sticks` class and prints the results, including any failures if they occur.




## RealSceneMangaer

## Overview

The `RealSceneMangaer` class in the Stick Hero game project is responsible for managing scene transitions and controlling the game's flow. It utilizes the Facade design pattern to simplify the interaction with various game scenes.

## Class Structure

### Fields

- `scene`: Represents the JavaFX scene used for displaying different game scenes.
- `c`: An integer used as a flag to determine if the game has started.
- `loadFlag`: A boolean flag to indicate whether the game should load a saved state.
- `objb`: An instance of the `SoundDesign` class responsible for handling sound effects.
- `t1`: A thread used to execute the sound-related operations.

### Constructors

- `RealSceneMangaer(int i)`: Initializes the `RealSceneMangaer` and triggers the sound design for different scenarios.
- `RealSceneMangaer()`: Default constructor.

### Methods

#### `changeScene(int ch)`

- Facilitates the transition between different game scenes based on the provided choice (`ch`).
- Invokes the appropriate sound design for each scenario.

#### `switchToGame()`

- Switches to the main game scene (`SceneManager`) based on specific conditions.
- Resets the game state if it is not a continuation or revival scenario.

#### `switchToGameover(String s)`

- Switches to the game over scene (`Gameover`) with the specified background image.

#### `switchToMainMenu()`

- Switches to the main menu scene (`Menu`).

# Design Patterns 
## Annotated Design Patterns wherever used
## Singleton Design Pattern
The class implements the Singleton pattern to ensure that only a single object is created for the class OurHero.
## Facade Design Pattern

The class implements the Facade pattern by providing a simplified interface (`changeScene` method) to interact with the complex subsystems involved in managing scenes and sound effects.

## Usage

- Create an instance of `RealSceneMangaer`.
- Use the `changeScene` method to switch between different game scenes.
- Implement the necessary actions for each specific scenario.




## SceneManager Class

The `SceneManager` class is a part of the Stick Hero game implementation in JavaFX. It is responsible for managing the scenes, including pillars, cherries, mines, and the player character. This class handles various game functionalities, such as collision detection, scoring, and transitioning between scenes.

## Table of Contents

- [Introduction](#introduction)
- [Attributes](#attributes)
- [Methods](#methods)
- [Usage](#usage)
- [License](#license)

## Introduction

The `SceneManager` class is a crucial component of the Stick Hero game, managing the game scenes and coordinating various game elements. It utilizes JavaFX for graphics and animations, providing an engaging gaming experience.

## Attributes

- `rinst`: Rectangle for displaying game instructions.
- `instructions`: Text displaying game instructions.
- `pressHoldMouse`: Text providing instructions for holding the mouse button.
- `SpaceFlip`: Text indicating the use of the Spacebar to flip the hero.
- `continueflag`: Flag indicating whether the game should continue.
- `counted`: Flag to prevent repeated counting of game elements.
- `transflag`: Flag for handling scene transitions.
- `cherries`: Instance of the `Cherries` class for managing cherry objects.
- `mines`: Instance of the `Mines` class for managing mine objects.
- `redarea`: Rectangle indicating a critical area during gameplay.
- `gameLoop`: Timeline for managing the game loop.

... (and more)

## Methods

- `isTransflag()`: Getter for the `transflag` attribute.
- `setTransflag(boolean transflag)`: Setter for the `transflag` attribute.
- `isContinueflag()`: Getter for the `continueflag` attribute.
- `setContinueflag(boolean continueflag)`: Setter for the `continueflag` attribute.
- `getGameLoop()`: Getter for the `gameLoop` attribute.
- `setGameLoop()`: Setter for stopping the game loop.
- `startGameLoop()`: Method to start the game loop.
- `switchtoPause()`: Method to switch to the pause menu during gameplay.
- `removePauseMenu()`: Method to remove the pause menu and resume the game.
- `translateAfterLanding()`: Method to handle scene translation after landing on a pillar.
- `addFirstPillar()`: Method to add the initial pillar to the scene.
- `addPillars()`: Method to add subsequent pillars during gameplay.
- `addHero()`: Method to add the player character to the scene.
- `generateStick()`: Method to generate the stick for the player character.
- `returnSticktoDefault()`: Method to return the stick to its default position.
- `playMusic()`: Method to play background music during gameplay.
- ... (and more)


## Menu

## Overview

The `Menu` class is responsible for creating the main menu screen of the Stick Hero game. It utilizes JavaFX for the graphical user interface, providing buttons for starting the game, accessing game statistics, loading and saving game progress, and exiting the game.

## Class Structure

### Fields

- `root`: An `AnchorPane` representing the root container for the menu elements.
- `scene`: A `Scene` object representing the graphical scene for the main menu.

### Constructors

- `Menu()`: Initializes and constructs the main menu by calling the `menuScreen()` method.

### Methods

#### `menuScreen()`

- Creates the graphical elements of the main menu, including background, title text, play button, help button, and statistics button.
- Implements animations for button hover effects.
- Handles button click events for starting the game, accessing help, and viewing statistics.
- Provides the option to load and save game progress.

#### `getScene()`

- Returns the `Scene` object associated with the main menu.

#### `setScene(Scene scene)`

- Sets the `Scene` object for the main menu.

#### `getRoot()`

- Returns the root `AnchorPane` of the main menu.

#### `setRoot(AnchorPane root)`

- Sets the root `AnchorPane` for the main menu.

## Usage

- Create an instance of the `Menu` class.
- Retrieve the `Scene` and `AnchorPane` as needed.
- Interact with the main menu elements by clicking buttons.

## OurHero

## Overview

The `OurHero` class represents the main character of the Stick Hero game. It uses the Singleton design pattern to ensure that only one instance of the hero exists. The hero has methods to move, flip, and interact with the game environment, as well as to handle scoring.

## Class Structure

### Fields

- `score`: An integer representing the score of the hero.
- `flipped`: A boolean indicating whether the hero is flipped or not.
- `cherrycount`: An integer representing the count of cherries collected by the hero.
- `heromovingflag`: A flag indicating whether the hero is currently moving.

### Constructors

- `OurHero()`: A private constructor to enforce the Singleton pattern.
- `getInstance()`: Returns the singleton instance of the `OurHero`.
- `setHero(OurHero objLoad)`: Sets the hero instance, used when loading a saved game.

### Methods

#### `getScore()`

- Returns the current score of the hero.

#### `isHeromovingflag()`, `setHeromovingflag(boolean heromovingflag)`

- Getter and setter for the `heromovingflag` field.

#### `getCherrycount()`, `setCherrycount(int cherrycount)`

- Getter and setter for the `cherrycount` field.

#### `createHero()`

- Creates the hero using an FXML loader to load the hero's graphical representation.

#### `moveHero()`

- Initiates the hero's movement, handling various scenarios such as falling short, landing on the pillar, and moving before a big fall.

#### `increaseScore(OurHero obj)`

- Increases the hero's score.

#### `stopThread()`

- Stops the animation thread associated with the hero's leg movement.

#### `flipHero()`

- Flips the hero, changing its orientation.

#### `stepsOnMines()`

- Placeholder method indicating that the hero steps on mines

## Pillars

## Overview

The `Pillars` class is responsible for creating and managing pillars in the Stick Hero game. It keeps track of the last generated pillar and the pillar under the hero. Pillars are represented as rectangles with varying widths.

## Class Structure

### Fields

- `lastpillar`: A static field representing the last generated pillar.
- `heropillar`: A static field representing the pillar under the hero.
- `random`: An instance of the `Random` class for generating random values.

### Constructors

- `Pillars()`: Default constructor.

### Methods

#### `getLastpillar()`, `setLastpillar(Rectangle lastpillar)`

- Getter and setter for the `lastpillar` field.

#### `getHeropillar()`, `setHeropillar(Rectangle heropillar)`

- Getter and setter for the `heropillar` field.

#### `makeFirstPillar()`

- Creates the first pillar at the bottom of the screen and sets it as both the last pillar and the hero's pillar.

#### `makePillars()`

- Generates a new pillar with a random width and position above the screen. Updates the last pillar and returns the newly created pillar.

#### `randomWidth()`

- Generates a random width for a pillar within a specified range.

#### `randomX(double width)`

- Generates a random X coordinate for a pillar, ensuring it does not overlap with the edges of the screen or the previous pillar.

## Sticks

## Overview

The `Sticks` class is responsible for handling the growth and fall animation of the stick in the Stick Hero game. It uses JavaFX animations to create the stick's falling motion and controls the stick's rotation during the fall.

## Class Structure

### Fields

- `rect`: A static field representing the stick as a rectangle.
- `angle`: A static field representing the current angle of rotation during the stick's fall.
- `distance`: A static field representing the distance between the hero's pillar and the last pillar.
- `t`: A static `Timeline` object for controlling the stick's rotation animation.
- `flag`: A static boolean flag to control the stick's animation state.

### Constructors

- `Sticks()`: Default constructor.

### Methods

#### `growStick(Rectangle rect)`

- Increases the height of the stick by 4 units and adjusts its position.

#### `fallStick(Rectangle rect)`

- Initiates the falling animation of the stick by gradually rotating it. It calculates the distance between the hero's pillar and the last pillar to determine the rotation angle. After the animation, it checks whether the game can continue or if the animation should be stopped.

#### `stopStickAnimation()`

- Pauses the stick's animation and sets the `flag` to false.

#### `check_flag_false(boolean flag)`

- JUnit test method to check if the `flag` is false.

#### `check_flag_true(boolean flag)`

- JUnit test method to check if the `flag` is true.

#### `resumeStickAnimation()`

- Resumes the stick's animation if it was paused. It checks for the animation's null status before resuming.

#### `check_not_null(Timeline t)`

- JUnit test method to check if the `Timeline` object is not null.

#### `check_null(Timeline t)`

- JUnit test method to check if the `Timeline` object is null.

## PauseMenu Class



## Constructors

### 1. `PauseMenu()`
- **Description**: Default constructor for creating a pause menu.
- **Usage**: Used to create a pause menu object.

### 2. `PauseMenu(String s)`
- **Description**: Parameterized constructor that takes a background image file path as a parameter and sets it as the background for the pause menu.
- **Parameters**:
  - `s` - The path of the background image file.
- **Usage**: Used when a specific background image is needed for the pause menu.

## Class Fields

1. **`private static Scene scene`**
   - **Description**: Represents the JavaFX scene associated with the pause menu.
   - **Access Modifier**: Private
   - **Usage**: Used to manage the scene for the pause menu.

2. **`public static AnchorPane root`**
   - **Description**: Represents the root layout for the pause menu.
   - **Access Modifier**: Public
   - **Usage**: Used to organize and display various UI elements on the pause menu.

3. **`static Text cherrycount`**
   - **Description**: Represents the text displaying the current cherry count.
   - **Access Modifier**: Static
   - **Usage**: Used to dynamically update and display the current cherry count.

4. **`String backgroundImage`**
   - **Description**: Represents the file path of the background image for the pause menu.
   - **Usage**: Used to store the background image path.

## Methods

### 1. `public void pauseMenu()`
- **Description**: Initializes and configures the components of the pause menu, such as buttons, text, and background.
- **Usage**: Called in the constructor to set up the pause menu.

### 2. `private ImageView createImageView(String imageUrl, double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect)`
- **Description**: Creates an ImageView object with specified parameters.
- **Parameters**:
  - `imageUrl` - Path of the image file.
  - `layoutX` - X-coordinate of the image.
  - `layoutY` - Y-coordinate of the image.
  - `fitWidth` - Width of the image.
  - `fitHeight` - Height of the image.
  - `rotate` - Rotation angle of the image.
  - `effect` - JavaFX effect to be applied to the image.
- **Returns**: The created ImageView.
- **Usage**: Used to create image views for various UI elements.

### 3. `private Text createText(String text, double layoutX, double layoutY, double fontSize, javafx.scene.effect.Effect effect)`
- **Description**: Creates a Text object with specified parameters.
- **Parameters**:
  - `text` - The text content.
  - `layoutX` - X-coordinate of the text.
  - `layoutY` - Y-coordinate of the text.
  - `fontSize` - Font size of the text.
  - `effect` - JavaFX effect to be applied to the text.
- **Returns**: The created Text object.
- **Usage**: Used to create text elements for various UI components.

### 4. `private Button createButton(String text, double layoutX, double layoutY, double fontSize)`
- **Description**: Creates a Button object with specified parameters.
- **Parameters**:
  - `text` - The text content of the button.
  - `layoutX` - X-coordinate of the button.
  - `layoutY` - Y-coordinate of the button.
  - `fontSize` - Font size of the button text.
- **Returns**: The created Button object.
- **Usage**: Used to create buttons for user interactions.

### 5. `public void updateCherryCount()`
- **Description**: Updates and displays the current cherry count on the pause menu.
- **Usage**: Called to reflect changes in the cherry count during gameplay.

## Additional Information

- The class includes functionality for saving and loading the game using object serialization.
- The pause menu provides options to save the game, load a saved game, and return to the main menu.
- Sound effects are triggered for certain button clicks in the pause menu.


## Cherries Class

## Constructors

### 1. `Cherries()`
- **Description**: Default constructor for creating Cherries objects.
- **Usage**: Used to create a Cherries object and invoke the `make()` method.

## Class Fields

1. **`private int xcoord`**
   - **Description**: Represents the x-coordinate of the cherry.
   - **Usage**: Used to store the x-coordinate of the cherry.

2. **`private int ycoord`**
   - **Description**: Represents the y-coordinate of the cherry.
   - **Usage**: Used to store the y-coordinate of the cherry.

3. **`private int updown`**
   - **Description**: Represents the direction of the cherry's movement (up or down).
   - **Usage**: Used to store the direction of the cherry's movement.

4. **`private static ImageView imageView`**
   - **Description**: Represents the JavaFX ImageView object for the cherry.
   - **Usage**: Used to display the cherry image.

## Methods

### 1. `public ImageView createImageView(String imageUrl, double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect)`
- **Description**: Creates an ImageView object for the cherry with specified parameters.
- **Parameters**:
  - `imageUrl` - Path of the cherry image file.
  - `layoutX` - X-coordinate of the cherry.
  - `layoutY` - Y-coordinate of the cherry.
  - `fitWidth` - Width of the cherry image.
  - `fitHeight` - Height of the cherry image.
  - `rotate` - Rotation angle of the cherry image.
  - `effect` - JavaFX effect to be applied to the cherry image.
- **Returns**: The created ImageView for the cherry.
- **Usage**: Used to create and configure the ImageView for the cherry.

### 2. `public ImageView make()`
- **Description**: Generates a new cherry at a random x-coordinate within the valid range.
- **Returns**: The ImageView object representing the generated cherry.
- **Usage**: Invoked to create a new cherry.

## Additional Information

- Cherries are generated randomly within a specific x-coordinate range based on the position of the last pillar.
- The class provides methods to retrieve the x-coordinate, y-coordinate, and movement direction of the cherry.
- The cherry image is displayed using JavaFX ImageView.


## Mines Class



## Constructors

### 1. `Mines()`
- **Description**: Default constructor for creating Mines objects.
- **Usage**: Used to create a Mines object and invoke the `make()` method.

## Class Fields

1. **`private int xcoord`**
   - **Description**: Represents the x-coordinate of the mine.
   - **Usage**: Used to store the x-coordinate of the mine.

2. **`private int ycoord`**
   - **Description**: Represents the y-coordinate of the mine.
   - **Usage**: Used to store the y-coordinate of the mine.

3. **`private int updown`**
   - **Description**: Represents the direction of the mine's movement (up or down).
   - **Usage**: Used to store the direction of the mine's movement.

## Methods

### 1. `public ImageView createImageView(String imageUrl, double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect)`
- **Description**: Creates an ImageView object for the mine with specified parameters.
- **Parameters**:
  - `imageUrl` - Path of the mine image file.
  - `layoutX` - X-coordinate of the mine.
  - `layoutY` - Y-coordinate of the mine.
  - `fitWidth` - Width of the mine image.
  - `fitHeight` - Height of the mine image.
  - `rotate` - Rotation angle of the mine image.
  - `effect` - JavaFX effect to be applied to the mine image.
- **Returns**: The created ImageView for the mine.
- **Usage**: Used to create and configure the ImageView for the mine.

### 2. `public ImageView make()`
- **Description**: Generates a new mine at a random x-coordinate within the valid range.
- **Returns**: The ImageView object representing the generated mine.
- **Usage**: Invoked to create a new mine.

## Additional Information

- Mines are generated randomly within a specific x-coordinate range based on the position of the last pillar.
- The class provides methods to retrieve the x-coordinate, y-coordinate, and movement direction of the mine.
- The mine image is displayed using JavaFX ImageView.

## MinesAndCherries Interface


## Methods

### 1. `public ImageView make()`
- **Description**: Abstract method to be implemented by classes that represent mines and cherries.
- **Returns**: The ImageView object representing the generated mine or cherry.
- **Usage**: Implemented to create and display mines or cherries in the Stick Hero game.

## Additional Information

- This interface serves as a common contract for classes representing mines and cherries in the Stick Hero game.
- Classes implementing this interface must provide their specific implementation of the `make()` method to generate and display the corresponding game elements.


## Buttons Class



## Class Fields

1. **`private static boolean flag`**
   - **Description**: Represents the flag indicating whether the button is pressed or not.
   - **Usage**: Used to control the execution of certain actions when the button is pressed.

2. **`private static boolean flag2`**
   - **Description**: Represents an additional flag for controlling button actions.
   - **Usage**: Used in conjunction with `flag` to ensure proper execution flow.

3. **`private static boolean flagtrns`**
   - **Description**: Represents the flag for controlling transitions.
   - **Usage**: Used to control transitions in the game.

4. **`private static boolean canFlip`**
   - **Description**: Represents the flag indicating whether the hero can flip or not.
   - **Usage**: Used to control the ability of the hero to perform flips.

5. **`private Timeline timeline`**
   - **Description**: Represents the JavaFX Timeline for animation.
   - **Usage**: Used to control the growth animation of the stick.

6. **`private Sticks st`**
   - **Description**: Represents an instance of the `Sticks` class.
   - **Usage**: Used to interact with the stick and hero elements in the game.

## Methods

### 1. `public Buttons()`
- **Description**: Default constructor for the Buttons class.
- **Usage**: Initializes the button with specific properties and sets up the timeline and listeners.

### 2. `public Button createInputButtonToGrowStick()`
- **Description**: Creates an input button to trigger stick growth (not used in the provided code).
- **Returns**: The created button.
- **Usage**: Unused in the provided code.

### 3. `private void initialiseButtonListeners()`
- **Description**: Initializes listeners for mouse press, key press, and mouse release events.
- **Usage**: Used to handle user input and trigger actions accordingly.

### 4. `private void setupTimeline()`
- **Description**: Sets up the JavaFX Timeline for stick growth animation.
- **Usage**: Used to control the growth animation of the stick.

### 5. `private void growStick()`
- **Description**: Handles the logic to grow the stick during the animation.
- **Usage**: Invoked during the timeline animation to grow the stick.

## Additional Information

- The class represents the button used in the Stick Hero game to control stick growth and hero actions.
- Flags (`flag`, `flag2`, `flagtrns`, and `canFlip`) are used to control the flow of actions and transitions.
- The timeline is used for stick growth animation.
- Listeners are set up to handle mouse press, key press, and mouse release events.

## BandanaAnimation Class


## Class Fields

1. **`private Timeline tanim`**
   - **Description**: Represents the JavaFX Timeline for bandana animation.
   - **Usage**: Used to control the bandana animation in the Stick Hero game.

## Singleton Design Pattern

- The class follows the Singleton design pattern.
- The `getInstance()` method is provided for obtaining the single instance of the `BandanaAnimation` class.

## Methods

### 1. `public static BandanaAnimation getInstance()`
- **Description**: Returns the single instance of the `BandanaAnimation` class.
- **Returns**: The single instance of the class.
- **Usage**: Used to obtain the single instance of the class.

### 2. `private BandanaAnimation()`
- **Description**: Private constructor to enforce the Singleton pattern.
- **Usage**: Ensures that only one instance of the `BandanaAnimation` class is created.

### 3. `public void bandanaAnimation()`
- **Description**: Initializes and plays the bandana animation using JavaFX Timeline.
- **Usage**: Invoked to start the bandana animation in the Stick Hero game.

### 4. `public void run()`
- **Description**: Implementation of the `Runnable` interface to execute bandana animation in a separate thread.
- **Usage**: Invoked when the thread for bandana animation is started.

## Additional Information

- The class is responsible for managing the animation of the bandana in the Stick Hero game.
- Uses JavaFX Timeline to control the sequence of bandana visibility changes.
- Follows the Singleton design pattern to ensure only one instance exists.

## Gameover Class



## Class Fields

1. **`private static int c`**
   - **Description**: Represents a counter used to manage UI elements in the game over scene.
   - **Usage**: Used to determine if certain UI elements need to be removed or not.

2. **`private static Scene scene`**
   - **Description**: Represents the JavaFX scene for the game over screen.
   - **Usage**: Used to manage and manipulate the elements on the game over screen.

3. **`private static boolean reviveFlag`**
   - **Description**: Flag indicating whether the player chose to revive using cherries.
   - **Usage**: Used to determine if the player chose to revive and update the game accordingly.

4. **`private static ImageView deadImageView, restartImageView, reviveImageView, homeImageView, cherryImageView`**
   - **Description**: ImageViews for displaying various images on the game over screen.
   - **Usage**: Used to display images like dead character, restart button, revive button, home button, and cherry.

## Methods

### 1. `public Gameover(String s)`
- **Description**: Constructor for the Gameover class.
- **Parameters**:
  - `s`: The file path of the background image for the game over screen.
- **Usage**: Initializes the game over scene with the specified background image.

### 2. `public void gameover(String s)`
- **Description**: Initializes the UI elements and handles user interactions for the game over scene.
- **Parameters**:
  - `s`: The file path of the background image for the game over screen.
- **Usage**: Sets up and displays UI elements like images, buttons, and text on the game over screen. Handles user interactions for restarting the game, returning to the main menu, and reviving with cherries.

## Additional Information

- The class manages the game over screen in the Stick Hero game.
- Provides functionality for restarting the game, returning to the main menu, and reviving with cherries.
- Uses JavaFX for UI elements and transitions.


## Multithreading Class

## Overview

- **Package**: `com.example.stickhero`
- **Class Name**: `Multithreading`

## Class Fields

1. **`private static Timeline tanim`**
   - **Description**: Represents a JavaFX timeline for running animations.
   - **Usage**: Used to handle and control the leg animation during the hero's movement.

## Methods

### 1. `public static void runningAnimation()`
- **Description**: Initiates and runs the leg animation during the hero's movement.
- **Usage**: Utilizes JavaFX Timeline to alternate between the visible states of the hero's legs to create a running animation effect.

### 2. `@Override public void run()`
- **Description**: Overrides the `run` method from the `Thread` class.
- **Usage**: Calls the `runningAnimation` method to execute the leg animation in a separate thread.

## Additional Information

- The class `Multithreading` is responsible for managing and running the leg animation during the hero's movement in the Stick Hero game.
- Utilizes JavaFX Timeline for smooth animation transitions.
- Implements multithreading to run the animation in a separate thread.

##  SoundDesign Class


## Class Fields

1. **`private int ch`**
   - **Description**: Represents the sound type to be played.
   - **Usage**: Used to determine the type of sound to be played based on the provided code.

## Methods

### 1. `public void stickGrowSound()`
- **Description**: Plays the sound for the stick growth.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the stick growth sound.

### 2. `public void backgroundSound()`
- **Description**: Plays the background music.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the background music.

### 3. `public void stickFallSound()`
- **Description**: Plays the sound for the stick landing.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the stick landing sound.

### 4. `public void stickFallingSound()`
- **Description**: Plays the sound for the stick falling.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the stick falling sound.

### 5. `public void scoreSound()`
- **Description**: Plays the sound for scoring points.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the scoring sound.

### 6. `public void perfectLandSound()`
- **Description**: Plays the sound for a perfect landing.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the perfect landing sound.

### 7. `public void cherryCollectedSound()`
- **Description**: Plays the sound when a cherry is collected.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the cherry collection sound.

### 8. `public void deathSound()`
- **Description**: Plays the sound for the hero's death.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the death sound.

### 9. `public void flipSound()`
- **Description**: Plays the sound when the hero flips.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the flip sound.

### 10. `public void buttonSound()`
- **Description**: Plays the sound for button clicks.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the button click sound.

### 11. `public void bombSound()`
- **Description**: Plays the sound for a bomb explosion.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the bomb explosion sound.

### 12. `public void timeSound()`
- **Description**: Plays the sound for the timer.
- **Usage**: Utilizes JavaFX `MediaPlayer` to play the timer sound.

### 13. `@Override public void run()`
- **Description**: Overrides the `run` method from the `Runnable` interface.
- **Usage**: Switches based on the provided sound code and calls the corresponding sound method.

## Additional Information

- The class `SoundDesign` is responsible for managing and playing various sounds in the Stick Hero game.
- Utilizes JavaFX `MediaPlayer` to play different sounds based on the context.

