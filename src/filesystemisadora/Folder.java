/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemisadora;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Isa
 */
public class Folder extends SystemF {
    
    private List<Folder> subFolders;
    private List<File> files;
    
    /**
     *
     * @param name
     * @param permissions
     * @param path
     * @param creationDate
     * @param subFolders
     * @param files
     */
    public Folder(String name, int permissions, String path, LocalDateTime creationDate,List<Folder> subFolders, List<File> files) {
        super(name, permissions, path, creationDate);
        this.subFolders = subFolders;
        this.files = files;
    }

    /**
     *
     * @param name
     * @param permissions
     * @param path
     * @param creationDate
     */
    public Folder(String name, int permissions, String path, LocalDateTime creationDate) {
        super(name, permissions, path, creationDate);
        this.subFolders = new ArrayList<>();
        this.files = new ArrayList<>();
    }
    
    /**
     *
     * @param name
     * @param path
     * @param permissions
     */
    public Folder(String name, String path, int permissions) {
        super(name, permissions, path);
        this.subFolders = new ArrayList<>();
        this.files = new ArrayList<>();
    }
    
    /**
     *
     * @param name
     */
    public Folder(String name) {
        super(name);
        this.subFolders = new ArrayList<>();
        this.files = new ArrayList<>();
    }
    
    /**
     *
     * @return  list of subfolders inside a folder
     */
    public List<Folder> getSubFolders() {
        return subFolders;
    }
    
    /**
     *
     * @return list of files inside a folder
     */
    public List<File> getFiles() {
        return files;
    }
    
    /**
     *
     * @param file
     * @return file
     */
    public File getFile(File file) {
        for (int i = 0; i < getFiles().size(); i++) {
            if (file == getFiles().get(i)) {
                return file;
            }
        }
        return null;
    }
    
    /**
     *
     * @param subFolders
     */
    public void setSubFolders(List<Folder> subFolders) {
        this.subFolders = subFolders;
    }
    
    /**
     *
     * @param files
     */
    public void setFiles(List<File> files) {
        this.files = files;
    }
    
    /**
     * changes the modification date
     * @param file
     * @return true if the file was added, false if it isn't
     */
    public boolean addFileToListofFiles(File file) {
        //garante que file está a ser criado dentro da pasta onde estamos 
        if (this.getPath().endsWith(file.getPath())) {
            this.files.add(file);
            super.modificationDate();
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param folder
     * @return true if the folder was added, false if it isn't
     */
    public boolean addSubFoldersToListofFolders(Folder folder) {
        if (!super.validatePermission()) {
            return false;
        }
        if (this.getPath().endsWith(folder.getPath())) {
            
            this.subFolders.add(folder);
            
            super.modificationDate();
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param folder
     * @return rue if the folder was deleted false if it isn't
     */
    public boolean deleteSubFoldersFromListofFolders(Folder folder) {
        if (!super.validatePermission()) {
            return false;
        }
        if (this.getPath().endsWith(folder.getPath())) {
            
            if (!this.subFolders.remove(folder)) {
                return false;
            } else {
                
                super.modificationDate();
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param files
     * @return true if file was deleted,false if it isn't
     */
    public boolean deleteFileFromListofFiles(File files) {
        if (!super.validatePermission()) {
            return false;
        }
        if (this.getPath().endsWith(files.getPath())) {
            
            if (!this.files.remove(files)) {
                return false;
            } else {
                
                super.modificationDate();
                return true;
            }
        }
        return false;
    }
    
}
