import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(increment("1.1.1", 2));
        System.out.println(increment("1.5.17", 1));
        System.out.println(increment("2.1.0"));
        System.out.println(increment("2.1.0", 3));

    }

    /**
     * This fuction increments the rightmost value in the version.
     *
     * @param version
     * @return String of incremented version
     */
    public static String increment(String version) {
        //initialize result string
        String result = "";

        //split the version parameter string based on "." and index into array
        String[] versionValues = version.split("\\.");

        //go to last index and increment by 1.
        versionValues[versionValues.length - 1] = String.valueOf(Integer.parseInt(versionValues[versionValues.length - 1]) + 1);

        //turn array into formatted String
        result = stringMaker(versionValues);

        return result;
    }

    /**
     * This increment function takes the current version and increments the number in the index and sets
     * and succeeding values to 0.
     *
     * @param version
     * @param index
     * @return String of new incremented version
     */
    public static String increment(String version, int index) {
        //initialize result string
        String result = "";
        int trueIndex = index - 1;
        //split the version parameter string based on "." and index into array
        String[] versionValues = version.split("\\.");

        //go to index and increment by 1.
        versionValues[trueIndex] = String.valueOf(Integer.parseInt(versionValues[trueIndex]) + 1);

        //set values after index to 0.
        for (int i = 0; i < versionValues.length; i++) {
            if (i > trueIndex) {
                versionValues[i] = "0";
            }
        }

        //turn array into formatted String
        result = stringMaker(versionValues);

        return result;

    }

    /**
     * stringMaker function takes in a array of Strings and turns it into a String
     * with "." between each character.
     *
     * @param versionValues
     * @return String result of combined version
     */
    public static String stringMaker(String[] versionValues) {

        String result = "";

        //add all values of array into result string
        for (String a : versionValues) {
            result += a;
        }

        //add the "." between each number
        result = result.replace("", ".");

        //remove the first and last characters which are extra ".".
        result = result.substring(1, result.length() - 1);

        return result;

    }
}