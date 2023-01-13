package com.hendisantika.model;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class CbaStatusReportDTO {
    String rowId;
    String sourceSystem;
    String sourceFilename;
    String receiveTime;
    String deliveryTime;
    String fileDeliveryStatus;
    String lastStatRepCode;
    String lastStatRepTime;
}
