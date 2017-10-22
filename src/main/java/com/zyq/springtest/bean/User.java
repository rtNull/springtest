package com.zyq.springtest.bean;

public class User {
    @Override
	public String toString() {
		return "User [id=" + id + ", tel=" + tel + ", password=" + password
				+ ", name=" + name + ", sex=" + sex + ", headImg=" + headImg
				+ ", role=" + role + ", token=" + token + ", introduction="
				+ introduction + "]";
	}

    public User() {
    }

    public User(String tel, String password) {
        this.tel = tel;
        this.password = password;
    }

    public User(String tel, String password, String name) {
        this.tel = tel;
        this.password = password;
        this.name = name;
    }

    public User(String tel, String password, String name, Byte sex, Byte role) {
        this.tel = tel;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.role = role;
    }

    public User(String tel, String password, String name, String token) {
        this.tel = tel;
        this.password = password;
        this.name = name;
        this.token = token;
    }

    public User(Integer id, String tel, String password, String name, Byte sex, String headImg, Byte role, String token, String introduction) {
        this.id = id;
        this.tel = tel;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.headImg = headImg;
        this.role = role;
        this.token = token;
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return tel.equals(user.tel);
    }

    @Override
    public int hashCode() {
        return tel.hashCode();
    }

    private Integer id;

    private String tel;

    private String password;

    private String name;

    private Byte sex;

    private String headImg;

    private Byte role;

    private String token;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}