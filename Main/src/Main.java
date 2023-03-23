import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(increment("1.1.1"));

    }

    public static String increment(String version){
        //initialize result string
        String result = "";

        //split the version parameter string based on "." and index into array
        String[] versionValues = version.split("\\.");

        //go to last index and increment by 1.
        versionValues[versionValues.length-1] = String.valueOf(Integer.parseInt(versionValues[versionValues.length-1])+1);

        //add all values of array into result string
        for(String a: versionValues){
            result += a;
        }

        //add the "." between each number
        result = result.replace("",".");

        //remove the first and last characters which are extra ".".
        result = result.substring(1,result.length()-1);

        return result;
    }
    public static void increment(String version, int index){

    }

}