package org.thoughtworks.blink;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

class PairStore {
    private static final String propertiesFile = "paris.properties";

    static void store(Pairs pairs) {
        Properties properties = new Properties();
        List<Member> allMembers = Arrays.stream(properties.getProperty("allMembers").split(","))
                .map(Member::new)
                .collect(Collectors.toList());

        try (Writer fileWriter = new FileWriter("paris.properties")) {
            properties.setProperty("pairs", pairs.toString(allMembers));
            properties.store(fileWriter, "pair information");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Pairs getPairs() {
        Properties properties = new Properties();
        try (InputStream inputStream = PairStore.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] allMembers = properties.getProperty("allMembers").split(",");
        List<Pair> pairList = Arrays.stream(properties.getProperty("pairs").split(","))
                .map(pairString -> Pair.createBy(pairString, allMembers))
                .collect(Collectors.toList());
        return new Pairs(pairList);
    }
}
