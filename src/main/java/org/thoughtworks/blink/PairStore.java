package org.thoughtworks.blink;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

class PairStore {
    private static final String propertiesFile = "pairs.properties";

    static void store(Pairs pairs) {
        Properties properties = loadFile();
        List<Member> allMembers = Arrays.stream(properties.getProperty("allMembers").split(","))
                .map(Member::new)
                .collect(Collectors.toList());

        try (Writer fileWriter = new FileWriter(propertiesFile)) {
            properties.setProperty("pairs", pairs.toString(allMembers));
            properties.store(fileWriter, "pair information");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Pairs getPairs() {
        Properties properties = loadFile();

        String[] allMembers = properties.getProperty("allMembers").split(",");
        List<Pair> pairList = Arrays.stream(properties.getProperty("pairs").split(","))
                .map(pairString -> Pair.createBy(pairString, allMembers))
                .collect(Collectors.toList());
        return new Pairs(pairList);
    }

    private static Properties loadFile() {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(propertiesFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
