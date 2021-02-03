/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemisadora;

import java.time.LocalDateTime;
import java.util.Objects;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author Isa
 */
public class File extends SystemF {

    private String content;

    /**
     *
     * @param name
     * @param permissions
     * @param path
     * @param creationDate
     * @param content
     */
    public File(String name, int permissions, String path, LocalDateTime creationDate,String content) {
        super(name, permissions, path, creationDate);
        this.content=content;

    }

  
    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
        setModificationDate(LocalDateTime.now());
    }

    /**
     *
     * @return content of file
     */
    public String getContent() {
          setLastAccessDate(LocalDateTime.now());
        return content;
      
    }

    /**
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     *
     * @param obj
     * @return true if object is equal, false if it isn't
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final File other = (File) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }
    

}
