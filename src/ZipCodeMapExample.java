import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//        if (townZipCodeMap.containsKey(zipCode)) {
//            return townZipCodeMap.get(zipCode);
//        }
//        return "Not found";
        return townZipCodeMap.getOrDefault(zipCode, "Not found");
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
                townZipCodeMap.put(currentCode, currentTown);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found");
        }
    }
}
