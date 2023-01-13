package com.hendisantika.model;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class FilesReceivedDto {
    String rowId;
    String filelogId;
    String jobLog;
    String status;
    String dateReceived;
    String timeSince;
    String sourceFilename;
}
