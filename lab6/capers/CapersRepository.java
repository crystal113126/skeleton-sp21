package capers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static capers.Utils.*;

/** A repository for Capers 
 * @author JJ
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = join(CWD, "test_capers"); // TODO Hint: look at the `join`
    static {
        if (!CAPERS_FOLDER.exists())
            CAPERS_FOLDER.mkdir();
    }
                                                                  //      function in Utils
    static final File fileF = join(CAPERS_FOLDER ,".capers");
    static File storyF = join(fileF,"story.txt");

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {

        if (!fileF.exists())
            fileF.mkdir();
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text)  {

        if (!storyF.exists())
        {
            try {
                storyF.createNewFile();  // file created here
                //System.out.println("file != null");
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            writeContents(storyF, text);

        }
        else {
            writeContents(storyF, readContentsAsString(storyF), "\n", text);
            // }// keep the previous context in to the same file
        }

        System.out.println(readContentsAsString(storyF));
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog dog = new Dog(name, breed, age);
        dog.saveDog();
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
    }
}
