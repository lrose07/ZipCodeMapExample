import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demonstration for Map workshop.
 *
 * Lauren Rose
 * Equality in Computing Club
 * Radford University
 * 18 Feb 2020
 *
 * License: CC0 1.0 Universal
 *
 * In this file we need to do two things:
 *  1) Add the zip codes to the map
 *  2) Find the town when the zip code is entered
 */

class ZipCodeMapExample {

    ZipCodeMapExample() {
        loadMap();
        run();
    }

    private void run() {
        getUserInput();
        while (runProgram) {
            System.out.println(lookupTown());
            getUserInput();
        }
    }

    /**
     * Gets the user input from the terminal
     */
    private void getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a zip code to lookup: ");
        zipCode = scan.nextLine();
        if (zipCode.equalsIgnoreCase(quitCommand)) {
            runProgram = false;
            scan.close();
        }
    }

    /**
     * Looks up the given zip code to retrieve the matching town
     * @return matching town
     */
    private String lookupTown() {
        // TODO: Your code goes here

        return "Not found";
    }

    /**
     * Inserts zip codes into Map structure
     */
    private void loadMap() {
        townZipCodeMap = new HashMap<>();

        String currentTown;
        String currentCode;

        File file = new File("zipcodes.txt");
        try (Scanner fileScan = new Scanner(file)) {
            while (fileScan.hasNextLine()) {
                String currentEntry = fileScan.nextLine();
                currentCode = currentEntry.substring(0, 5);
                currentTown = currentEntry.substring(7);
                // TODO: what line goes here?

            }
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found");
        }
    }

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private String zipCode;
    private HashMap<String, String> townZipCodeMap;
    private boolean runProgram = true;
    private final String quitCommand = "quit";
}
