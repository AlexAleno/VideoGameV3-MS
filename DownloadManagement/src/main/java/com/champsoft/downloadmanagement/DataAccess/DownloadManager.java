package com.champsoft.downloadmanagement.DataAccess;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadManager {
    @EmbeddedId
    private DownloadId downloadId;
    private String downloadStatus;
}
