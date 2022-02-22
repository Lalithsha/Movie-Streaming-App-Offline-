package com.lalithsharma.moviestreamingapp.Model;

public class CategoryItem {

    Integer id;
    String movieName;
    String imageUri;
    String fileUrl;

    public CategoryItem(Integer id, String movieName, String imageUri, String fileUrl) {
        this.id = id;
        this.movieName = movieName;
        this.imageUri = imageUri;
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
