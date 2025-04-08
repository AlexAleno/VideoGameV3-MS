package com.champsoft.downloadmanagement.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadRepository extends JpaRepository<DownloadId, String> {
}
