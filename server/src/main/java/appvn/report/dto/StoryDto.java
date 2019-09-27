package appvn.report.dto;

import java.util.Date;

public class StoryDto {
    private int id;
    private String categoryId;
    private Integer authorId;
    private String authorName;
    private String urlImg;
    private String name;
    private int chapterNum;
    private int status;
    private int countRead;
    private String description;
    private Date updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCountRead() {
        return countRead;
    }

    public void setCountRead(int countRead) {
        this.countRead = countRead;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public StoryDto() {

    }

    public StoryDto(int id, Integer authorId, String categoryId, String urlImg, String name, int chapterNum, int status,
            int countRead, String authorName) {
        this.id = id;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.urlImg = urlImg;
        this.name = name;
        this.chapterNum = chapterNum;
        this.status = status;
        this.countRead = countRead;
        this.authorName = authorName;
    }

}
