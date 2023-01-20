package com.hendisantika.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "file_executions")
public class FilesReceivedEntity {
    @Id
    String rowId;
    String filelogId;
    String jobLog;
    String status;
    String dateReceived;
    String timeSince;
    String sourceFilename;
}
