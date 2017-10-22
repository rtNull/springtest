package com.zyq.springtest.bean;

public class Question {
    private Integer id;

    private Integer chapterId;

    private Boolean ischoice;

    private String title;

    private String answer;

    private String explanation;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public Question() {
    }

    public Question(Integer chapterId, String title, String answer, String explanation) {
        this.chapterId = chapterId;
        this.title = title;
        this.answer = answer;
        this.explanation = explanation;
    }

    public Question(Integer chapterId, Boolean ischoice, String title, String answer, String explanation) {
        this.chapterId = chapterId;
        this.ischoice = ischoice;
        this.title = title;
        this.answer = answer;
        this.explanation = explanation;
    }

    public Question(Integer chapterId, Boolean ischoice, String title, String answer, String explanation, String optionA, String optionB, String optionC, String optionD) {
        this.chapterId = chapterId;
        this.ischoice = ischoice;
        this.title = title;
        this.answer = answer;
        this.explanation = explanation;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public Question(Integer id, Integer chapterId, Boolean ischoice, String title, String answer, String explanation, String optionA, String optionB, String optionC, String optionD) {
        this.id = id;
        this.chapterId = chapterId;
        this.ischoice = ischoice;
        this.title = title;
        this.answer = answer;
        this.explanation = explanation;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Boolean getIschoice() {
        return ischoice;
    }

    public void setIschoice(Boolean ischoice) {
        this.ischoice = ischoice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", chapterId=" + chapterId +
                ", ischoice=" + ischoice +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                ", explanation='" + explanation + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                '}';
    }
}