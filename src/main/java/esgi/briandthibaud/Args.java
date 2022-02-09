package esgi.briandthibaud;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Args {
    private String args;
    private String schema;

    private String sInt;
    private String sBoolean;
    private String sString;

    HashMap<Character, Integer> mapInt;
    HashMap<Character, Boolean> mapBoolean;
    HashMap<Character, String> mapString;


    public Args(String s, String[] args) {
        this.args = args.toString();
        this.schema = s;
        mapBoolean = new HashMap<>();
        mapInt = new HashMap<>();
        mapString = new HashMap<>();
        parseSchema();
    }

    public boolean getBoolean(char d) {

        return mapBoolean.get(d);
    }

    public int getInt(char p) {
        return mapInt.get(p);
    }

    public String getString(char h) {
        return mapString.get(h);
    }

    private void parseSchema(){
        Pattern patternBoolean = Pattern.compile("[*|#]", Pattern.CASE_INSENSITIVE);
        Pattern patternInt = Pattern.compile("[#]", Pattern.CASE_INSENSITIVE);
        Pattern patternString = Pattern.compile("[*]", Pattern.CASE_INSENSITIVE);

        String[] split = this.schema.split(",");
        String[] listArgs = this.args.split("-");

        int j = split.length;

        for(int i = 0; i < j; i++){
            if (patternInt.matcher(split[i]).find()){
                mapInt.put(split[i].charAt(0), Integer.valueOf(listArgs[i].substring(3, listArgs[i].length()-1)));
            }else if (patternString.matcher(split[i]).find()){
                mapString.put(split[i].charAt(0), listArgs[i].substring(3, listArgs[i].length()-1));
            }
        }
    }
}
