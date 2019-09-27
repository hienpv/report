package appvn.report.dto;

import java.util.List;

public class StoryHomeResponseDto {
    private int categoryId;
    private String categoryName;
    private List<StoryDto> stories;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<StoryDto> getStories() {
        return stories;
    }

    public void setStories(List<StoryDto> stories) {
        this.stories = stories;
    }
}
