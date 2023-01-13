package com.hendisantika.service;

import com.hendisantika.model.CbaStatusReportDTO;
import com.hendisantika.model.CbaStatusReportFileDTO;
import com.hendisantika.model.FilesReceivedDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CbaStatusReportsService {

    public List<CbaStatusReportDTO> getCbaStatusReportDTOS() {
        List<CbaStatusReportDTO> cbaStatusReportDTOS = new ArrayList();
        CbaStatusReportDTO dto =CbaStatusReportDTO.builder()
                .rowId("1OPR")
                .sourceSystem("JDE")
                .sourceFilename("OPR_AP00000046_01000_121029125516.txt")
                .receiveTime("14/NOV/22 12:23:00")
                .deliveryTime("14/NOV/22 12:23:00")
                .fileDeliveryStatus("SUCCESS")
                .lastStatRepCode("(02) Processed")
                .lastStatRepTime("14/NOV/22 12:23:00").build();
        cbaStatusReportDTOS.add(dto);
        cbaStatusReportDTOS.add(dto.toBuilder().rowId("row2").sourceSystem("Peoplesoft")
                .sourceFilename("PSF_1329169_WKLREIM11270_2022-11-30-10-19-41_CBA020.ABA.gpg").build());
        cbaStatusReportDTOS.add(dto.toBuilder().rowId("row3").sourceSystem("Quantum")
                .sourceFilename("SGCBA0035823011.gpg").build());
        return cbaStatusReportDTOS;

    }

    public List<CbaStatusReportFileDTO> getReportFilesBySourceFilename(String sourceFilename) {
        List<CbaStatusReportFileDTO> cbaStatusReportFileDTOS = new ArrayList<>();

        CbaStatusReportFileDTO fileDTO = CbaStatusReportFileDTO.builder()
                .reportFilename("459560617931_100683143_301122123359_CBIZ")
                .creationDate("30-NOV-2022 12:33:59")
                .receiveDate("30-NOV-2022 12:35:27")
                .statusCode("(02) Processed")
                .statusReport(testdata.replaceAll("(\r\n|\n)", "<br />")).build();
        cbaStatusReportFileDTOS.add(fileDTO.toBuilder().rowId("row1").reportFilename(fileDTO.getReportFilename() + "3").statusCode("(02) Processed").build());
        cbaStatusReportFileDTOS.add(fileDTO.toBuilder().rowId("row2").reportFilename(fileDTO.getReportFilename() + "2").statusCode("(03) Awaiting Confirmation").build());
        cbaStatusReportFileDTOS.add(fileDTO.toBuilder().rowId("row3").reportFilename(fileDTO.getReportFilename() + "1").statusCode("(00) Received").build());

        return cbaStatusReportFileDTOS;
    }

    public List<FilesReceivedDto> getLatestFiveFilesReceived() {
        List<FilesReceivedDto> receivedDtos = new ArrayList<>();
        FilesReceivedDto receivedDto = FilesReceivedDto.builder()
                .rowId("row1")
                .jobLog(jobLog.replaceAll("(\r\n|\n)", "<br />"))
                .filelogId("1000000005085")
                .status("success")
                .dateReceived("30-NOV-2022 13:50:14")
                .timeSince("14 hours ago")
                .sourceFilename("West_CC_Account_20221130.txt").build();
        receivedDtos.add(receivedDto);
        receivedDtos.add(receivedDto.toBuilder().sourceFilename("West_HR_20221130.txt").filelogId("1000000005085").build());
        receivedDtos.add(receivedDto.toBuilder().sourceFilename("West_CC_BU_20221130.txt").filelogId("1000000005084").build());
        receivedDtos.add(receivedDto.toBuilder().sourceFilename("user202211301111.csv").filelogId("1000000005083").build());
        receivedDtos.add(receivedDto.toBuilder().sourceFilename("PPCBA0003323011.pgp").filelogId("1000000005082").build());
        return receivedDtos;
    }

    static String testdata = "CommBiz Status Message\n" +
            "\n" +
            "Client Name: Westfield(100683143)\n" +
            "Status Filename : 459560617931_100683143_301122123359_CBIZ.txt\n" +
            "Status Creation Date : 30/11/22\n" +
            "Status Creation Time : 12:33\n" +
            "\n" +
            "Transaction Reference : 459560617931\n" +
            "\n" +
            "Status: PROCESSED\n" +
            "\n" +
            "The transaction has been processed.\n" +
            "\n" +
            "Filename : PSF_1329169_WKLREIM11270_2022-11-30-10-19-41_CBA020.ABA\n" +
            "Description : WKLREIM11270\n" +
            "Value Date : 30/11/22\n" +
            "$Debits : 928019.35\n" +
            "$Credits : 928019.35\n" +
            "$Cheques : 0.00\n" +
            "#Payments : 46\n" +
            "#Advices : 0\n" +
            "#Records : 46\n" +
            "\n" +
            "\n" +
            "Thank you for using CommBiz.";



    static String jobLog = "11/24/22 2:57:36 PM           INFO      Start Date and Time: 11/24/22 2:57:36 PM\n" +
            "11/24/22 2:57:36 PM           INFO      Job Number: 1000000005085\n" +
            "11/24/22 2:57:36 PM           INFO      Project Name: /HRIS/Peoplesoft-Totara/Peoplesoft-IPAD-Torata\n" +
            "11/24/22 2:57:36 PM           INFO      Submitted By: MOrtiz@Scentregroup.com\n" +
            "11/24/22 2:57:36 PM           INFO      Submitted From: Administrator UI\n" +
            "11/24/22 2:57:36 PM           INFO      GoAnywhere 6.8.6 running on Linux 5.15.0-1018-gcp (amd64)\n" +
            "11/24/22 2:57:37 PM           INFO      ******************** Debug Mode ********************\n" +
            "11/24/22 2:57:37 PM           INFO      Executing project 'Peoplesoft-IPAD-Torata'\n" +
            "11/24/22 2:57:37 PM           INFO      Project location: /usr/local/HelpSystems/GoAnywhere/userdata/projects/HRIS/Peoplesoft-Totara/Peoplesoft-IPAD-Torata.xml\n" +
            "11/24/22 2:57:37 PM           INFO      Executing module 'Main'\n" +
            "11/24/22 2:57:39 PM           INFO      Executing task 'createWorkspace 1.0'\n" +
            "11/24/22 2:57:39 PM           INFO      Workspace directory for this job is set to '/usr/local/HelpSystems/GoAnywhere/userdata/workspace/1000000005085'.\n" +
            "11/24/22 2:57:39 PM           INFO      Finished task 'createWorkspace 1.0'\n" +
            "11/24/22 2:57:39 PM           INFO      Executing task 'copy 1.0 (Test Data Copy to SMB)'\n" +
            "11/24/22 2:57:39 PM           WARN      Overwriting the output file 'resource:share://Dev - Staging Peoplesoft IPAD/status.csv'.\n" +
            "11/24/22 2:57:39 PM           INFO      File '/mnt/dev/int/HRIS/Kronos/payslip/status.csv' (14 bytes) was successfully copied to 'resource:share://Dev - Staging Peoplesoft IPAD/status.csv' (14 bytes)\n" +
            "11/24/22 2:57:39 PM           INFO      1 files copied successfully\n" +
            "11/24/22 2:57:39 PM           INFO      Finished task 'copy 1.0 (Test Data Copy to SMB)'\n" +
            "11/24/22 2:57:39 PM           INFO      Executing task 'createFileList 1.0 (Checking if there are files inside the folder)'\n" +
            "11/24/22 2:57:39 PM           INFO      File List variable 'csv_files' was created containing 1 file(s)\n" +
            "11/24/22 2:57:39 PM           INFO      Finished task 'createFileList 1.0 (Checking if there are files inside the folder)'\n" +
            "11/24/22 2:57:39 PM           INFO      Entering if block labeled 'If there are files in the folder' as the condition \"${file_count > 0}\" was met\n" +
            "11/24/22 2:57:39 PM           INFO      Executing task 'copy 1.0 (Copying files to totara)'\n" +
            "11/24/22 2:57:41 PM           INFO      Output file 'resource:sftp://DEV - Staging Totara SFTP/upload/csv/ready/status.csv' already exists, changing the output file to 'resource:sftp://DEV - Staging Totara SFTP/upload/csv/ready/status 2.csv'.\n" +
            "11/24/22 2:57:43 PM           INFO      File 'resource:share://Dev - Staging Peoplesoft IPAD/status.csv' (14 bytes) was successfully copied to 'resource:sftp://DEV - Staging Totara SFTP/upload/csv/ready/status 2.csv' (14 bytes)\n" +
            "11/24/22 2:57:43 PM           INFO      1 files copied successfully\n" +
            "11/24/22 2:57:43 PM           INFO      Finished task 'copy 1.0 (Copying files to totara)'\n" +
            "11/24/22 2:57:43 PM           INFO      Entering if block labeled 'If all the files were copied' as the condition \"${copiedFiles == file_count}\" was met\n" +
            "11/24/22 2:57:43 PM           INFO      Executing task 'move 1.0 (Moving files to DONE)'\n" +
            "11/24/22 2:57:43 PM           INFO      File 'resource:share://Dev - Staging Peoplesoft IPAD/status.csv' was successfully moved to 'resource:share://Dev - Staging Peoplesoft IPAD/processed/11216279status.csv' (14 bytes)\n" +
            "11/24/22 2:57:43 PM           INFO      1 files were moved successfully\n" +
            "11/24/22 2:57:43 PM           INFO      Finished task 'move 1.0 (Moving files to DONE)'\n" +
            "11/24/22 2:57:43 PM           INFO      Executing task 'sendEmail 2.0 (Send Success Email)'\n" +
            "11/24/22 2:57:44 PM           INFO      Connecting to mail server: 10.38.139.47\n" +
            "11/24/22 2:57:44 PM           INFO      Opened the connection\n" +
            "11/24/22 2:57:44 PM           INFO      Message 'Project Peoplesoft-IPAD-Torata Success' was sent to 1 recipient(s)\n" +
            "11/24/22 2:57:44 PM           INFO      Message is delivered successfully\n" +
            "11/24/22 2:57:44 PM           INFO      The message has been delivered to the following 1 addresses: \n" +
            "                                        DEIntegration@Scentregroup.com\n" +
            "11/24/22 2:57:44 PM           INFO      Finished task 'sendEmail 2.0 (Send Success Email)'\n" +
            "11/24/22 2:57:44 PM           INFO      Finished if block labeled 'If all the files were copied'\n" +
            "11/24/22 2:57:44 PM           INFO      Finished if block labeled 'If there are files in the folder'\n" +
            "11/24/22 2:57:44 PM           INFO      Executing task 'deleteWorkspace 1.0'\n" +
            "11/24/22 2:57:44 PM           INFO      Workspace directory '/usr/local/HelpSystems/GoAnywhere/userdata/workspace/1000000005085' was deleted successfully\n" +
            "11/24/22 2:57:44 PM           INFO      Finished task 'deleteWorkspace 1.0'\n" +
            "11/24/22 2:57:44 PM           INFO      Finished module 'Main'\n" +
            "11/24/22 2:57:44 PM           INFO      Finished project 'Peoplesoft-IPAD-Torata'\n" +
            "11/24/22 2:57:44 PM           INFO      Closed the connection\n" +
            "11/24/22 2:57:44 PM           INFO      End Date and Time: 11/24/22 2:57:44 PM\n";
}
