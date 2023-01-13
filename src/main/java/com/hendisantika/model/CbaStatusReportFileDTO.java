package com.hendisantika.model;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class CbaStatusReportFileDTO {
    String rowId;
    String reportFilename;
    String creationDate;
    String receiveDate;
    String statusCode;
    String statusReport;
}
