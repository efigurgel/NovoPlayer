
package Controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
/**
 *
 * @author helder
 */
public class Playlist {
    
    JFileChooser fc = new JFileChooser();
    public ArrayList ls = new ArrayList();
    
    public void add(JFrame frame){
        fc.setMultiSelectionEnabled(true);
        int validaArquivo = fc.showOpenDialog(frame);
        if(validaArquivo == javax.swing.JFileChooser.CANCEL_OPTION){
            
            return;        
        }else if(validaArquivo == javax.swing.JFileChooser.APPROVE_OPTION){
        
            File[] file = fc.getSelectedFiles();
            ls.addAll(Arrays.asList(file));
        }
    }
    
    public ArrayList getListSong(){
        
        return ls;
    
    }
    
    
    //salvar playlist
    FileOutputStream fos;
    
    ObjectOutputStream oos;
    
    public void salvarPlaylist(JFrame frame){
        
        fc.setMultiSelectionEnabled(false);
        int valida = fc.showSaveDialog(frame);
        if(valida == javax.swing.JFileChooser.CANCEL_OPTION){
            
            return;        
        }else if(valida == javax.swing.JFileChooser.APPROVE_OPTION){
        
            File pls = fc.getSelectedFile();
            
            try {
                fos =  new FileOutputStream(pls + ".tgr");
                oos = new ObjectOutputStream(fos);
                for(int i = 0; i < ls.size(); i++){
                    File tmp = (File) ls.get(i);
                    oos.writeObject(tmp);
                }
                
                oos.close();
            } catch (Exception e) {
            
                
            }
        }
        
    }
    FileInputStream fis;
    ObjectInputStream ois;
    
    public void abrirPls(JFrame frame){
        
        fc.setMultiSelectionEnabled(false);
        int valida = fc.showOpenDialog(frame);
        if(valida == javax.swing.JFileChooser.CANCEL_OPTION){
            
            return;
        }
        
        if(valida == javax.swing.JFileChooser.APPROVE_OPTION){
            File pls = fc.getSelectedFile();
            
            try {
                fis = new FileInputStream(pls);
                ois = new ObjectInputStream(fis);
                File  tmp;
                
                while((tmp = (File) ois.readObject()) != null){
                    ls.add(tmp);
                
                }
                
                if((tmp = (File) ois.readObject()) != null){
                    ls.isEmpty();
                }
                
                ois.close();
            } catch (Exception e) {
            }
        
        }
    }
}
