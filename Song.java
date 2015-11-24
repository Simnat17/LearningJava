package music;

import java.io.Serializable;
import javax.persistence.*;


@Entity

// è necessaria la serializable per gli opendb?
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

  // campo ID e generato automaticamente
   @Id @GeneratedValue
    private long id;
    
    
    // campi base (E che compariranno come attributi della tabella Song)
 
   	private String title;
    private String fileType;
    private boolean isCompressed;
    private short bitRate;
    private long length;
    private long size;
    private String pathname;
 
 
 
   // costruttori
    public Song() {
    }
	 
    
   Song(String title,String fileType, boolean isCompressed, short bitRate, long length, long size, String pathname) {
       this.title=title;
       this.fileType=fileType;
       this.isCompressed=isCompressed;
       this.bitRate=bitRate;
       this.length=length;
       this.size=size;
       this.pathname=pathname;
   }
   
   Song(String title){
	   this.title=title;
   }
   
   Song(String title, long length){
	   this.title=title;
	   this.length=length;
   }
   
   
   // override di toString
   @Override
   public String toString() {
	   return "Nome canzone: "+title
			   +", Tipo di file: "+fileType
			   +", Formato compresso: "+ (isCompressed ? "Sì" : "No")
			   +", Bitrate: "+bitRate
			   +", Durata: "+length
			   +", Dimensione "+size
			   +", Percorso file: "+pathname
			   ;
   }
   
}

