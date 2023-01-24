# A1 - Piraten Karpen

  * Author: < You name here >
  * Email: < Your email here >

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

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < The feature is tested to ensure that it functions and runs as expected.
   * There are multiple test runs and all unwanted errors are fixed before the feature
   * is declared to be finished.>

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  S | 01/01/23 |  |
| x   | F02 | Roll eight dices  |  B (F01) |   |
| x   | F03 | Count number of gold coins and diamonds rolled  |  P  |   |
| x   | F04 | Compute the score | P | |
| x   | F05 | Player randomly chooses dice to keep on their turn | B (F02) | | 
| x   | F06 | Player re-rolls the dice | B (F04) | |
| x   | F07 | End turn when three skulls are rolled | B (F04) | |
| x   | F08 | Play 42 games | B (F04) | |
| x   | F09 | Display percentage of wins for each player | B (F04) | |
| ... | ... | ... |

