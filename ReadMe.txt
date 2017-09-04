In the zip, the executable TurningMovingImage-jar-with-dependencies.jar , TurningMovingImage folder and ReadMe.txt file  is provided.
<---Execution of Jar--> 
1. The Jar with Dependencies is executable, clicking on it, displays the Frame with panels. This UI has an Icon which moves and Turns with the commands.
2. Go to the path where the jar is and command is java -jar TurningMovingImage-jar-with-dependencies.jar the Frame is displayed and you provide commands on the command line
3. Here you would have to provide the commands via Command Line. 
   Commands are 'L' for Turn Left  'R' for Turn Right 'F' for move forward 'B' for move backward' and exit' to Exit and close .
<--Build the Project in IDE--->
   Go to the path of TurningMovingImage folder   and  build command(eclipse) is, mvn clean install eclipse:clean eclipse:eclipse
   Unit Tests also run with it you can skip them if you want using -DskipTests at the end of build command.Now import the project into IDE(as per build command above mentioned eclipse).
   You can also use after building,  mvn package. Build provides the jar with dependencies in the Target  Folder which is executable.
 <--Other Points about the TurningMovingImage--->  
1. The provided Turning Robot object extending the Robot.
2. Turning Robot move directions overrides the Robot methods, example: MoveNorth() overrides  
From the Robot MoveNorth(); this was done because the 0, 0 coordinates are are At Lower Left, Normally coordinates are at Upper Left  the Grid Panel has been rotated 270  
Degrees to achieve the Lower Left. Thereby TurningRobot methods have to override the Robot  
move methods.
3. As part of extensibility Turning Robot has Robot Image which can actually move in  
Relative to Turning Robot's X and Y position. Example one increment of X position can move  
The Turning Robot Image 10 pixels this is set by RobotImage variable.  
imageRelativeGapXPosition.RobotImage Zero argument Constructor sets this GAP to 1 that means  
It is same as Turning Robot's X and Y position.
4. Another extensibility is that VisualGrid class takes array of Robots, so that it can accommodate  
More than One Robot moving.
5. Another Extensibility is that Turning Robot can now move backwards .So any other movement
Can be provided in the movement enum and added in the switch case of turning robot   
movementDirection method and add Command usage in Turning RobotHandler. Turning Robot  
Orientation enums has the Turn that Image has to make again it is extensible by providing in  
The switch case of Turning Robots turnOrientation method add Command usage in Turning  
RobotHandler.
6. Turning RobotHandler handles the movement of the image based on the commands and the Usage of Commands.
7. Logging is done help with you with info.
8. Provided 400 as Maximum and Not Less than 0 for the Image X position and Y position. This can be changed by amending the constants.
------------------------------------------------------------------
