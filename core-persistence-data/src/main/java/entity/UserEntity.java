package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

// JPA Anotation
@Entity               //giúp mặc định class này là 1 entity
@Table(name = "user") //kết nối với bảng trên DB
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID; /* khóa chính , tự tăng */

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "createdate")
    private Timestamp createDate;
//----------------------------------------------------------

    // tạo khóa ngoại và mối quan hệ giữa 2 bảng
    //1 : lk với bảng role
    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity roleEntity;

    //2 : lk với bảng Comment
    @OneToMany(mappedBy = "userEntity" , fetch = FetchType.LAZY)
    private List<CommentEntity> commentList ;

//----------------------------------------------------------
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
