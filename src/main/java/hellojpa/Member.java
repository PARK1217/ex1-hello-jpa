package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(
//        name = "NAME_AGE_UNIQUE",
//        columnNames = {"NAME", "AGE"}
//)})
//테이블에 유니크 제약조건을 걸어줌
//컬럼별로 유니크 제약조건을 걸게되면 랜덤으로 이름을 지정하기때문에 @Table 어노테이션을 사용하여 이름을 지정해줌
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)    //nullable = false -> not null제약조건
    // insertable = false, updatable = false -> 읽기 전용
    private String username;

    private Integer age;

    @Enumerated    //EnumType.ORDINAL -> 숫자로 저장(default), EnumType.STRING -> 문자열로 저장(이름을 그대로 저장)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob    //큰 데이터를 저장할 때 사용   //CLOB -> String, BLOB -> byte[]
    private String description;
    @Transient  //DB에 매핑 안함
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
