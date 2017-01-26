package bookboot.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "qrrequests")
public class Qrrequests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pkqrrequests;   
    private String link;
    private String image_uid;
    
    @Column(name = "creadate", insertable = false, updatable = false, columnDefinition = " timestamp default now()")
    private Date creadate;
    
 
    public Qrrequests() {
        // nop
    }
 
    public Qrrequests(String uuid, String link) {
        this.image_uid = uuid;
        this.link=link;
        
    }
 
    public long getPkQrRequests() {
        return pkqrrequests;
    }
 
    public void setPkQrRequests(long pkqrrequests) {
        this.pkqrrequests = pkqrrequests;
    }
 
    public String getLink() {
        return link;
    }
    
    public void setLink(String content) {
        this.link = content;
    }
 
    public String image_uid() {
        return image_uid;
    }
 
    public void setImage_uid(String image_uid) {
        this.image_uid = image_uid;
    }
    
    @Override
    public String toString() {
        return String.format("qrrequests[pkqrrequests=%d, content='%s']", pkqrrequests, link);
    }
}