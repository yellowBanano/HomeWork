package Lesson_18;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class TimeActivityReport implements Report {
    private static final int MINUTES_IN_HOUR = 60;
    private File source;

    public TimeActivityReport(File source) {
        this.source = source;
    }

    @Override
    public void generateReport() {
        String originalText = new TextReader().read(source);
        String updatedText = computeActivityOfDays(originalText);
        ReportWriter reportWriter = new TextReportWriter();
        reportWriter.writeReport(updatedText, "Report of the time activity");
    }

    private String computeActivityOfDays(String text) {
        Pattern pattern = Pattern.compile("(\\d?\\d):(\\d{2})(\\D+)");
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder();
        Time startTime, endTime = null;
        String activity = "";
        int timeDifference;
        int lecturesTime = 0;
        int exercisesTime = 0;
        int breaksTime = 0;

        if (matcher.find()) {
            endTime = new Time(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
            activity = matcher.group(3);
        }
        while (matcher.find()) {
            startTime = endTime;
            endTime = new Time(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
            if (isEndOfDay(activity) || matcher.hitEnd()) {
                int totalActivitiesTime = lecturesTime + exercisesTime + breaksTime;
                stringBuilder
                        .append("Лекции: " + lecturesTime + " минут " + getPercentOfTotalTime(lecturesTime, totalActivitiesTime) + "\n")
                        .append("Решения: " + exercisesTime + " минут " + getPercentOfTotalTime(exercisesTime, totalActivitiesTime) + "\n")
                        .append("Перерыв: " + breaksTime + " минут " + getPercentOfTotalTime(breaksTime, totalActivitiesTime) + "\n")
                        .append("\n");
                lecturesTime = exercisesTime = breaksTime = 0;
            } else if (isBreak(activity)) {
                timeDifference = calculateTimeDifferenceInMinutes(startTime, endTime);
                breaksTime += timeDifference;
            } else if (isExercise(activity)) {
                timeDifference = calculateTimeDifferenceInMinutes(startTime, endTime);
                exercisesTime += timeDifference;
            } else {
                timeDifference = calculateTimeDifferenceInMinutes(startTime, endTime);
                lecturesTime += timeDifference;
            }
            activity = matcher.group(3);
        }
        return stringBuilder.toString();
    }

    private static String getPercentOfTotalTime(double lecturesTime, double totalActivitiesTime) {
        return round(lecturesTime / totalActivitiesTime * 100) + "%";
    }

    private static int calculateTimeDifferenceInMinutes(Time first, Time second) {
        return abs((first.getHours() - second.getHours()) * MINUTES_IN_HOUR
                + first.getMinutes() - second.getMinutes());
    }

    private static boolean isExercise(String activity) {
        return activity.toLowerCase().contains("решения")
                || activity.toLowerCase().contains("упражнения");
    }

    private static boolean isBreak(String activity) {
        return activity.toLowerCase().contains("перерыв");
    }

    private static boolean isEndOfDay(String activity) {
        return activity.contains("Конец");
    }
}
