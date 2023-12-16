package exercise;

// BEGIN
public class App {
    public static String getForwardedVariables(String vars) {
        StringBuilder result = new StringBuilder();
        String[] arr = vars.split("\n");
        StringBuilder temp = new StringBuilder();

        for (String line : arr) {
            if (line.startsWith("environment") && line.contains("X_FORWARDED")) {
                String[] mapByComma = line.replace("environment=", "")
                        .replace("\"", "")
                        .split(",");

                for (String mp : mapByComma) {
                    if (mp.contains("X_FORWARDED")) {
                        temp.append(mp);
                        temp.append(",");
                    }
                }

                String[] map = temp.substring(0, temp.length() - 1)
                        .replace("X_FORWARDED_", "")
                        .split(",");

                for (String str : map) {
                    String temp1 = str.substring(0, str.indexOf("="));
                    String temp2 = str.substring(str.indexOf("="));

                    result.append(temp1);
                    result.append(temp2);
                    result.append(",");
                }
            }
            temp.setLength(0);
        }
        return result.substring(0, result.length() - 1);
    }
}
//END
