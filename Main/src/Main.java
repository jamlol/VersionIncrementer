
public class Main {
    public static void main(String[] args) {

        System.out.println(increment("1.1.1",2));
        System.out.println(increment("1.5.17", 1));
        System.out.println(increment("2.1.0"));
        System.out.println(increment("2.1.0", 3));
        System.out.println(increment("2.1.0", 4));
        System.out.println(increment("2.1.0", -1));
        System.out.println(increment("1.17.1"));

    }

    /**
     * This function increments the rightmost value in the version.
     *
     * @param version String of version
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
     * @param version String of version input
     * @param index int index
     * @return String of new incremented version
     * @throws ArrayIndexOutOfBoundsException throws errors when index parameter is invalid
     */
    public static String increment(String version, int index) {
        //initialize result string
        String result = "";
        int trueIndex = index - 1;

        try {
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
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("invalid input for index");
        }

        return result;

    }

    /**
     * stringMaker function takes in an array of Strings and turns it into a String
     * with "." between each character. Helper function for the increment functions.
     *
     * @param versionValues String array
     * @return String result of combined version
     */
    public static String stringMaker(String[] versionValues) {

        String result = "";

        //add all values of array into result string and insert "." between each number
        int counter =0;
        for (String a :(versionValues)) {

            result += a;
            counter+=1;
            if(counter%1==0){
                result+= ".";
            }
        }


        //remove the last characters which are extra ".".
        result = result.substring(0, result.length() - 1);

        return result;

    }
}