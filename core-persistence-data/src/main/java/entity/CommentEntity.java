package entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentID ;

    @Column(name = "content")
    private String content ;

    @Column(name = "createdate")
    private String createDate ;

//----------------------------------------------------------

    // tạo khóa ngoại và mối quan hệ giữa 2 bảng
    //1 : lk với bảng User
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    //2 : lk với bảng listenGuideLine
    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenGuideLineEntity listenGuideLineEntity;

//----------------------------------------------------------

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ListenGuideLineEntity getListenGuideLineEntity() {
        return listenGuideLineEntity;
    }

    public void setListenGuideLineEntity(ListenGuideLineEntity listenGuideLineEntity) {
        this.listenGuideLineEntity = listenGuideLineEntity;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
