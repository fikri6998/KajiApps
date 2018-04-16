package mobivision.kajiapps.model;

import android.widget.EditText;

public class Post {
    String id;
    private String userID;
    private String username;
    private String titlePost;
    private String post;
    private String imagePost;
    public Long timestamp;
    public String lokasi;
    public String ustadz;
    public String waktu;


    //Wajib kasih Constructor Kosong
    public Post() {
    }

    public Post(String id, String userID, String username, String mImagePost, String titlePost, String post, String mUstadz, String mLokasi, String mWaktu, Long timestamp) {
        this.id = id;
        this.username = username;
        this.imagePost = mImagePost;
        this.titlePost = titlePost;
        this.post = post;
        this.userID = userID;
        this.timestamp = timestamp;
        this.lokasi = mLokasi;
        this.ustadz = mUstadz;
        this.waktu = mWaktu;
        

    }

    public Post(String id, String userId, String name, String download_url, String title, String postMessage, EditText mUstadzPengisi, EditText mLokasi, EditText mWaktu, long timestamp) {

    }

    public String getImagePost() {
        return imagePost;
    }

    public String getUserID() {
        return userID;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public String getPost() {
        return post;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getUstadz() {
        return ustadz;
    }

    public String getWaktu() {
        return waktu;
    }
    
    
}
