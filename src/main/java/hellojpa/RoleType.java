package hellojpa;

public enum RoleType {
    GUEST, USER, ADMIN
    //ROLE_TYPE을 ORDINAL로 지정하면 숫자로 저장되는데, 숫자로 저장하면 데이터가 변경되면 순서가 바뀔 수 있기 때문에 STRING으로 지정해주는 것이 좋다.
}
