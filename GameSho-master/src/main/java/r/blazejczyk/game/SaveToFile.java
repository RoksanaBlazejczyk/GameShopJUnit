package r.blazejczyk.game;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class SaveToFile {

        /**

         Writes text to a file, overwriting any existing content.

         @param filePath Path to the file (e.g. "output.txt")

         @param content The text to write
         */
        public static void writeToFile(String filePath, String content) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content);
                System.out.println(" File saved successfully: " + filePath);
            } catch (IOException e) {
                System.err.println(" Error writing to file: " + e.getMessage());
            }
        }

        /**

         Appends text to an existing file (creates it if it doesn't exist).

         @param filePath Path to the file

         @param content The text to append
         */
        public static void appendToFile(String filePath, String content) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(content);
                writer.newLine();
            } catch (IOException e) {
                System.err.println(" Error appending to file: " + e.getMessage());
            }
        }

        /**

         Checks whether a file exists at the given path.

         @param filePath Path to the file

         @return true if file exists, false otherwise
         */
        public static boolean fileExists(String filePath) {
            return Files.exists(Paths.get(filePath));
        }
    }


