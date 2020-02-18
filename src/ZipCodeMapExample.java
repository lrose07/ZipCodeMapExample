import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * In this file we need to do two things:
 *  1) Add the zip codes to the map
 *  2) Find the town when the zip code is entered
 */

class ZipCodeMapExample {

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private String zipCode;
    private HashMap<String, String> townZipCodeMap;

    ZipCodeMapExample() {
        loadMap();
        getUserInput();
        System.out.println(lookupTown());
    }

    private void getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a zip code to lookup: ");
        zipCode = scan.nextLine();
        scan.close();
    }

    private String lookupTown() {
        // Your code goes here

        return "Not found";
    }

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
                // what line goes here?

            }
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found");
        }
    }
}
