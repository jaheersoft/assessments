package org.retailfeeds.web.model;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "fileMetas")
public class FileMeta {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`fileName`")
    private String fileName;

    @Column(name = "`filePath`")
    private String filePath;

    @Column(name = "`version`")
    private String version;
    
    @Column(name = "`processed`")
    private boolean processed;

    public FileMeta() {}
    
    public FileMeta(String fileName, String filePath, String version,boolean processed) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.version = version;
        this.processed = processed;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
}
