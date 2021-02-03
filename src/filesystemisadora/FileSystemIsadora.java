/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemisadora;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Isa
 */
public class FileSystemIsadora {

    private final static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Enter name ");
        String name = in.nextLine();
        System.out.println("Enter path ");
        String path = in.nextLine();
        System.out.println("Enter permissions(777 or 000) ");
        int per = in.nextInt();
        String content = "Ficheiro";

        List<Folder> createdFolder = new ArrayList<>();
        List<Folder> subFolders = new ArrayList<>();
        List<File> files = new ArrayList<>();

        LocalDateTime creationDate = LocalDateTime.now();
        File file = createFile(name, path, per, creationDate, content);

        Folder f1 = FileSystemIsadora.createFolderWithoutLists(name, path, per);
        createdFolder.add(f1);

        Folder f2 = createFolder(name, path, per, creationDate, subFolders, files);
        createdFolder.add(f2);

        createFileInsideFolder(f2, file);
        copyFolderToInsideFolder(f1, f2);
        moveFile(f1, file, f2);
        copyFile(f1, f2, file);
        moveFolder(createdFolder,f1,f2);
    }

    private static Folder createFolder(String name, String path, int per, LocalDateTime creationDate, List<Folder> subFolders, List<File> files) throws Exception {

        if (name.isEmpty()) {
            throw new Exception("Name is not valid");
        }
        return new Folder(name, per, path, creationDate, subFolders, files);

    }

    private static File createFile(String name, String path, int per, LocalDateTime creationDate, String content) throws Exception {

        if (name.isEmpty()) {
            throw new Exception("Name is not valid");
        }
        return new File(name, per, path, creationDate, content);

    }

    private static boolean createFileInsideFolder(Folder folder, File file) throws Exception {

        if (folder.validatePermission()) {
            if (folder.getPath().endsWith(file.getPath())) {
                folder.addFileToListofFiles(file);
                return true;
            }
        }
        return false;
    }

    private static Folder createFolderWithoutLists(String name, String path, int per) throws Exception {

        if (name.isEmpty()) {
            throw new Exception("Name is not valid");
        }
        return new Folder(name, path, per);

    }

    private static boolean copyFolderToInsideFolder(Folder inicialFolder, Folder finalFolder) throws Exception {

        return finalFolder.addSubFoldersToListofFolders(inicialFolder);
    }

    private static boolean copyFile(Folder inicialFolder, Folder finalFolder, File file) throws Exception {

        if (inicialFolder.getFile(file) == null) {
            throw new Exception("File not found in folder");
        }
        return finalFolder.addFileToListofFiles(file);
    }

    private static boolean moveFolder(List<Folder> listF, Folder inicialFolder, Folder finalFolder) throws Exception {

        for (int i = 0; i < listF.size(); i++) {
            if (!listF.get(i).equals(inicialFolder)) {
                throw new Exception("Folder nor found in the list");
            } else {
                listF.remove(i);
                return true;
            }
            
          
        }
  
        return finalFolder.addSubFoldersToListofFolders(inicialFolder);
    }

    private static boolean moveFile(Folder folder, File file, Folder finalFolder) throws Exception {

        if (!folder.validatePermission() && !file.validatePermission() && !finalFolder.validatePermission()) {
            throw new Exception("Permissions denied");
        }
        if (!folder.deleteFileFromListofFiles(file)) {
            throw new Exception("Error on deleting file from folder");
        }
        return finalFolder.addFileToListofFiles(file);
    }

}
