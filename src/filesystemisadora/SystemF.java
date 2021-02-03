/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemisadora;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Isa
 */
public abstract class SystemF {


    private String name;
    private int permissions;
    private String path;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private LocalDateTime lastAccessDate;

    private static final String DEFAULT_NAME = "sys";
    private static final String DEFAULT_PATH = "C:\\DefaultSys";

    /**
     *
     * @param name
     * @param permissions
     * @param path
     * @param creationDate
     */
    public SystemF(String name, int permissions, String path, LocalDateTime creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = creationDate;
        this.lastAccessDate = creationDate;
        this.permissions = permissions;
        this.path = path;
    }

    /**
     *
     * @param name
     * @param permissions
     * @param path
     */
    public SystemF(String name, int permissions,String path) {
        this.name = name;
        this.permissions = permissions;
        this.creationDate = creationDate;
        this.modificationDate = creationDate;
        this.lastAccessDate = creationDate;
           this.path = path;

    }

    /**
     *
     * @param name
     */
    public SystemF(String name) {
        this.name = name;
        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDateTime.now();
        this.lastAccessDate = LocalDateTime.now();
        this.permissions = 777;
        this.path = DEFAULT_PATH;
    }

    /**
     *
     */
    public SystemF() {
        this.name = DEFAULT_NAME;
        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDateTime.now();
        this.lastAccessDate = LocalDateTime.now();
        this.permissions = 777;
        this.path = DEFAULT_PATH;

    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @return last modification date
     */
    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    /**
     *
     * @return last accessed date
     */
    public LocalDateTime getLastAccessDate() {
        return lastAccessDate;
    }

    /**
     *
     * @return permissions
     */
    public int getPermissions() {
        return permissions;
    }

    /**
     *
     * @return path of file or folder
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @param name
     * @return true if alteration is possible, false if it isn't
     */
    public boolean setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            modificationDate();
            return true;
        }
        return false;
    }

    /**
     *
     * @param creationDate 
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @param modificationDate
     */
    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     *
     */
    public void modificationDate() {
        this.modificationDate = LocalDateTime.now();
    }

    /**
     *
     * @param lastAccessDate
     */
    public void setLastAccessDate(LocalDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    /**
     *
     * @param lastAccessDate
     */
    public void lastAccessDate(LocalDateTime lastAccessDate) {
        this.lastAccessDate = LocalDateTime.now();
    }

    /**
     *
     * @param permissions
     */
    public void setPermissions(int permissions) {
        this.permissions = permissions;
        modificationDate();
    }

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Permission 777- considered to simplify
     * @return true if is as the needed permisisons
     */
    public boolean validatePermission() {
        if (this.permissions != 777) {
            return false;
        }
        return true;
    }

}
