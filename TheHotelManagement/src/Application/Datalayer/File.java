/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Datalayer;

/**
 *
 * @author andymai
 */
public abstract class File{
    protected String fileName;
    protected String path;

    public File(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public File() {
        this.fileName = null;
        this.path = null;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
