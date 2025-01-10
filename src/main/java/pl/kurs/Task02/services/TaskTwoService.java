package pl.kurs.Task02.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskTwoService {

    public TaskTwoService() {
    }

    public static void findJavaFiles(File directory, List<File> list) {
        File[] array = directory.listFiles();

        if (array != null) {
            for (File file : array) {
                if (file.isDirectory()) {
                    findJavaFiles(file, list);
                } else if (file.getName().endsWith(".java")) {
                    list.add(file);
                }
            }
        }
    }

    private static DayOfWeek getDayOfWeekFromFile(File file) {
        DayOfWeek day = null;
        try {
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            LocalDate fileDate = attributes.creationTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            day = fileDate.getDayOfWeek();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static void printSummary(File directory, List<File> list) {
        findJavaFiles(directory, list);

        //vers.1
//        int[] counters = new int[7];
//
//        for (File file : list) {
//            switch (getDayOfWeekFromFile(file)) {
//                case MONDAY -> counters[0]++;
//                case TUESDAY -> counters[1]++;
//                case WEDNESDAY -> counters[2]++;
//                case THURSDAY -> counters[3]++;
//                case FRIDAY -> counters[4]++;
//                case SATURDAY -> counters[5]++;
//                case SUNDAY -> counters[6]++;
//            }
//        }
//        DayOfWeek[] values = DayOfWeek.values();
//        for (int i = 0; i < counters.length; i++) {
//            System.out.println(values[i] + "=" + counters[i]);
//        }
        //vers 2
        list.stream()
                .map(TaskTwoService::getDayOfWeekFromFile)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

    }
}





