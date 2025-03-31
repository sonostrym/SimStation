package mvc;

import java.io.Serializable;

/*
Vinzent Schubert 3/13 10:10
 */

public class Model extends Publisher implements Serializable {
    private String fileName;
    private boolean unsavedChanges = false;

    public void changed(){
        unsavedChanges = true;
        notifySubscribers();
    }

    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public boolean getUnsavedChanges(){
        return unsavedChanges;
    }
    public void setUnsavedChanges(boolean state){
        this.unsavedChanges = state;
    }
}
