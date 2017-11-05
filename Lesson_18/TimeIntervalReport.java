package Lesson_18;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeIntervalReport implements Report {
    private File source;

    public TimeIntervalReport(File source) {
        this.source = source;
    }

    @Override
    public void generateReport() {
        String originalText = new TextReader().read(source);
        String updatedText = timeConvertToTimeIntervalInText(originalText);
        ReportWriter reportWriter = new TextReportWriter();
        reportWriter.writeReport(updatedText, "Report in the form of time intervals");
    }

    private String timeConvertToTimeIntervalInText(String text) {
        Pattern pattern = Pattern.compile("(\\d?\\d:\\d{2})(\\D+)");
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder();
        String startTime, between = "", endTime = "";

        if (matcher.find()) {
            endTime = matcher.group(1);
            between = matcher.group(2);
        }
        while (matcher.find()) {
            startTime = endTime;
            endTime = matcher.group(1);
            stringBuilder
                    .append(startTime)
                    .append(between.contains("Конец") ? (between) : ("-" + endTime + between));
            between = matcher.group(2);
            if (matcher.hitEnd()) {
                stringBuilder
                        .append(startTime)
                        .append(between);
            }
        }
        return stringBuilder.toString();
    }
}
