package com.hendisantika.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "cbastatus_reports")
public class CbaStatusReportEntity {
    @Id
    Long rowId;
    String sourceSystem;
    String sourceFilename;
    String receiveTime;
    String deliveryTime;
    String fileDeliveryStatus;
    String lastStatRepCode;
    String lastStatRepTime;
}
