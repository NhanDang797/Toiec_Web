package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "listenguideline")

public class ListenGuideLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuideID;

    @Column(name = "title")
    private String titile;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "createdate")
    private Timestamp createDate;

    @Column(name = "modifydate")
    private Timestamp modifyDate;

    //----------------------------------------------------------

    @OneToMany(mappedBy = "listenGuideLineEntity" , fetch = FetchType.LAZY)
    private List<CommentEntity> commentList ;

    //----------------------------------------------------------

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }


    public Integer getListenGuideID() {
        return listenGuideID;
    }

    public void setListenGuideID(Integer listenGuideID) {
        this.listenGuideID = listenGuideID;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }
}
