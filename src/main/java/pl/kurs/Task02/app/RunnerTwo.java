package pl.kurs.Task02.app;

import pl.kurs.Task02.services.TaskTwoService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static pl.kurs.Task02.services.TaskTwoService.findJavaFiles;
import static pl.kurs.Task02.services.TaskTwoService.printSummary;

public class RunnerTwo {
    public static void main(String[] args) {

        List<File> javaFiles = new ArrayList<>();
        File path = new File("C:\\Users\\MATEUSZ\\IdeaProjects");
        printSummary(path, javaFiles);

//        MONDAY=15
//        TUESDAY=51
//        WEDNESDAY=30
//        THURSDAY=1048
//        FRIDAY=42
//        SATURDAY=45
//        SUNDAY=17



    }




}
