# A1 - Piraten Karpen

  * Author: < Mithun Paramathasan >
  * Email: < paramatm@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To activate trace mode in the program when using log4j2, you must configure log4j2 to log trace info
    * After adding the dependencies, in the log4j2.xml file, you must set the root level to level trace
    * Then, the log messages from the loggers will be at the trace level or higher

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < The feature is tested to ensure that it functions and runs as expected.
   * There are multiple test runs and all unwanted errors are fixed before the feature is declared to be finished.>

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice | D | 01/23/23 | 01/23/23 |
| x   | F02 | Roll eight dices  | D | 01/24/23 | 01/24/23 |
| x   | F03 | Count number of gold coins and diamonds rolled  | D | 01/24/23 | 01/24/23 |
| x   | F04 | Compute the score for one turn | D | 01/24/23 | 01/24/23 |
| x   | F05 | Player re-rolls the dice | D | 01/24/23 | 01/24/23 |
| x   | F06 | End turn when three skulls are rolled | D | 01/24/23 | 01/24/23 |
| x   | F07 | Randomly choose to re-roll or end turn | D | 01/25/23 | 01/25/23 |
| x   | F08 | Player randomly chooses dice to keep on their turn | D | 01/25/23 | 01/25/23 |
| x   | F09 | Compute final score and display winner of game | D | 01/25/23 | 01/25/23 |
| x   | F10 | Play 42 games | D | 01/25/23 | 01/25/23 |
| x   | F11 | Display percentage of wins for each player | D | 01/25/23 | 01/25/23 |
|     | F12 | Look for dice combinations on each roll | D | 01/28/23 | 01/28/23 |
|     | F13 | Add combo points to turn score | D | 01/28/23 | 01/28/23 |
|     | F14 | New strategy for player to re-roll or end turn to maximize combos  | D | 01/28/23 | 01/28/23 |
|     | F15 | Set up card deck and drawing card from deck  | D | 01/28/23 | 01/28/23 |
|     | F16 | Add the unique sea battle cards to the deck  | D | 01/29/23 | 01/29/23 |
| ... | ... | ... |

